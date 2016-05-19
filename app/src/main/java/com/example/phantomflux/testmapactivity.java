package com.example.phantomflux.myfirstapp;

import android.Manifest;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;

public class testmapactivity extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testmapactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
//          MapFragment mapmine;
//        mapmine = MapFragment.newInstance();
//        FragmentTransaction fragmentTransaction =
//                getFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.maptest,mapmine);
//        fragmentTransaction.commit();
//
//        MapFragment mapFragment = (MapFragment) getFragmentManager()
//                .findFragmentById(R.id.maptest);
//        mapFragment.getMapAsync(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
//        {
//
//            mMap.setMyLocationEnabled(true);
//            Location currentlocation = mLocationClient.getLastLocation();
//
//        }
//        else
//        {
//
//            Toast.makeText(this, "Please enable location", Toast.LENGTH_SHORT);
//        }

        JSONObject test = new JSONObject();



        String[] myStringArray = new String[3];

        myStringArray[0] = "Nugget Masjid";
        myStringArray[1] = "Masjid Darusalam";
        myStringArray[2] = "Masjid AbuBakr";





        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, myStringArray);

        ListView mylistView = (ListView) findViewById(R.id.listview);
        mylistView.setAdapter(adapter);

        mylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String masjidselected = String.valueOf(parent.getItemAtPosition(position));

                    if(masjidselected.equalsIgnoreCase("Nugget Masjid")) {
                        startActivity(new Intent(testmapactivity.this, Nugget_Masjid.class));
                    }
                else if(masjidselected.equalsIgnoreCase("Masjid Darusalam")) {
                    startActivity(new Intent(testmapactivity.this, Masjid_Darusalam.class));
                }

            }
        });

    }




    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng toronto = new LatLng(43.653226, -79.383184);
        float zoomlevel = 9;
        mMap.addMarker(new MarkerOptions().position(toronto).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(toronto, zoomlevel));
    }


}
