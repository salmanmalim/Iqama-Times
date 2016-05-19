package com.example.phantomflux.myfirstapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Nugget_Masjid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nugget__masjid);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//                InputStream is = getResources().openRawResource(R.raw.test);
//        ByteArrayOutputStream bo = new ByteArrayOutputStream();
//
//        int ctr;
//        try{
//
//            ctr = is.read();
//            while(ctr != -1){
//                bo.write(ctr);
//                ctr = is.read();
//
//            }
//            is.close();
//
//        } catch (IOException e){e.printStackTrace();}
//
//        Log.v("Text Data", bo.toString());

//        System.out.println("test");
//        Context context = getApplicationContext();
//        CharSequence text = "Please check either Male or Female";
//        int duration = Toast.LENGTH_SHORT;
//
//        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
        String bo = "{\"name\":\"Nugget Masjid\"}";
        String cars = "";
        try {
            JSONObject jsonObject = new JSONObject(bo);
          cars =  jsonObject.optString("name").toString();
             //test = cars.toString();
        }catch(JSONException e){}
       // times(R.raw.test);

        TextView textView = (TextView)findViewById(R.id.fajr);
        textView.setText(cars);
    }

//    public void times(int resourceId){
//
//        long DayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);;
//        if(365 == Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR) && DayOfYear >= 60)
//
//        {
//            DayOfYear = DayOfYear + 1 ;
//        }
//
//        InputStream is = getResources().openRawResource(resourceId);
//        ByteArrayOutputStream bo = new ByteArrayOutputStream();
//
//        int ctr;
//        try{
//
//            ctr = is.read();
//            while(ctr != -1){
//                bo.write(ctr);
//                ctr = is.read();
//
//            }
//            is.close();
//
//        } catch (IOException e){e.printStackTrace();}
//
//        Log.v("Text Data", bo.toString());
//
//
//         try {
//             JSONObject jsonObject = new JSONObject(bo.toString());
//             JSONArray cars = (JSONArray) jsonObject.get("Nugget Masjid");
//             //Iterator<JSONObject> myiterator =  cars.keys(;
//
//             for (int i = 0; i < cars.length(); i++) {
//
//                 JSONObject row = cars.getJSONObject(i);
//                 //Long day = (Long) cars.get("Day");
//
//                 JSONArray times = (JSONArray) row.get("times");
//                // Iterator<JSONObject> timeiterate = times.iterator();
//                 System.out.println("test");
//
////                 if (day == DayOfYear) {
////                     for (int j = 0; j < times.length(); j++) {
////
////                         System.out.println(times.getJSONObject(i));
////                     }
////
////
////                 }
//             }
//         } catch (Exception e){e.printStackTrace();}
//    }


}
