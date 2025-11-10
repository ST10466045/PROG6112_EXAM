/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesapplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class ProductSalesApp  extends JFrame {
    
    private JTextArea textArea;
    private JLabel yearsLabel;
    private int[] salesData = {200, 300, 600, 400, 700, 100};
    private int salesLimit = 500;

    public ProductSalesApp() {
        setTitle("Product Sales Data");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Menu setup
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);
        menuBar.add(toolsMenu);

        // Text area for displaying data
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Label for years processed
        yearsLabel = new JLabel("Years Processed: " + salesData.length);
        add(yearsLabel, BorderLayout.SOUTH);

        // Add actions
        loadItem.addActionListener(e -> loadProductData());
        saveItem.addActionListener(e -> saveProductData());
        clearItem.addActionListener(e -> clearData());

        setVisible(true);
    }

    private void loadProductData() {
        int totalSales = 0;
        int salesOverLimit = 0;
        int salesUnderLimit = 0;

        for (int sale : salesData) {
            totalSales += sale;
            if (sale > salesLimit) salesOverLimit++;
            else salesUnderLimit++;
        }
        double averageSales = (double) totalSales / salesData.length;

        String output = "DATA LOG\nTotal Sales: " + totalSales +
                "\nAverage Sales: " + String.format("%.2f", averageSales) +
                "\nSales over limit: " + salesOverLimit +
                "\nSales under limit: " + salesUnderLimit;
        textArea.setText(output);
    }

    private void saveProductData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "Data saved to data.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
        }
    }

    private void clearData() {
        textArea.setText("");
        yearsLabel.setText("Years Processed: 0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductSalesApp::new);
    }
}