package com.example.owner.directions;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Testing
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        String ETenteredAddress = "4 Barstow Street, Allston, MA";
        String EnteredAddress = ETenteredAddress;

        //EditText ETenteredAddress = (EditText) findViewById(R.id.Address);
        //String EnteredAddress = ETenteredAddress.getText().toString();

        //String homeAddress2 = "4 Barstow Street, Allston, MA";
        String EncodeAddress = Uri.encode(EnteredAddress);

        String formattedAddress = "google.navigation:q=" + EncodeAddress;

        Toast.makeText(this, formattedAddress, Toast.LENGTH_LONG).show();

        Uri StartNav = Uri.parse(formattedAddress);

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, StartNav);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
