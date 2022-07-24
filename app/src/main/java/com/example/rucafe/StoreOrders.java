package com.example.rucafe;

import java.util.ArrayList;

/**
 * This method stores the orders.
 * @author Alark Pate, Nicolas Ku
 *
 */

public class StoreOrders implements Customizable {
    private ArrayList<Order> storeOrders;

    /**
     * This method creates a new ArrayList for stored orders.
     *
     */
    public StoreOrders() {
        this.storeOrders = new ArrayList<>();
    }

    /**
     * This method adds object to store orders listview.
     *
     * @param obj order to be removed.
     * @return True, if the order is successfully stored, False otherwise.
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Order) {
            Order ordAdd = (Order) obj;
            this.storeOrders.add(ordAdd);
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method removes the orders from the list view.
     *
     * @param obj order to be removed.
     * @return True, if the orders is sucessfully removed, False otherwsie.
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Order) {
            Order ordRemove = (Order) obj;
            this.storeOrders.remove(ordRemove);
            return true;
        }else if(obj instanceof String){
            String ord = (String) obj;
            for(Order order: this.storeOrders){
                if(ord.equals(order.toString())){
                    storeOrders.remove(order);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * This is toString method that converts the total value into string.
     *
     * @return a string of item that is selected.
     */
    @Override
    public String toString() {
        String res = "";
        for (Order order : this.storeOrders) {
            res += "Order Number: " + order.getOrderNum() + "\n";
            for (String item : order.ordersToString()) {
                res += item + "\n";
            }
            res += order.getTotalTaxed() + "\n";
            res += "\n";
        }

        return res;
    }


    /**
     * This method is used to return the current list of orders.
     * @return List of Order objects
     */
    public ArrayList<Order> getStoreOrders(){
        return this.storeOrders;
    }
}