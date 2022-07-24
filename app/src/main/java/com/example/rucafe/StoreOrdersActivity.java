package com.example.rucafe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

/**
 * This class controls the activity and functions of my orders.
 * @author Alark Patel, Nicolas Ku
 */
public class StoreOrdersActivity extends AppCompatActivity {

    private ListView storeOrdersList;
    private AlertDialog.Builder builder;

    /**
     * This is the creation of the activity for store orders page.
     * @param savedInstanceState Bundle of activities' previous state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders);
        storeOrdersList = findViewById(R.id.storeOrdersList);
        initialize();
    }

    /**
     * This method handles the initialization of the activity.
     * Once class and activity are created, the Views are populated.
     * Includes inner methods for onClick and onSelected activities.
     */
    private void initialize() {
        ArrayList<Order> ordersToString = MainMenuActivity.storeOrder.getStoreOrders();
        ArrayList<String> orderInString = new ArrayList<>();
        for(Order ord : ordersToString){
            orderInString.add(ord.toString());
        }

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orderInString );
        storeOrdersList.setAdapter(itemsAdapter);

        storeOrdersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * Handles the selection of the whole order from the list view.
             * @param parent adapter view used for the method.
             * @param view status of the item selected.
             * @param position position in the spinner class.
             * @param id id of the listview and item selected
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String currOrder =  (String) parent.getItemAtPosition(position);
                builder = new AlertDialog.Builder(StoreOrdersActivity.this);
                builder.setTitle("Remove Item");
                builder.setMessage("Do you want to remove this order?");
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    /**
                     * This method handles the "Yes" selection for the alert to remove order.
                     * @param dialog Dialog page shown in app.
                     * @param which Selection either yes or no.
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainMenuActivity.storeOrder.remove(currOrder);
                        Toast.makeText(StoreOrdersActivity.this, "Order Removed.", Toast.LENGTH_SHORT).show();
                        initialize();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    /**
                     * This method handles the "No" selection for the alert to remove order.
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
            }
        });

    }
}