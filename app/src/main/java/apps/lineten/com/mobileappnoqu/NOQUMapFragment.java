package apps.lineten.com.mobileappnoqu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by farrakh on 01/05/15.
 */

public  class NOQUMapFragment extends Fragment {

    private static final String ARG_LATTITUDE = "lattitude";
    private static final String ARG_LONGTITUDE = "longtitude";
    private static GoogleMap mMap;
    private static Double lattitude,longtitude;
    private static View mapView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if (container==null){
            return null;
        }

        mapView = (RelativeLayout) inflater.inflate(R.layout.map_fragment_layout,container,false);
        lattitude = 33.605801;
        longtitude = 73.0333;
        setUpMapIfNeeded();
    }

    public static void setUpMapIfNeeded(){
        if (mMap==null){
            mMap= ((SupportMapFragment) MainActivity.fragMan.findFragmentById(R.id.location_map)).getMap();
            if(mMap!= null){
                setUpMap();
            }
        }
    }

    public static void setUpMap(){
        mMap.setMyLocationEnabled(true);
        mMap.addMarker(new MarkerOptions().position(new LatLng(lattitude, longtitude)).title("Here There Be Terrorists").snippet("Beware of Dragons!!"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lattitude,longtitude),12.0f));
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        if (mMap!=null){
            setUpMap();
        }

        if (mMap==null){
            mMap = ((SupportMapFragment)MainActivity.fragMan.findFragmentById(R.id.location_map)).getMap();
        }
    }


    public static NOQUMapFragment newInstance(double lat, double longt){
            NOQUMapFragment mapFragment = new NOQUMapFragment();
            return mapFragment;

        }
    }

