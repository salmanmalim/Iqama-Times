package com.example.phantomflux.myfirstapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class TDEECalculator extends AppCompatActivity {

   public boolean male = false;
    public boolean female = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdeecalculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {

            case R.id.male_radio:

                if (checked)

                    male=true;

                break;

            case R.id.female_radio:

                if (checked)

                    female=true;

                break;
            default:

                break;

        }
    }

    public void calculate(View view){

        TextView textView = (TextView)findViewById(R.id.textView1);
        EditText agetext = (EditText)findViewById(R.id.agetextfield);
        String agetextfield = agetext.getText().toString();

        int Age = 0;

        try {
            Age = Integer.parseInt(agetextfield);
        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }

        EditText heighttext = (EditText)findViewById(R.id.height);
        String heighttextfield = heighttext.getText().toString();

        double height = 0;

        try {
            height = Integer.parseInt(heighttextfield);
        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }

        EditText weighttext = (EditText)findViewById(R.id.weighttextfield);
        String weighttextfield = heighttext.getText().toString();

        double weight = 0;

        try {
            weight = Integer.parseInt(weighttextfield);
        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }

        double bmr=0;

        if (weight == 0 || height == 0 || Age== 0){

            textView.setText("please check input");

        }

        else if(male){

             bmr = 66+(13.7*weight)-(6.8*Age)+(5*height);

        }

        else if(female){

            bmr = 655+(9.6*weight)-(4.7*Age)+(1.8*height);

        }
        else
        {

            Context context = getApplicationContext();
            CharSequence text = "Please check either Male or Female";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


        if(bmr <= 400 || bmr>=8000) textView.setText("please check input");
        textView.setTextSize(40);
        textView.setText(Double.toString(bmr));


    }

}
