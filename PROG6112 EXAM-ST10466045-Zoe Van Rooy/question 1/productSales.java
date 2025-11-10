/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsales;

/**
 *
 * @author RC_Student_Lab
 */
public abstract class productSales implements IProductSales {

@Override
    public int TotalSales(int[][] productSales) {
        int total = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                total += sale;
            }
        }
        return total;
    }

    @Override
    public double AverageSales(int[][] productSales) {
        int total = TotalSales(productSales);
        int count = 0;
        for (int[] year : productSales) {
            count += year.length;
        }
        return (double) total / count;
    }

    @Override
    public int MaxSale(int[][] productSales) {
        int max = Integer.MIN_VALUE;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale > max) {
                    max = sale;
                }
            }
        }
        return max;
    }

    @Override
    public int MinSale(int[][] productSales) {
        int min = Integer.MAX_VALUE;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale < min) {
                    min = sale;
                }
            }
        }
        return min;
    }
}  

