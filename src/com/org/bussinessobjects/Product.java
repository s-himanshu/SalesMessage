package com.org.bussinessobjects;

/**
 * Created by Himanshu Singh on 18/02/2018.
 *
 * Class Name: Product
 *
 *      A product class contains the product details such as it's type, price
 *      quantity, and stores total price value and quantity of a product.
 *      Also stores the last performed adjustment operation such as Add, Subtract
 *      and Multiply.
 */
public class Product {

    // A single product sale entry price value
    private double productPrice;

    // A single product sale entry quantity e.g apples = 1, or oranges = 3
    private int productQuantity;

    // A single product sale entry adjustment request e.g., Add or Subtract or Multiply
    private String adjustmentOperator;

    // A single product sale entry type e.g apples or oranges, etc.
    private String productType;

    // The entire product type quantity e.g., apples = 20;
    private int totalQuantity;

    // The entire product type price total value e.g., apples = 6.300000;
    private double totalPrice;

    // Constructor
    public Product(String type) {
        this.totalPrice = 0.0;
        this.totalQuantity = 0;
        this.productType = type;
        this.adjustmentOperator = null;
    }

    // Calculate the given quantity with given price and return the value
    public double calculatePrice(int productQuantity, double productPrice){
        return productQuantity * productPrice;
    }

    // Set the total price of the sale to the given value of the requested product.
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice;  }

    // Add the given value to the existing total price of the requested product.
    public void appendTotalPrice(double productPrice) {
        this.totalPrice += productPrice;
    }

    // Add the given quantity to the existing total quantity.
    public void setTotalQuantity(int quantity){
        this.totalQuantity += quantity;
    }

    // Get the total quantity of the requested product.
    public int getTotalQuantity() {
        return this.totalQuantity;
    }

    // Get the total price of the requested product.
    public double getTotalPrice() { return this.totalPrice; }

    // Get the type of the requested product.
    public String getProductType() {
        return this.productType;
    }

    // Set the type of product with the requested type.
    // @note: This won't be used much since we keep log separately.
    public void setProductType(String type) {
        this.productType = type;
    }

    // Get the price of the requested product
    public double getProductPrice() { return productPrice; }

    // Set the price of the requested product
    public void setProductPrice(double productPrice) { this.productPrice = productPrice; }

    // Get the product quantity
    public int getProductQuantity() { return productQuantity; }

    // Set the product quantity to the given value
    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }

    // Get the product adjustmentOperator and defaults to null.
    public String getAdjustmentOperator() { return adjustmentOperator; }

    // Set the product adjustmentOperator to the provided operator e.g, Add, Subtract, or Multiply.
    public void setAdjustmentOperator(String adjustmentOperator) { this.adjustmentOperator = adjustmentOperator; }

}
