/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesapplication;

/**
 *
 * @author RC_Student_Lab
 */
public class ProductSales implements IProductSales{
    
    private int[] productSales;
    private int salesLimit;

    public ProductSales(int[] productSales, int salesLimit) {
        this.productSales = productSales;
        this.salesLimit = salesLimit;
    }

    public int[] GetProductSales() {
        return productSales;
    }

    public int GetTotalSales() {
        int total = 0;
        for (int sale : productSales) {
            total += sale;
        }
        return total;
    }

    public int GetSalesOverLimit() {
        int count = 0;
        for (int sale : productSales) {
            if (sale > salesLimit) count++;
        }
        return count;
    }

    public int GetSalesUnderLimit() {
        int count = 0;
        for (int sale : productSales) {
            if (sale <= salesLimit) count++;
        }
        return count;
    }

    public int GetProductsProcessed() {
        return productSales.length;
    }

    public double GetAverageSales() {
        return (double) GetTotalSales() / GetProductsProcessed();
    }
}

