package com.example.map_example;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.map_example.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng thessaloniki = new LatLng(40.62639114467814, 22.948477836103358);
        mMap.addMarker(new MarkerOptions()
                .position(thessaloniki)
                .title("White Tower")
                .snippet("Λευκός Πύργος")
//                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker))
        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.632094884878, 22.95146749428538))
                .title("Αψίδα του Γαλερίου"));

        mMap.addPolyline(new PolylineOptions()
                .add(thessaloniki)
                .add(new LatLng(40.62643645677845, 22.9490407061129))
                .add(new LatLng(40.630800907302735, 22.952956733217015))
                .add(new LatLng(40.631305746338604, 22.95281726364156))
                .add(new LatLng(40.6343915803981, 22.946991442860963))
                .add(new LatLng(40.633308668390896, 22.946047322163086))
                .color(Color.RED)
        );

        ArrayList<LatLng> points = new ArrayList<>();
        points.add(new LatLng(40.63357736147268, 22.937571526079175));
        points.add(new LatLng(40.632421195020996, 22.939610030275812));
        points.add(new LatLng(40.62615429990483, 22.94912327164064));
        points.add(new LatLng(40.62389867187083, 22.9520415605944));
        points.add(new LatLng(40.62254690833145, 22.951923534049396));

        mMap.addPolyline(new PolylineOptions()
                .addAll(points)
        );

        mMap.addCircle(new CircleOptions()
                .center(new LatLng(40.63140256322236, 22.94732849444855))
                .radius(100)
                .fillColor(Color.argb(25, 255, 0, 0))
                .strokeColor(Color.GREEN)
        );


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(thessaloniki, 14));

        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        Toast.makeText(MapsActivity.this, "Click Marker", Toast.LENGTH_LONG).show();
        return false;
    }
}