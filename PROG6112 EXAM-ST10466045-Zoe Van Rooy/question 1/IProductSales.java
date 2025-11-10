/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.productsales;

/**
 *
 * @author RC_Student_Lab
 */
public interface IProductSales {
    int TotalSales(int[][]productSales);
    double AvergaeSales(int[][] productsales);
    int MaxSale(int[][] productSales);
    int MinSale(int[][] productsales);        
}
