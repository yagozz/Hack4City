package com.hack4city.hack4city;

import android.Manifest;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.DataSetObserver;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.vision.text.Text;
import com.hack4city.hack4city.WebService.WebService;

import java.util.ArrayList;
import java.util.List;

public class TabbedActivity extends AppCompatActivity {


    private static final LatLng latLng_1 = new LatLng(38.448517, 27.190399);
    private static final LatLng latLng_2 = new LatLng(38.448970, 27.189297);
    private static final LatLng latLng_3 = new LatLng(38.446409, 27.191483);
    private static final LatLng latLng_4 = new LatLng(38.447309, 27.184990);
    private static final LatLng latLng_5 = new LatLng(38.446617, 27.190158);
    private static final LatLng latLng_6 = new LatLng(38.442621, 27.180838);
    private static final LatLng latLng_7 = new LatLng(38.448831, 27.192764);

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private LocationManager locationManager;
    private double lat;
    private double lng;
    private void setLocation(Location location){
        lat = location.getLatitude();
        lng = location.getLongitude();
    }
    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            setLocation(location);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        //-------------------------------------Location------------------------------------------
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                99);
        locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        boolean isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetWorkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (!isGpsEnabled && !isNetWorkEnabled) ;
        {
            Toast.makeText(this, "No Location Provider is Available", Toast.LENGTH_SHORT).show();
        }
        if (isNetWorkEnabled) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            if(locationManager!=null)
            {
                Location location =locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                if(location!=null)
                {
                    setLocation(location);
                }
            }
        }if(isGpsEnabled)
        {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
            if(locationManager!=null)
            {
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location!=null)
                {
                    setLocation(location);
                }
            }
        }
        //-------------------------------------Location------------------------------------------
        FontsOverride.setDefaultFont(getApplication(), "MONOSPACE", "latobold.ttf");
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    public static class PlaceholderFragment extends Fragment {
        private MapView map;
        public View tempView;
        public Bundle tempBundle;
        public static Spinner hat, durak, aktarma, durak2;
        private static final String ARG_SECTION_NUMBER = "section_number";

        public static PlaceholderFragment newInstance(int tabNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, tabNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            tempBundle = savedInstanceState;
            final View rootView;
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                rootView = inflater.inflate(R.layout.data_collect_page, container, false);
                TextView text = (TextView) rootView.findViewById(R.id.userNumber);
                hat = (Spinner) rootView.findViewById(R.id.spinner);
                aktarma = (Spinner) rootView.findViewById(R.id.spinner2);
                durak = (Spinner) rootView.findViewById(R.id.spinner3);
                durak2 = (Spinner) rootView.findViewById(R.id.spinner4);
                aktarma.setEnabled(false);
                durak.setEnabled(false);
                durak2.setEnabled(false);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootView.getContext(),
                        R.array.hatlar, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                hat.setAdapter(adapter);
                adapter = ArrayAdapter.createFromResource(rootView.getContext(),
                        R.array.aktarmalar, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                aktarma.setAdapter(adapter);

                adapter = ArrayAdapter.createFromResource(rootView.getContext(),
                        R.array.duraklar, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                durak.setAdapter(adapter);

                adapter = ArrayAdapter.createFromResource(rootView.getContext(),
                        R.array.duraklar2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                durak2.setAdapter(adapter);

                hat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position != 0) {
                            Toast.makeText(rootView.getContext(), "Toast", Toast.LENGTH_SHORT).show();
                            aktarma.setEnabled(true);
                        }
                        durak.setEnabled(false);
                        durak2.setEnabled(false);
                        durak.setSelection(0);
                        durak2.setSelection(0);
                        aktarma.setSelection(0);
                        if (position == 0) {
                            aktarma.setEnabled(false);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                aktarma.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position != 0) {
                            Toast.makeText(rootView.getContext(), "Toast", Toast.LENGTH_SHORT).show();
                            durak.setEnabled(true);
                        }
                        durak2.setEnabled(false);
                        durak.setSelection(0);
                        durak2.setSelection(0);
                        if (position == 0) {
                            durak.setEnabled(false);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                durak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position != 0) {
                            Toast.makeText(rootView.getContext(), "Toast", Toast.LENGTH_SHORT).show();
                            durak2.setEnabled(true);
                        }
                        durak2.setSelection(0);
                        if (position == 0) {
                            durak2.setEnabled(false);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                map = (MapView) rootView.findViewById(R.id.data_collect_layout_map_view);
                map.onCreate(savedInstanceState);
                map.onResume();
                map.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        LatLng myLocation = new LatLng(38.4462373, 27.1891737);
                        googleMap.addMarker(new MarkerOptions().position(myLocation).title("Originn Hack4City Event")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation,15));

                        BitmapDescriptor bus_icon = BitmapDescriptorFactory.fromResource(R.drawable.busstop);
                        BitmapDescriptor meeting_icon = BitmapDescriptorFactory.fromResource(R.drawable.meeting);
                        BitmapDescriptor music_icon = BitmapDescriptorFactory.fromResource(R.drawable.music);
                        BitmapDescriptor theatre_icon = BitmapDescriptorFactory.fromResource(R.drawable.theatre);


                        googleMap.addMarker(new MarkerOptions().position(latLng_1).title("X Event")
                                .icon(bus_icon));

                        googleMap.addMarker(new MarkerOptions().position(latLng_2).title("Y Event")
                                .icon(meeting_icon));

                        googleMap.addMarker(new MarkerOptions().position(latLng_3).title("Z Event")
                                .icon(meeting_icon));

                        googleMap.addMarker(new MarkerOptions().position(latLng_4).title("T Event")
                                .icon(music_icon));

                        googleMap.addMarker(new MarkerOptions().position(latLng_5).title("A Event")
                                .icon(music_icon));

                        googleMap.addMarker(new MarkerOptions().position(latLng_6).title("B Event")
                                .icon(theatre_icon));

                        googleMap.addMarker(new MarkerOptions().position(latLng_7).title("C Event")
                                .icon(theatre_icon));

                    }});
                Button button = (Button) rootView.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(PlaceholderFragment.durak.getSelectedItemPosition()!=0 && PlaceholderFragment.aktarma.getSelectedItemPosition()!=0
                                && PlaceholderFragment.hat.getSelectedItemPosition()!=0 && PlaceholderFragment.durak2.getSelectedItemPosition()!=0){
                            Toast.makeText(getContext(), "Katılımınız için teşekkürler. Coin toplamaya devam edin", Toast.LENGTH_SHORT).show();
                            PlaceholderFragment.hat.setSelection(0);
                            PlaceholderFragment.durak.setEnabled(false);
                            PlaceholderFragment.durak2.setEnabled(false);
                            PlaceholderFragment.durak.setSelection(0);
                            PlaceholderFragment.durak2.setSelection(0);
                            PlaceholderFragment.aktarma.setSelection(0);
                            PlaceholderFragment.aktarma.setEnabled(false);
                        }else{
                            Toast.makeText(getContext(), "Lütfen bilgileri eksiksiz giriniz", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            } else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2){
                rootView = inflater.inflate(R.layout.trip_page_layout, container, false);
                map = (MapView) rootView.findViewById(R.id.trip_page_layout_map_view);

                map.onCreate(savedInstanceState);
                map.onResume();
                map.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        BitmapDescriptor bus_icon = BitmapDescriptorFactory.fromResource(R.drawable.busstop);
                        WebService webService = new WebService();
                        String[][] coordinates;
                        coordinates = webService.getRouteLatLong("6");

                        ArrayList<LatLng> stations;
                        stations = new ArrayList<>();
                        for(int i=0;i<coordinates[0].length;i++){
                            LatLng latLng = new LatLng(Double.valueOf(coordinates[0][i]),Double.valueOf(coordinates[1][i]));
                            stations.add(latLng);
                            if(i%7 == 0)
                                googleMap.addMarker(new MarkerOptions().position(latLng).title("İlk Durak")
                                    .icon(bus_icon));
                        }

                        Polyline polyline = googleMap.addPolyline(new PolylineOptions().addAll(stations).color(Color.GREEN).width(5f));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stations.get(stations.size()/2),12.3f));
                    }});
                Button button = (Button) rootView.findViewById(R.id.button2);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPlacePicker();
                    }
                });
                tempView = rootView;
            }else{
                rootView = inflater.inflate(R.layout.profile_layout, container, false);
            }

            return rootView;
        }
        int PLACE_PICKER_REQUEST = 1;

        private void openPlacePicker(){

            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

            try {
                startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST);
            } catch (GooglePlayServicesRepairableException e) {
                e.printStackTrace();
            } catch (GooglePlayServicesNotAvailableException e) {
                e.printStackTrace();
            }
        }
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == PLACE_PICKER_REQUEST) {
                if (resultCode == RESULT_OK) {
                    Place place = PlacePicker.getPlace(data, getActivity());
                    String toastMsg = String.format("Place: %s", place.getName());
                    Toast.makeText(getActivity(), toastMsg, Toast.LENGTH_LONG).show();
                    ImageView img = (ImageView) tempView.findViewById(R.id.tripImage);
                    ViewGroup.LayoutParams layoutParams = img.getLayoutParams();
                    layoutParams.width = ActionBar.LayoutParams.MATCH_PARENT;
                    layoutParams.height = 0;
                    img.setLayoutParams(layoutParams);
                    MapView map = (MapView) tempView.findViewById(R.id.trip_page_layout_map_view);
                    layoutParams = map.getLayoutParams();
                    layoutParams.width = ActionBar.LayoutParams.MATCH_PARENT;
                    layoutParams.height = 660;
                    map.setLayoutParams(layoutParams);
                    LinearLayout layout = (LinearLayout) tempView.findViewById(R.id.trip_image_layout);
                    layout.setBackgroundResource(R.mipmap.filledroute);
                }
            }
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Konum Bildir";
                case 1:
                    return "Rota Planlayıcı";
                case 2:
                    return "Profil";
            }
            return null;
        }
    }


}
