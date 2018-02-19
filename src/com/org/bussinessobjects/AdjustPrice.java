package com.org.bussinessobjects;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Himanshu Singh on 18/02/2018.
 *
 * Class Name: AdjustPrice
 *
 *      Performs Add, Subtract and Multiply adjustment operations for a given product type.
 *
 */

public class AdjustPrice {

    // adjustedPrice holds the adjusted price value
    private double adjustedPrice;

    // product holds the Product object.
    private Product product;

    // Constructor takes Product as argument.
    public AdjustPrice(Product product) {
        this.product = product;
        this.adjustedPrice = 0.0;
    }

    /* Performs a reflection method call based on the adjustment operator requested e.g, add, subtract, multiply.
     * Calling public methods is fine here else setAccessible should be set to true for private methods.
     * @returns adjusted price value
    */
    public double getAdjustedPrice() {
        String adjustmentMethod = String.format("%sPrice", product.getAdjustmentOperator().toLowerCase());
        try {
            Method method = this.getClass().getMethod(adjustmentMethod,null);
            method.invoke(this,null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return adjustedPrice;
    }

    // void transaction. Adds product totalprice with the requested price value.
    public void addPrice() {
        this.adjustedPrice = this.product.getTotalPrice() + ( this.product.getTotalQuantity() * this.product.getProductPrice() );
    }

    // void transaction. Subtracts product totalprice with the requested price value.
    public void subtractPrice() {
        this.adjustedPrice = this.product.getTotalPrice() - (this.product.getTotalQuantity() * this.product.getProductPrice());
    }

    // void transaction. Multiplies product total price and quantity with the requested price and appends to existing total value.
    public void multiplyPrice() {
        this.adjustedPrice = this.product.getTotalPrice() +
                (this.product.getTotalPrice() * this.product.getProductPrice()) +
                (this.product.getTotalQuantity() * this.product.getProductPrice());
    }

    // @returns [String] e.g "Performed Add 20p to 21 apples and price adjusted from 2.10p to 6.30p"
    public String adjustmentReport(){
        String adjustmentReport = String.format(
                "Performed %s %.2fp to %d %s and price adjusted from %.2fp to %.2fp",
                this.product.getAdjustmentOperator(),
                this.product.getProductPrice(),
                this.product.getTotalQuantity(),
                this.product.getProductType(),
                this.product.getTotalPrice(),
                this.adjustedPrice
        );
        return adjustmentReport;
    }

}
