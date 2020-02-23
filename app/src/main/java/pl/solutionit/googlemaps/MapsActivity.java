package pl.solutionit.googlemaps;

import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;

    LocationManager mLocMgr;
    LocationListener mListener;
    String bestProvider;
    String providers[];
    Location lastLoc;

    TextView proviederGPS, latitudeValue, longitudeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

      //  proviederGPS = (TextView) findViewById(R.id.dostawca);
       // latitudeValue = (TextView) findViewById(R.id.szerokosc_geo);
       // longitudeValue = (TextView) findViewById(R.id.dlugosc_geo);
        getLocationManager();
        getNewLocation();
        showLocationProvidersInfo();
        showLocation();

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
        LatLng chelmza = new LatLng(53.186533, 18.610311);
        mMap.addMarker(new MarkerOptions().position(chelmza).title("Wera i Dora tu są!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chelmza));
    }

    @SuppressLint("MissingPermission")
    private void getNewLocation() {
        mLocMgr.requestLocationUpdates(mLocMgr.GPS_PROVIDER,3000, 2, this);
    }
    private void getLocationManager() {
        mLocMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }

    private void showLocationProvidersInfo() {
        String providers = getLocationProvidersInfo();
        proviederGPS.setText(providers);
    }

    private String getLocationProvidersInfo() {
        StringBuilder locationProviders = new StringBuilder();
        for (String providerName : mLocMgr.getAllProviders()) {
            locationProviders.append(providerName);
            locationProviders.append(" ");
            if (mLocMgr.isProviderEnabled(providerName))
                locationProviders.append("(enabled)");
            else
                locationProviders.append("(disable)");
            locationProviders.append("\n");
        }
        return locationProviders.toString();
    }

    private void showLocation() {
        StringBuilder latitudeStr = new StringBuilder("Latitude:\n");
        StringBuilder longitudeStr = new StringBuilder("Longitude:\n");
        for (String providerStr : mLocMgr.getAllProviders()) {
            @SuppressLint("MissingPermission") Location location = mLocMgr.getLastKnownLocation(providerStr);
            if (location != null) {
                latitudeStr.append(location.getLatitude());
                longitudeStr.append(location.getLongitude());
            } else {
                latitudeStr.append("null\n");
                longitudeStr.append("null\n");
            }
            latitudeStr.append(" from: " + providerStr + "\n");
            longitudeStr.append(" from: " + providerStr + "\n");
        }
        latitudeValue.setText(latitudeStr);
        longitudeValue.setText(longitudeStr);
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        //metoda wywoływana w pomoencie zmiany stanu dostawcy

    }
    @Override
    public void onProviderEnabled(String provider) {
        //włączenie się dostawcy usługi
        Toast.makeText(getBaseContext(), "Gps włączony ", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onProviderDisabled(String provider) {
        //wyłączenie się dostawcy usługi
        Toast.makeText(getBaseContext(), "Gps wyłączony ", Toast.LENGTH_LONG).show();
    }
    @SuppressLint("MissingPermission")
    @Override
    public void onLocationChanged(Location location) {
        //metoda wywoływana w momencie zmiany położenia
        // lastLoc = mLocMgr.getLastKnownLocation(bestProvider);
        //  proviederGPS.setText(".." + bestProvider + "..");
        latitudeValue.setText("Szerokosć: "+ lastLoc.getLatitude());
        longitudeValue.setText("Długość "+lastLoc.getLongitude());
        // tv1.setText("Lat " +   location.getLatitude() + " Long " + location.getLongitude());
    }
}
