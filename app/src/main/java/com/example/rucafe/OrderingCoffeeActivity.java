package com.example.rucafe;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * This class controls the activity for Ordering coffees.
 * @author Alark Patel, Nicolas Ku
 */

public class OrderingCoffeeActivity extends AppCompatActivity {
    private CheckBox milk, caramel, cream, syrup, whippedCream;
    private Spinner sizeSpinner, quantitySpinner;
    private TextView totalText;
    private Button addCoffeeButton;

    double currPrice= 0;
    public final ArrayList<Coffee> coffeeList = new ArrayList<>();
    private DecimalFormat decFormat = new DecimalFormat("Rp0.00");
    private ArrayAdapter<CharSequence> adapter;

    /**
     * This is the creation of the activity for ordering coffee.
     * @param savedInstanceState Bundle of activities' previous state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordering_coffee);
        totalText = findViewById(R.id.coffeeSubtotalText);

        milk = findViewById(R.id.milkCB);
        caramel = findViewById(R.id.caramelCB);
        cream = findViewById(R.id.creamCB);
        syrup = findViewById(R.id.syrupCB);
        whippedCream = findViewById(R.id.whippedCreamCB);

        sizeSpinner = (Spinner) findViewById(R.id.coffeeSizeSpinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.coffee_sizes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(adapter);

        addCoffeeButton = (Button) findViewById(R.id.addCoffeeBtn);


        quantitySpinner = findViewById(R.id.quantityCoffee);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.quantity, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantitySpinner.setAdapter(adapter);


        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * Handles the selection of the spinner for the size.
             * @param parent adapter view used for the method.
             * @param view status of the item selected.
             * @param position position in the spinner class.
             * @param id id of the spinner and item selected.
             */

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String size = sizeSpinner.getSelectedItem().toString();
                String strQuantity = quantitySpinner.getSelectedItem().toString();
                int orderQuantity = 1;
                if (isValidInteger(strQuantity)) {
                    orderQuantity = Integer.parseInt(strQuantity);
                } else {
                    Toast.makeText(OrderingCoffeeActivity.this, "Order failed! Select quantity.", Toast.LENGTH_SHORT).show();
                }
                currPrice = orderQuantity * new Coffee().getSizePrice(size);
                if (caramel.isChecked()) {
                    currPrice += new Coffee().PER_EXTRA * orderQuantity;
                }
                if (milk.isChecked()) {
                    currPrice += new Coffee().PER_EXTRA * orderQuantity;

                }
                if (cream.isChecked()) {
                    currPrice += new Coffee().PER_EXTRA * orderQuantity;

                }
                if (syrup.isChecked()) {
                    currPrice += new Coffee().PER_EXTRA * orderQuantity;
                }
                if (whippedCream.isChecked()) {
                    currPrice += new Coffee().PER_EXTRA * orderQuantity;
                }
                totalText.setText(decFormat.format(currPrice));
            }

            /**
             * Implemented method as part of the AppCompatActivity
             * @param parent parent view when nothing happens.
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            /**
             * Handles the selection of the spinner for the quantity.
             * @param parent adapter view used for the method.
             * @param view status of the item selected.
             * @param position position in the spinner class.
             * @param id id of the spinner and item selected.
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    String size = sizeSpinner.getSelectedItem().toString();
                    String strQuantity = quantitySpinner.getSelectedItem().toString();
                    int orderQuantity = 0;
                    if (isValidInteger(strQuantity)) {
                        orderQuantity = Integer.parseInt(strQuantity);
                    } else {
                        Toast.makeText(OrderingCoffeeActivity.this, "Order failed! Select Quantity.", Toast.LENGTH_SHORT).show();
                    }
                    currPrice = orderQuantity * new Coffee().getSizePrice(size);
                    if (caramel.isChecked()) {
                        currPrice += new Coffee().PER_EXTRA * orderQuantity;
                    }
                    if (milk.isChecked()) {
                        currPrice += new Coffee().PER_EXTRA * orderQuantity;

                    }
                    if (cream.isChecked()) {
                        currPrice += new Coffee().PER_EXTRA * orderQuantity;

                    }
                    if (syrup.isChecked()) {
                        currPrice += new Coffee().PER_EXTRA * orderQuantity;
                    }
                    if (whippedCream.isChecked()) {
                        currPrice += new Coffee().PER_EXTRA * orderQuantity;
                    }
                    totalText.setText(decFormat.format(currPrice));

                } catch (Exception e) {
                    // Toast Alert:  selection failed.
                }
            }

            /**
             * Implemented method as part of the AppCompatActivity
             * @param parent parent view when nothing happens.
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        caramel.setOnClickListener(new View.OnClickListener() {
            /**
             * This handles the checkboxes selection for ingredients.
             * @param v view activity for selection.
             */
            @Override
            public void onClick(View v) {
                String strQuantity = quantitySpinner.getSelectedItem().toString();
                int orderQuantity = 1;
                if (isValidInteger(strQuantity)) {
                    orderQuantity = Integer.parseInt(strQuantity);
                } else {
                    Toast.makeText(OrderingCoffeeActivity.this, "Order failed! Wrong quantity.", Toast.LENGTH_SHORT).show();
                }
                if (caramel.isChecked()) {
                    currPrice += orderQuantity * new Coffee().PER_EXTRA;
                    totalText.setText(decFormat.format(currPrice));
                } else {
                    currPrice -= orderQuantity * new Coffee().PER_EXTRA;
                    totalText.setText(decFormat.format(currPrice));
                }

            }
        });

        cream.setOnClickListener(new View.OnClickListener() {
            /**
             * This handles the checkboxes selection for ingredients.
             * @param v view activity for selection.
             */
            @Override
            public void onClick(View v) {
                String strQuantity = quantitySpinner.getSelectedItem().toString();
                int orderQuantity = 1;
                if (isValidInteger(strQuantity)) {
                    orderQuantity = Integer.parseInt(strQuantity);
                } else {
                    Toast.makeText(OrderingCoffeeActivity.this, "Order failed! Wrong quantity.", Toast.LENGTH_SHORT).show();
                }
                if (cream.isChecked()) {
                    currPrice += orderQuantity * new Coffee().PER_EXTRA;
                    totalText.setText(decFormat.format(currPrice));
                } else {
                    currPrice -= orderQuantity * new Coffee().PER_EXTRA;
                    totalText.setText(decFormat.format(currPrice));
                }


            }
        });
        milk.setOnClickListener(new View.OnClickListener() {
            /**
             * This handles the checkboxes selection for ingredients.
             * @param v view activity for selection.
             */
            @Override
            public void onClick(View v) {
                String strQuantity = quantitySpinner.getSelectedItem().toString();
                int orderQuantity = 1;
                if (isValidInteger(strQuantity)) {
                    orderQuantity = Integer.parseInt(strQuantity);
                } else {
                    Toast.makeText(OrderingCoffeeActivity.this, "Order failed! Wrong quantity.", Toast.LENGTH_SHORT).show();
                }
                if (milk.isChecked()) {
                    currPrice += orderQuantity * new Coffee().PER_EXTRA;
                    totalText.setText(decFormat.format(currPrice));
                } else {
                    currPrice -= orderQuantity * new Coffee().PER_EXTRA;
                    totalText.setText(decFormat.format(currPrice));
                }


            }
        });
        syrup.setOnClickListener(new View.OnClickListener() {
            /**
             * This handles the checkboxes selection for ingredients.
             * @param v view activity for selection.
             */
            @Override
            public void onClick(View v) {
                String strQuantity = quantitySpinner.getSelectedItem().toString();
                int orderQuantity = 1;
                if (isValidInteger(strQuantity)) {
                    orderQuantity = Integer.parseInt(strQuantity);
                } else {
                    Toast.makeText(OrderingCoffeeActivity.this, "Order failed! Wrong quantity.", Toast.LENGTH_SHORT).show();
                }
                if (syrup.isChecked()) {
                    currPrice += orderQuantity * new Coffee().PER_EXTRA;
                    totalText.setText(decFormat.format(currPrice));
                } else {
                    currPrice -= orderQuantity * new Coffee().PER_EXTRA;
                    totalText.setText(decFormat.format(currPrice));
                }


            }
        });
        whippedCream.setOnClickListener(new View.OnClickListener() {
            /**
             * This handles the checkboxes selection for ingredients.
             * @param v view activity for selection.
             */
            @Override
            public void onClick(View v) {
                String strQuantity = quantitySpinner.getSelectedItem().toString();
                int orderQuantity = 1;
                if (isValidInteger(strQuantity)) {
                    orderQuantity = Integer.parseInt(strQuantity);
                } else {
                    Toast.makeText(OrderingCoffeeActivity.this, "Order failed! Wrong quantity.", Toast.LENGTH_SHORT).show();
                }
                if (whippedCream.isChecked()) {
                    currPrice += orderQuantity * new Coffee().PER_EXTRA;
                    totalText.setText(decFormat.format(currPrice));
                } else {
                    currPrice -= orderQuantity * new Coffee().PER_EXTRA;
                    totalText.setText(decFormat.format(currPrice));
                }


            }
        });

        addCoffeeButton.setOnClickListener(new View.OnClickListener() {
            /**
             * This handles the click of ordering coffee button.
             * @param v view activity for selection.
             */
            @Override
            public void onClick(View v) {
                String size = sizeSpinner.getSelectedItem().toString();
                String strQuantity = quantitySpinner.getSelectedItem().toString();
                int orderQuantity = 0;
                if (isValidInteger(strQuantity)) {
                    orderQuantity = Integer.parseInt(strQuantity);
                } else {
                    Toast.makeText(OrderingCoffeeActivity.this, "Order failed! Wrong quantity.", Toast.LENGTH_SHORT).show();
                }
                List<String> extras = addExt();
                Extras extra = new Extras(extras);
                Coffee coffee = new Coffee(size, orderQuantity, extra);
                coffeeList.add(coffee);
                for (Coffee co : coffeeList) {
                    MainMenuActivity.order.add(co);
                }
                Toast.makeText(OrderingCoffeeActivity.this, "Added Coffee to Order.", Toast.LENGTH_SHORT).show();
                coffeeList.clear();
                quantitySpinner.setSelection(0);
                currPrice = 0;
                totalText.clearComposingText();
                setDefault();
            }
        });
    }

    /**
     * This method checks if the given String input is Integer or not.
     *
     * @param input Input of String type.
     * @return True, if the String input is a valid integer, False otherwise.
     */
    public boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * First initializes the Ordering Coffee Activity.
     * This is default method for resetting the activity to its defaults.
     */
    private void setDefault() {
        sizeSpinner.setSelection(0);
        quantitySpinner.setSelection(0);
        currPrice = Coffee.SMALL_PRICE;
        totalText.setText(decFormat.format(currPrice));
        caramel.setChecked(false);
        cream.setChecked(false);
        whippedCream.setChecked(false);
        milk.setChecked(false);
        syrup.setChecked(false);
    }

    /**
     * Handles the check for the Extras selected during order.
     * @return  String list with ingredients in current order.
     */
    private List<String> addExt() {
        List<String> extras = new ArrayList<>();
        if (caramel.isChecked()) {
            extras.add("Caramel");
        }
        if (milk.isChecked()) {
            extras.add("Milk");
        }
        if (cream.isChecked()) {
            extras.add("Cream");
        }
        if (syrup.isChecked()) {
            extras.add("Syrup");
        }
        if (whippedCream.isChecked()) {
            extras.add("Whipped Cream");
        }
        return extras;
    }

}