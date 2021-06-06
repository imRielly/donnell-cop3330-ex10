/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Rielly Donnell
 */

package oop.example;

import java.util.Scanner;

/**
 Exercise 10 - Self-Checkout
 Working with multiple inputs and currency can introduce some tricky precision issues.

 Create a simple self-checkout system. Prompt for the prices and quantities of three items.
 Calculate the subtotal of the items. Then calculate the tax using a tax rate of 5.5%.
 Print out the line items with the quantity and total, and then print out the subtotal, tax amount, and total.

 Example Output
 Enter the price of item 1: 25
 Enter the quantity of item 1: 2
 Enter the price of item 2: 10
 Enter the quantity of item 2: 1
 Enter the price of item 3: 4
 Enter the quantity of item 3: 1
 Subtotal: $64.00
 Tax: $3.52
 Total: $67.52

 Constraints
 Keep the input, processing, and output parts of your program separate.
 Collect the input, then do the math operations and string building, and then print out the output.
 Be sure you explicitly convert input to numerical data before doing any calculations.

 Challenges
 Revise the program to ensure that prices and quantities are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
 Alter the program so that an indeterminate number of items can be entered. The tax and total are computed when there are no more items to be entered.

 */
public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double taxRate = 0.055;

        System.out.print("Enter the price of item 1: ");
        double price1 = in.nextDouble();
        System.out.print("Enter the quantity of item 1: ");
        double quantity1 = in.nextDouble();
        double total1 = calculateItemTotal(price1, quantity1);

        System.out.print("Enter the price of item 2: ");
        double price2 = in.nextDouble();
        System.out.print("Enter the quantity of item 2: ");
        double quantity2 = in.nextDouble();
        double total2 = calculateItemTotal(price2, quantity2);

        System.out.print("Enter the price of item 3: ");
        double price3 = in.nextDouble();
        System.out.print("Enter the quantity of item 3: ");
        double quantity3 = in.nextDouble();
        double total3 = calculateItemTotal(price3, quantity3);

        double subTotal = calculateSubTotal(total1, total2, total3);
        double tax = calculateTax(subTotal, taxRate);
        double total = calculateTotal(subTotal, tax);

        String result = generateReceipt(subTotal, tax, total);
        System.out.println(result);
    }

    private static double calculateItemTotal(double price, double quan) {
        return price * quan;
    }

    private static double calculateSubTotal(double t1, double t2, double t3) {
        return t1 + t2 + t3;
    }

    private static double calculateTax(double subtotal, double taxrate) {
        return subtotal * taxrate;
    }

    private static double calculateTotal(double subtotal, double tax) {
        return subtotal + tax;
    }

    private static String generateReceipt(double subt, double tax, double total) {
        String output = String.format("Subtotal: $%s\nTax: $%s\nTotal: $%s", subt, tax, total);
        return output;
    }
}