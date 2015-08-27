package com.jakeanderton.discountcalc;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends Activity
{

    private double basePrice;
    private double disPrice;

    RadioButton tenPercent;
    RadioButton twentyPercent;

    EditText basePriceET;
    EditText disPriceET;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basePrice = 0.0;
        disPrice = 0.0;

        basePriceET = (EditText) findViewById(R.id.basePriceEditText);
        disPriceET = (EditText) findViewById(R.id.disPriceEditText);

        tenPercent = (RadioButton) findViewById(R.id.tenRadio);
        twentyPercent = (RadioButton) findViewById(R.id.twentyRadio);

        tenPercent.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                updatePrice();

            }
        });

        twentyPercent.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                updatePrice();

            }
        });

        basePriceET.addTextChangedListener(editChecker);

    }

    private TextWatcher editChecker = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                basePrice = Double.parseDouble(s.toString());
                System.out.println(basePriceET.toString());
                System.out.println(basePrice);


            } catch (NumberFormatException e)
            {
                System.out.println("broke");
                // basePrice = 0.0;
            }

            updatePrice();
        }

        @Override
        public void afterTextChanged(Editable s)
        {

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void updatePrice()
    {
        System.out.println("start if");
        if (tenPercent.isChecked())
        {
            System.out.println("old: " + basePrice);
            disPrice = basePrice - (basePrice * 0.1);
            System.out.println("10 achieved");
            System.out.println("new: " + disPrice);
        }
        else if (twentyPercent.isChecked())
        {
            disPrice = basePrice - (basePrice * 0.2);
            System.out.println("20 achieved");
            System.out.println("new: " + disPrice);
        }
        else
        {
            System.out.println("0 achieved????");
        }
        System.out.println("if end");
        disPriceET.setText(String.format("%.02f", disPrice));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
