package com.thr33scompany.tre.shoppingwithfriends.Map;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.thr33scompany.tre.shoppingwithfriends.MVP.MainActivity;
import com.thr33scompany.tre.shoppingwithfriends.R;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import android.view.ViewGroup;

import static android.app.PendingIntent.getActivity;

/**
 * A Fragment version of Map Activity that holds the logic and listeners for the map
 */
public class MapFragment extends SupportMapFragment {
    private SupportMapFragment mSupportMapFragment;
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private ViewGroup view;
// --Commented out by Inspection START (3/26/2015 10:13 AM):
//    /**
//     * Width of Fragment.
//     */
//    private int width;
// --Commented out by Inspection STOP (3/26/2015 10:13 AM)
// --Commented out by Inspection START (3/26/2015 10:13 AM):
//    /**
//     * Height of Fragment.
//     */
//    private int height;
// --Commented out by Inspection STOP (3/26/2015 10:13 AM)

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }
    */

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = (ViewGroup) inflater.inflate(R.layout.activity_maps, null, false);
        initializeMap();

        return view;
    }

    /**
     * Starts the logic for the map giving it time to load before placing markers
     */
    private void initializeMap()
    {
        mSupportMapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.mapwhere);
        if (mSupportMapFragment == null) {
            FragmentManager fragmentManager = getFragmentManager();
            mSupportMapFragment = new SupportMapFragment() {
                @Override
                public void onActivityCreated(Bundle savedInstanceState) {
                    super.onActivityCreated(savedInstanceState);
                    mMap = mSupportMapFragment.getMap();
                    if (mMap != null) {
                        mMap.setMyLocationEnabled(true);
                        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                            @Override
                            public void onMapLoaded() {
                                //mMap.addMarker(new MarkerOptions().position(getLocationFromAddress("120 Northave Northwest")));
                                Log.d("Test", "Map is loaded 1" + ((MainActivity)getActivity()).getSaleReportInfo().get(0));
                                Log.d("Test", "Map is loaded 2" + ((MainActivity)getActivity()).getSaleReportInfo().size());
                                Log.d("Test", "Map is loaded 3" + ((MainActivity)getActivity()).getSaleReportInfo());
                                ArrayList GETSIZE = (ArrayList) ((MainActivity)getActivity()).getSaleReportInfo().get(0);
                                for(int i = 0; i < GETSIZE.size(); i++) {
                                    ArrayList Items = (ArrayList)((MainActivity)getActivity()).getSaleReportInfo().get(0);
                                    ArrayList Prices = (ArrayList)((MainActivity)getActivity()).getSaleReportInfo().get(1);
                                   // ArrayList Reporters = (ArrayList)((MainActivity)getActivity()).getSaleReportInfo().get(2);
                                    ArrayList Locations = (ArrayList)((MainActivity)getActivity()).getSaleReportInfo().get(2);

                                    mMap.addMarker(new MarkerOptions().position(getLocationFromAddress(Locations.get(i).toString())).title(Items.get(i).toString() + ":" + Prices.get(i).toString() + "$").snippet(Locations.get(i).toString()));
                                }


                                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                                    @Override
                                    public boolean onMarkerClick(Marker marker) {
                                        marker.showInfoWindow();
                                        return true;
                                    }
                                });
                            }
                        });
                        //setupMap();
                    }
                }
            };
            fragmentManager.beginTransaction().replace(R.id.mapwhere, mSupportMapFragment).commit();

        }
        /*
        if (mSupportMapFragment != null)
        {
            mMap =  mSupportMapFragment.getMap();

            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
                mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                    @Override
                    public void onMapLoaded() {
                        mMap.addMarker(new MarkerOptions().position(getLocationFromAddress("120 Northave Northwest")));
                        //Log.d("Test", "Map is loaded" + getLocationFromAddress("Location"));
                        //for(int i = 0; i < ((MainActivity)getActivity()).getSaleReportInfo().split(";")[0].length(); i++) {
                       //     mMap.addMarker(new MarkerOptions().position(getLocationFromAddress(((MainActivity)getActivity()).getSaleReportInfo().split(";")[i].split(",")[2])).title(((MainActivity)getActivity()).getSaleReportInfo().split(";")[i].split(",")[0] + ":" + ((MainActivity)getActivity()).getSaleReportInfo().split(";")[i].split(",")[1]).snippet(((MainActivity)getActivity()).getSaleReportInfo().split(";")[i].split(",")[2]));
                       // }

                        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                marker.showInfoWindow();
                                return true;
                            }
                        });
                    }
                });
            }

        }
*/
    }

// --Commented out by Inspection START (3/26/2015 10:13 AM):
//    public void hide() {
//        ViewTreeObserver vto = view.getViewTreeObserver();
//        vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
//            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//            @Override
//            public void onGlobalLayout() {
//                width = view.getWidth();
//                height = view.getHeight();
//                ViewTreeObserver obs = view.getViewTreeObserver();
//                obs.removeOnGlobalLayoutListener(this);
//                view.setTranslationY(-height);
//            }
//        });
//    }
// --Commented out by Inspection STOP (3/26/2015 10:13 AM)

// --Commented out by Inspection START (3/26/2015 10:13 AM):
//    public void show() {
//        ViewTreeObserver vto = view.getViewTreeObserver();
//        vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
//            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//            @Override
//            public void onGlobalLayout() {
//                width = view.getWidth();
//                height = view.getHeight();
//                ViewTreeObserver obs = view.getViewTreeObserver();
//                obs.removeOnGlobalLayoutListener(this);
//                view.setTranslationY(0);
//            }
//        });
//    }
// --Commented out by Inspection STOP (3/26/2015 10:13 AM)

    /**
     * Gets LatLng from input address (Varies)
     * @param strAddress; i.e 120 NorthAvenue Northwest
     * @return p1; LatLng
     */
    LatLng getLocationFromAddress(String strAddress) {

        Geocoder coder = new Geocoder(getActivity());
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return p1;
    }
/**
 * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
 * installed) and the map has not already been instantiated.. This will ensure that we only ever
 * call {@link #setUpMap()} once when {@link #mMap} is not null.
 * <p/>
 * If it isn't installed {@link SupportMapFragment} (and
 * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
 * install/update the Google Play services APK on their device.
 * <p/>
 * A user can return to this FragmentActivity after following the prompt and correctly
 * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
 * have been completely destroyed during this process (it is likely that it would only be
 * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
 * method in {@link #onResume()} to guarantee that it will be called.
 */
    /*
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
        mMap.setIndoorEnabled(true);
        mMap.setMyLocationEnabled(true);
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                //Log.d("Test", "Map is loaded" + getLocationFromAddress("Location"));
                mMap.addMarker(new MarkerOptions().position(getLocationFromAddress("Location")));
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        marker.showInfoWindow();
                        return true;
                    }
                });
            }
        });
    }
    */

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    /*
    private void setUpMap() {

    }


    */

}

