package bjfu.it.fangzidong.odometer;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;

import androidx.core.app.ActivityCompat;

import java.util.Random;

public class OdometerService extends Service {
    private double distanceMeters;
    private LocationManager locationManager;
    private LocationListener locationListener;


    @Override
    public void onCreate() {
        super.onCreate();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String provider = locationManager.getBestProvider(new Criteria(), true);
        locationListener = new LocationListener() {

            private Location lastLocation;

            @Override
            public void onLocationChanged(Location location) {
                if (lastLocation==null){
                    lastLocation = location;
                }
                distanceMeters+=location.distanceTo(lastLocation);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
            locationManager.requestLocationUpdates(provider, 1000, 1, locationListener);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (locationManager!=null&&locationListener!=null){
            locationManager.removeUpdates(locationListener);
        }
        locationManager=null;
        locationListener=null;
    }

    public OdometerService() {
    }

    public class OdometerBinder extends Binder {
        OdometerService getOdometer(){
            return OdometerService.this;
        }
    }

    private IBinder binder = new OdometerBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private Random random = new Random();
    public double getDistance(){
        return distanceMeters/1000;
    }
}
