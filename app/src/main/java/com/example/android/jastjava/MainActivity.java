package com.example.android.jastjava;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.jastjava.R;

public class MainActivity extends ActionBarActivity {

    public int quantity = 1;
    public int price = 50;
    public int addPrice = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(quantity);
        displayPrice(price);
    }

    public void submitOrder(View view) {
        view.setVisibility(View.GONE);

        TextView zakazTextView = (TextView) findViewById(R.id.zakaz);
        zakazTextView.setVisibility(View.VISIBLE);

        Button buttonIncrement = (Button) findViewById(R.id.inc);
        buttonIncrement.setClickable(false);
        buttonIncrement.setBackgroundColor(Color.parseColor("#BDBDBD"));

        Button buttonDecrement = (Button) findViewById(R.id.dec);
        buttonDecrement.setClickable(false);
        buttonDecrement.setBackgroundColor(Color.parseColor("#BDBDBD"));
    }

    public void increment(View view) {
        if (quantity == 1) {
            quantity = 1;
        } else {
            price = price - addPrice;
            quantity--;
        }
        displayPrice(price);
        display(quantity);
    }

    public void decrement(View view) {
        quantity++;
        price = price + addPrice;
        displayPrice(price);
        display(quantity);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(java.text.NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}