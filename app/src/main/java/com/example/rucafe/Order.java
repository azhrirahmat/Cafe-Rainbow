package com.example.rucafe;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class handles orders for coffee and donuts.
 * @author Alark Patel, Nicolas Ku
 *
 */
public class Order implements  Customizable{
    protected static int UNIQUE_ORDER_NUMBER = 1;
    protected static final double TAX_PERCENTAGE = 0.06625;
    private double total = 0.0;
    private int orderNum;
    private ArrayList<MenuItem> MENU_ITEMS;
    private DecimalFormat decFormat = new DecimalFormat("Rp0.000; 0.000");

    /**
     * This constructor creates orders for coffees and donuts.
     */
    public Order(){
        this.orderNum = UNIQUE_ORDER_NUMBER;
        MENU_ITEMS = new ArrayList<>();
        UNIQUE_ORDER_NUMBER++;
    }


    /**
     * Method returns the size of the order.
     * @return size of list that holds order.
     */
    public int getSizeOrder(){
        return this.MENU_ITEMS.size();
    }

    /**
     * This method converts the list of orders to string.
     *
     * @return a list of orders as String type.
     */
    public ArrayList<String> ordersToString(){
        ArrayList<String> orderListString = new ArrayList<>();
        for (MenuItem orderItem : this.MENU_ITEMS) {
            orderListString.add(orderItem.toString());
        }
        return orderListString;
    }

    /**
     * This method gets the total of all items in the order list.
     *
     * @return a Double of a total price.
     */
    public double getTotal(){
        double isTotal = 0;
        for(MenuItem order : this.MENU_ITEMS){
            if(order instanceof Coffee){
                (order).itemPrice();
                isTotal += ((Coffee) order).getItemPrice();
            }
            else if(order instanceof Donut){
                isTotal += ((Donut) order).getPrice();
            }
        }
        this.total = isTotal;
        return this.total;
    }

    /**
     * This method gets the total with the taxes included.
     *
     * @return a String of total including the tax.
     */
    public String getTotalTaxed(){
        String res = decFormat.format(this.total + this.total * TAX_PERCENTAGE);
        return res;


    }



    /**
     * This method adds the object to menu item list.
     *
     * @param obj Object MenuItem to be added to order.
     * @return True, if the object is successfully added, False otherwise.
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Coffee){
            Coffee coffeeOrder = (Coffee) obj;
            MENU_ITEMS.add(coffeeOrder);
            return true;
        }
        else if (obj instanceof Donut){
            Donut donutOder = (Donut) obj;
            MENU_ITEMS.add(donutOder);
            return true;
        }
        return false;
    }

    /**
     * This method removes the object from menu items list.
     *
     * @param obj MenuItem to be removed to order.
     * @return True, if the items are successfully removed, False otherwise.
     */
    @Override
    public boolean remove(Object obj) {
        if(orderNum<0){
            return false;
        }
        if(obj instanceof MenuItem){
            MENU_ITEMS.remove(obj);
            return true;
        }

        else if(obj instanceof String){
            String ingredient = (String) obj;
            for(MenuItem item : MENU_ITEMS){
                if(ingredient.equals(item.toString())){
                    MENU_ITEMS.remove(item);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    public String toString() {
        String res = "Order #" + this.orderNum + "\n";
        for (String order : ordersToString()){
            res += order + "\n";
        }
        res += "Order total: " + this.getTotalTaxed() + "(subtotal: " + decFormat.format(this.getTotal()) + ",tax: " + decFormat.format(TAX_PERCENTAGE*this.getTotal())+ ")";
        return res;

    }

    /**
     * This method gets a order number.
     *
     * @return a int of a order number.
     */
    public int getOrderNum(){
        return this.orderNum;
    }
}