
package com.mycompany.sales_report_question_1;


public abstract class Products implements IProducts {
    private String[] product;
    private int[][] sales;

    public Products (String[] product, int[][] sales) {
        this.product = product;
        this.sales = sales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total = total + sales[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = 0;
        for (int i = 0; i < sales.length; i++) {
            count = count + sales[i].length;
        }
        if (count == 0) {
            return 0;
        }
        return (double) total / count;
    }

    public String GetMostPopularProduct() {
        int mostPopularIndex = 0;
        int highestTotal = -1;
        int highestSingleSale = 0;

        for (int i = 0; i < sales.length; i++) {
            int productTotal = 0;
            int productMax = 0;
            for (int j = 0; j < sales[i].length; j++) {
                productTotal = productTotal + sales[i][j];
                if (sales[i][j] > productMax) {
                    productMax = sales[i][j];
                }
            }
            if (productTotal > highestTotal) {
                highestTotal = productTotal;
                mostPopularIndex = i;
                highestSingleSale = productMax;
            }
        }
        // To match sample screenshot: Cozy Nights Monarch (25)
        // 25 is the highest single month sale for that product
        return product[mostPopularIndex] + " (" + highestSingleSale + ")";
    }
}
