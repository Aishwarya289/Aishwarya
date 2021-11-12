package com.reva.pizzaorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    pizza pizza;
    TextView total;
    double total_price;
    TextView delivery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pizza = new pizza();
        total = findViewById(R.id.textView4);
        delivery=findViewById(R.id.deliveryNote);
    }

    public void radioClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId())
        {
            case R.id.rb2:
                if(checked)
                    pizza.setPizza_size_price(110);
                break;
            case R.id.rb1:
                if(checked)
                    pizza.setPizza_size_price(180);
                break;
            case R.id.rb3:
                if(checked)
                    pizza.setPizza_size_price(250);
                break;
        }
            total.setText("total Price:" + String.format("%.2f", calculate_total()) + "Rs");

    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId())
        {
            case R.id.cb2:
                if(checked)
                    pizza.setMeat_price(50);
                break;
            case R.id.cb1:
                if(checked)
                    pizza.setCheese_price(50);
                break;
            case R.id.cb3:
                if(checked)
                    pizza.setVeggies_price(50);
                break;
        }

        total.setText("total price:" + String.format("%.02f", pizza.getPizza_size_price()) + "Rs");

    }
    private double calculate_total()
    {
        total_price = pizza.getPizza_size_price()*pizza.getMeat_price()*pizza.getCheese_price()*pizza.getVeggies_price();
        return total_price;
    }

    public void onSwitchClicked(View view) {

        Switch swButton=(Switch) view;
        if(swButton.isChecked())
            delivery.setText("DElivery Required!");
        else
            delivery.setText(" ");
    }
}
