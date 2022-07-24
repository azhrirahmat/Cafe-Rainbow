package com.example.rucafe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class controls the activity and functions of my orders.
 * @author ALark Patel, Nicolas Ku
 */
public class MyOrdersActivity extends AppCompatActivity {

    private final DecimalFormat decFormat = new DecimalFormat("Rp0.000; 0.000");
    private ListView orders;
    private TextView subtotalText, salesTaxText, totalText;
    private AlertDialog.Builder builder;

    /**
     * This is the creation of the activity for my orders page.
     * @param savedInstanceState Bundle of activities' previous state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_orders);

        subtotalText = (TextView)findViewById(R.id.subtotal);
        salesTaxText = (TextView) findViewById(R.id.salesTax);
        totalText = (TextView) findViewById(R.id.totalText);
        initialize();
    }

    /**
     * This method handles the initialization of the activity.
     * Once class and activity are created, the Views are populated.
     * Includes inner methods for onClick and onSelected activities.
     */
    private void initialize(){

        orders = (ListView) findViewById(R.id.orderList);
        ArrayList<String> orderInString = MainMenuActivity.order.ordersToString();
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orderInString );
        orders.setAdapter(itemsAdapter);
        setTotalPrices();

        orders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * Handles the selection of the order from the list view.
             * @param parent adapter view used for the method.
             * @param view status of the item selected.
             * @param position position in the spinner class.
             * @param id id of the listview and item selected
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String currOrder =  (String) parent.getItemAtPosition(position);
                builder = new AlertDialog.Builder(MyOrdersActivity.this);
                builder.setTitle("Remove Item");
                builder.setMessage("Do you want to remove this item? ");
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    /**
                     * This method handles the "Yes" selection for the alert to remove item.
                     * @param dialog Dialog page shown in app.
                     * @param which Selection either yes or no.
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainMenuActivity.order.remove(currOrder);
                        Toast.makeText(MyOrdersActivity.this, "Item Removed.", Toast.LENGTH_SHORT).show();
                        initialize();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    /**
                     * This method handles the "No" selection for the alert to remove item.
                     * @param dialog Dialog page shown in app.
                     * @param which Selection either yes or no.
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
               AlertDialog alertDialog =  builder.create();
               alertDialog.show();
               setTotalPrices();
            }
        });

    }

    /**
     * Method to handle the displaying of prices in the page.
     * Formats the subtotal, sales tax and total of the total order.
     */
    private void setTotalPrices() {
        double subtotal = MainMenuActivity.order.getTotal();
        String subTotalStr = decFormat.format(subtotal);
        subtotalText.setText("Subtotal: " + subTotalStr);
        String subTotalTaxed = decFormat.format(subtotal * MainMenuActivity.order.TAX_PERCENTAGE);
        salesTaxText.setText("Sales Tax: " +subTotalTaxed);
        String total = decFormat.format(subtotal * MainMenuActivity.order.TAX_PERCENTAGE + subtotal);
        totalText.setText("Total: " +total);
    }

    /**
     * This method handles the click of placing order button in the page.
     * Sends the current order to the store orders.
     * @param view event once it is clicked and status.
     */
    public void placeOrder(View view){
        if(MainMenuActivity.order.getSizeOrder()==0){
            Toast toast = Toast.makeText(getBaseContext(), "There are no current orders to place. Try again", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            MainMenuActivity.storeOrder.add(MainMenuActivity.order);
            MainMenuActivity.resetOrder();
            Toast.makeText(MyOrdersActivity.this, "Your order has been placed.", Toast.LENGTH_SHORT).show();
            initialize();
        }

    }
}