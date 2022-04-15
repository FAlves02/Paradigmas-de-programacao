package com.ual.geolocatordemo;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
import com.dlsc.gmapsfx.javascript.event.GMapMouseEvent;
import com.dlsc.gmapsfx.javascript.event.UIEventType;
import com.dlsc.gmapsfx.javascript.object.*;
import com.dlsc.gmapsfx.service.directions.DirectionStatus;
import com.dlsc.gmapsfx.service.directions.DirectionsResult;
import com.dlsc.gmapsfx.service.directions.DirectionsServiceCallback;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

public class MapFXMLController implements Initializable, MapComponentInitializedListener, DirectionsServiceCallback {

    private static String geocodingUrl = "https://api.bigdatacloud.net/data/reverse-geocode-client?localityLanguage=pt";

    @FXML
    protected GoogleMapView mapView;
    private static GoogleMap map;
    private static Marker marker;
    private static LatLong markerPosition;


    @Override
    public void directionsReceived(DirectionsResult results, DirectionStatus status) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInitializedListener(this);
    }

    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();
        options.center(new LatLong(39.765641, -7.969869))
                .zoom(6)
                .overviewMapControl(true)
                .scrollWheel(true)
                .disableDoubleClickZoom(true)
                .zoomControl(false)
                .mapType(MapTypeIdEnum.ROADMAP);

        map = mapView.createMap(options,false);
        map.addMouseEventHandler(UIEventType.click, (GMapMouseEvent event) -> {
            getMapInfo(markerPosition);
            InfoWindowOptions infoOptions = new InfoWindowOptions();
            infoOptions.content("<h2>Here's an info window</h2><h3>with some info</h3>");
            InfoWindow window = new InfoWindow(infoOptions);
            window.open(map, marker);
        });
        addMarker(map);
    }


    public void addMarker(GoogleMap map){
        MarkerOptions Moptions = new MarkerOptions();
        Moptions .visible(true);
        LatLong initialMarkerPosition = new LatLong(36.9715223, -9.2428545);
        Moptions.position(initialMarkerPosition);
        markerPosition = initialMarkerPosition;
        marker = new Marker(Moptions);
        map.addMarker(marker);
    }

    public static void UpdateMarker(LatLong latLong){
        markerPosition = latLong;
        marker.setPosition(latLong);
    }

    public String[] getMapInfo(LatLong latLong) {
        URL yahoo = null;
        int cnt=0;
        String[] details = new String[4];
        try {
            yahoo = new URL(geocodingUrl + "&latitude=" + latLong.getLatitude() + "&longitude=" + latLong.getLongitude());
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                try {
                    System.out.println(inputLine);
                    if(inputLine.substring(9,13).equals("name")){
                        details[cnt]=inputLine.substring(17,inputLine.length()-2);
//                        System.out.println(inputLine.substring(17,inputLine.length()-2));
                        cnt++;
                    }
                }
            catch (Exception ex){
                    continue;
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return details;
    }

}