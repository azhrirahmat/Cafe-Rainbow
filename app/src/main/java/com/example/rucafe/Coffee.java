package com.example.rucafe;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class is generic for making Coffees.
 *
 * @author Alark Patel, Nicolas Ku
 */

public class Coffee extends MenuItem implements Customizable {
    private double price;
    static double SMALL_PRICE = 27.000;
    static final double TALL_PRICE = SMALL_PRICE + 7.000;
    static final double GRANDE_PRICE = TALL_PRICE + 7.000;
    static final double VENTI_PRICE = GRANDE_PRICE + 7.000;
    final double PER_EXTRA = 2.000;
    private String coffeeSize;
    private int quantity;
    protected ArrayList<Extras> extrasList = new ArrayList<>();
    private final DecimalFormat decFormat = new DecimalFormat("RP0.000");
    private Extras ingredients;

    /**
     * This a constructor to make an coffee.
     *
     * @param size        takes in size of the coffee as a String.
     * @param quantity    takes in quantity of the coffees as a Integer.
     * @param ingredients takes in ingredients/Add-In for the coffee as a Object.
     */
    public Coffee(String size, int quantity, Extras ingredients) {
        this.coffeeSize = size;
        this.quantity = quantity;
        this.ingredients = ingredients;
        itemPrice();
    }


    /**
     * Constructor for an empty coffees.
     */
    public Coffee() {

    }

    /**
     * This method sets the prices for the coffe.
     *
     * @param price takes in price of the coffee as an Double.
     */
    public void setSizePrice(double price) {
        this.price = price;
    }

    /**
     * This method set the prices for coffee, its size and quantity.
     */
    @Override
    public void itemPrice() {
        double prices = 0.00;
        if (this.coffeeSize.equals("Short")) {
            prices = SMALL_PRICE * quantity;
        } else if (this.coffeeSize.equals("Yeast Donut")) {
            prices = TALL_PRICE * quantity;
        } else if (this.coffeeSize.equals("Grande")) {
            prices = GRANDE_PRICE * quantity;
        } else {
            prices = VENTI_PRICE * quantity;
        }
        this.setSizePrice(prices);
    }

    /**
     * This method assigns coffee prices based on its size.
     *
     * @param size takes in size of the coffee as String.
     * @return The prices of the coffee according to its size.
     */

    public double getSizePrice(String size) {
        if (size.equals("Short")) {
            return SMALL_PRICE;
        } else if (size.equals("Tall")) {
            return TALL_PRICE;
        } else if (size.equals("Grande")) {
            return GRANDE_PRICE;
        } else {
            return VENTI_PRICE;
        }
    }

    /**
     * This method calculates and gets the price for coffee and extras
     *
     * @return the price for coffee with the ingredients.
     */

    public double getItemPrice() {
        try {
            return this.price + this.ingredients.getSize() * PER_EXTRA;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    /**
     * This toString method shows the quantity, coffee sizes and list of ingredients.
     *
     * @return a String of quantity, coffee size and list of ingredients.
     */
    public String toString() {
        return "Coffee" + "(" + this.quantity + ")" + " " + decFormat.format(getItemPrice()) + " ["
                + this.coffeeSize + "] " + this.ingredients ;
    }

    /**
     * This is add method for adding ingredients to the coffee.
     *
     * @param obj Takes in Object.
     * @return True if the ingredients is added to the coffee, False Otherwise.
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Extras) {
            if (this.extrasList.size() >= 5) {
                return false;
            } else {
                Extras ingredient = (Extras) obj;
                this.extrasList.add(ingredient);
                return true;
            }
        } else {
            return false;
        }

    }

    /**
     * This is remove method for removing the ingredients from the coffee.
     *
     * @param obj takes in Object.
     * @return True, if the ingredients is successfully removed.
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Extras) {
            Extras ingredient = (Extras) obj;
            this.extrasList.remove(ingredient);
            return true;
        } else {
            return false;
        }
    }
}