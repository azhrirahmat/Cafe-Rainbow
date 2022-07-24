package com.example.rucafe;

import java.text.DecimalFormat;

/**
 * This class is the generic object for creating donuts.
 * @author Alark Patel, Nicolas Ku
 *
 */

public class Donut extends MenuItem {
    private double price;
    static final double DONUT_PRICE = 21.500;
    private int quantity;
    private String donutFlavor;
    private final DecimalFormat decFormat = new DecimalFormat("Rp0.000");

    /**
     * This is constructor that creates new Donut with quantity and flavor.
     *
     * @param flavor      takes in flavor of donut as a String.
     * @param quantity    takes in quantity of donuts as an Integer.
     *
     */

    public Donut(String flavor, int quantity) {
        this.donutFlavor = flavor;
        this.quantity = quantity;
        itemPrice();
    }

    /**
     * This method sets the price for donuts.
     *
     * @param price takes in the price as a Double.
     */

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This method assigns the prices according to the quantity.
     */
    @Override
    public void itemPrice() {
        this.setPrice(DONUT_PRICE * quantity);
    }

    /**
     * This method gets the price of the donuts with its type and quantity by calling item price
     * method above it.
     *
     * @return the price of the donuts type and quantity.
     */
    public double getPrice() {
        itemPrice();
        return this.price;
    }


    /**
     * This is toString method to get donut flavors and its quantity plus the prices of the donut.
     *
     * @return donut flavors and it quantity in round brackets plus the price.
     */
    public String toString() {
        return this.donutFlavor + "(" + this.quantity + ")" + " " + decFormat.format(this.price);
    }


}