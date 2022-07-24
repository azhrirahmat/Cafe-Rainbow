package com.example.rucafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

/**
 * This class controls the main page of the android app.
 * @author Alark Patel, Nicolas Ku
 */

public class MainMenuActivity extends AppCompatActivity {
    protected static Order order = new Order();
    protected static StoreOrders storeOrder = new StoreOrders();

    /**
     * This is the creation of the application activity.
     * @param savedInstanceState Bundle of activities' previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is for changing the activity for ordering donut.
     *
     * @param  view View when order coffee button is pressed.
     */
    public void handleOrderDonuts(View view){
        setContentView(R.layout.ordering_donuts);
        Intent intent = new Intent(this,OrderingDonutsActivity.class);
        startActivity(intent);

    }

    /**
     * This method is for changing the activity for ordering coffee.
     *
     * @param  view View when order coffee button is pressed.
     */
    public void handleOrderCoffee(View view){
        setContentView(R.layout.ordering_coffee);
        Intent intent = new Intent(this, OrderingCoffeeActivity.class);
        startActivity(intent);
    }

    /**
     * This method is for changing the activity for viewing myOrders.
     *
     * @param  view View when my orders button is pressed.
     */
    public void handleMyOrders(View view){
        setContentView(R.layout.my_orders);
        Intent intent = new Intent(this,MyOrdersActivity.class);
        startActivity(intent);
    }

    /**
     * This method is for changing the activity for viewing store orders.
     *
     * @param  view View when store orders button is pressed.
     */
    public void handleStoreOrders(View view){
        setContentView(R.layout.store_orders);
        Intent intent = new Intent(this,StoreOrdersActivity.class);
        startActivity(intent);
    }

    /**
     * This method resets the order once it has been added to the store orders.
     */
    protected static void resetOrder() {
        order = new Order();
    }


}




