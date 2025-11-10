/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsalesapplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ProductSalesApplication extends JFrame{

    private JTextArea salesDataArea;
    private JLabel yearsProcessedLabel;
    private int[][] salesData = {
            {300, 150, 700},
            {250, 200, 600}
    };
    private final int SALES_LIMIT = 500;

    public ProductSalesApplication() {
        setLayout(new BorderLayout());

        // Create panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton loadButton = new JButton("Load Product Data");
        JButton saveButton = new JButton("Save Product Data");
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.NORTH);

        // Create text area for sales data
        salesDataArea = new JTextArea(10, 20);
        salesDataArea.setEditable(false);
        add(new JScrollPane(salesDataArea), BorderLayout.CENTER);

        // Create label for years processed
        yearsProcessedLabel = new JLabel("Years Processed: 2");
        add(yearsProcessedLabel, BorderLayout.SOUTH);

        // Load data into text area
        loadProductData();

        // Add button listeners
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadProductData();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProductData();
            }
        });

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadProductData() {
        int totalSales = 0;
        int salesOverLimit = 0;
        int salesUnderLimit = 0;

        for (int[] yearSales : salesData) {
            for (int sales : yearSales) {
                totalSales += sales;
                if (sales > SALES_LIMIT) {
                    salesOverLimit++;
                } else {
                    salesUnderLimit++;
                }
            }
        }

        int averageSales = totalSales / (salesData.length * salesData[0].length);

        String data = "Total Sales: " + totalSales + "\n";
        data += "Average Sales: " + averageSales + "\n";
        data += "Sales over limit: " + salesOverLimit + "\n";
        data += "Sales under limit: " + salesUnderLimit;

        salesDataArea.setText(data);
    }

    private void saveProductData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("product_sales.txt"))) {
            writer.write(salesDataArea.getText());
            JOptionPane.showMessageDialog(this, "Data saved to product_sales.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new ProductSalesApplication();
    }
}



   