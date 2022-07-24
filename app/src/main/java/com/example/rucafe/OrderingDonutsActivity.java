package com.example.rucafe;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * Activity class to handle the ordering of donuts
 * @author Alark Patel, Nicolas Ku
 */

public class OrderingDonutsActivity extends AppCompatActivity {
    TextView subTotalText;
    Spinner typeSpinner, quantitySpinner;
    Button addDonutButton;

    double currPrice;
    String types;
    int orderQuantity = 1;
    DecimalFormat decFormat = new DecimalFormat("Rp0.000");
    protected static ArrayList<Donut> donutList = new ArrayList<>();

    /**
     * This is the creation of the activity for ordering donuts.
     * @param savedInstanceState Bundle of activities' previous state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordering_donuts);
        typeSpinner = (Spinner) findViewById(R.id.donutTypeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.donut_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

        quantitySpinner = (Spinner) findViewById(R.id.quantityDonut);
        adapter = ArrayAdapter.createFromResource(this, R.array.quantity, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantitySpinner.setAdapter(adapter);

        subTotalText = (TextView) findViewById(R.id.subTotalText);

        addDonutButton = (Button) findViewById(R.id.button);


        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * Handles the selection of the spinner for the type of donut.
             * @param parent adapter view used for the method.
             * @param view status of the item selected.
             * @param position position in the spinner class.
             * @param id id of the spinner and item selected.
             */

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        types = "Raspberry Twist";
                        break;
                    case 1:
                        types = "Brownie Batter";
                        break;
                    case 2:
                        types = "Confetti";
                        break;

                    case 3:
                        types = "Lemon Cake";
                        break;

                    case 4:
                        types = "Cherry";
                        break;

                    case 5:
                        types = "Melted Oreos";
                        break;
                    case 6:
                        types = "Marble";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * Handles the selection of the spinner for the quantity donuts.
             * @param parent adapter view used for the method.
             * @param view status of the item selected.
             * @param position position in the spinner class.
             * @param id id of the spinner and item selected.
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = quantitySpinner.getSelectedItem().toString();
                int quantity = Integer.parseInt(text);
                Donut donut = new Donut(types, quantity);
                currPrice = donut.getPrice();
                subTotalText.setText(decFormat.format(currPrice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addDonutButton.setOnClickListener(new View.OnClickListener() {
            /**
             * This handles the click of ordering donuts button.
             * Adds donut order to myOrders.
             * @param v view activity for selection.
             */
            @Override
            public void onClick(View v) {
                types = typeSpinner.getSelectedItem().toString();
                orderQuantity = Integer.parseInt(quantitySpinner.getSelectedItem().toString());
                Donut donut = new Donut(types, orderQuantity);
                MainMenuActivity.order.add(donut);
                Toast toast = Toast.makeText(OrderingDonutsActivity.this ,"Added Donut to Order", Toast.LENGTH_SHORT);
                toast.show();
                donutList.add(donut);
                setDefault();
            }


        });
    }

    /**
     * First initializes the Ordering Donut Activity.
     * This is default method for resetting the activity to its defaults.
     */
    private void setDefault() {
        currPrice = Donut.DONUT_PRICE;
        subTotalText.setText(decFormat.format(currPrice));
        quantitySpinner.setSelection(0);
    }


}