package com.example.rucafe;

import java.util.List;

/**
 * This class is for extra add-in in the coffees.
 * @author Alark Patel, Nicolas Ku
 *
 */

public class Extras extends MenuItem {
    private final List<String> ingredient;

    /**
     * Constructor for Extras that add as ingredients.
     * @param ingredients ingredients to be created.
     */
    public Extras(List<String> ingredients) {
        this.ingredient = ingredients;
    }

    /**
     * This method gets the ingredients for coffee.
     *
     * @return a String list of ingredients.
     */
    public List<String> getIngredient() {
        return ingredient;
    }

    /**
     * This method gets the size of the ingredients list.
     *
     * @return a Integer of size of the ingredients that are added to the coffee.
     */
    public int getSize() {
        return this.ingredient.size();

    }

    /**
     * This is to String method that converts the object ingredients to String.
     *
     * @return the list of String ingredients separated by commas.
     */
    @Override
    public String toString() {

        return this.ingredient.toString();
    }

    /**
     * This method if one object is equal to other or not.
     *
     * @param obj Object
     * @return True, if the one object is equals to other, False Otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Extras) {
            Extras ex = (Extras) obj;
            List<String> other_ing = ex.getIngredient();
            List<String> this_ing = this.getIngredient();
            return (this_ing.equals(other_ing));
        } else {
            return false;
        }
    }

    /**
     * Creates a price for ingredients.
     */
    @Override
    public void itemPrice() {

    }

}