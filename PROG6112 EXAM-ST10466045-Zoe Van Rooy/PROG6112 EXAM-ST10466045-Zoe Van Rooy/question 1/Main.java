/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsales;

/**
 *
 * @author RC_Student_Lab
 */
public class Main {
 public static void main(String[]args){
     int[][] productSales = {
         {300, 150 700},
         {250, 200, 600}
     };

ProductSales sales = newProductales();
 
System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("Total sales: " + sales.TotalSales(productSales));
        System.out.println("Average sales: " + sales.AverageSales(productSales));
        System.out.println("Maximum sale: " + sales.MaxSale(productSales));
        System.out.println("Minimum sale: " + sales.MinSale(productSales));
}

