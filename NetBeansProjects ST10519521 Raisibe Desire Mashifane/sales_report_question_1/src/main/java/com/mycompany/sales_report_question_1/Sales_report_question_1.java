package com.mycompany.sales_report_question_1;
import java.util.Scanner;
public class Sales_report_question_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
    //Creating arrays 
        String [] products = {" Cozy Nights Monarch Mattress ", " Restonic Barbados Mattress ", " Sealy Phuket Mattress "};
        String [] months = {" Month 1 ", " Month 2 ", " Month 3 "};
        int sales [][] = new int[3][3];
        int [] productTotals = new int[3];
         int total = 0;
         double average = 0;
         int mostPopularIndex=0;
    //Asking user for  information     
         for (int i = 0; i < products.length; i++){
             for (int j = 0 ; j < months.length; j++){
                 
                 total = total + sales[i][j];
                 productTotals[i] = productTotals[i] + sales[i][j];
                 
          System.out.print(" Enter number of sales for " + months[j] + "for" + products[i] + ":" );        
                 sales [i][j] = input.nextInt();
                 
         if (productTotals[i] > productTotals[mostPopularIndex]){
             mostPopularIndex = i;
             }
         }
         average = total/9;
         
         }
        //Display infromation
         System.out.println("");
         System.out.println("Products Sales report - 2026");
         System.out.println("");
         System.out.println("************************************");        
         
         System.out.println("Totla Product Sale:" + total);
         System.out.println("Average product sales: " + average);
         System.out.println("MOst popular product: ");
         
         input.close();
    }
}
