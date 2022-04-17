package com.ual.geolocatordemo.controller;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
import com.dlsc.gmapsfx.javascript.event.GMapMouseEvent;
import com.dlsc.gmapsfx.javascript.event.UIEventType;
import com.dlsc.gmapsfx.javascript.object.*;
import com.dlsc.gmapsfx.service.directions.DirectionStatus;
import com.dlsc.gmapsfx.service.directions.DirectionsResult;
import com.dlsc.gmapsfx.service.directions.DirectionsServiceCallback;
import com.ual.geolocatordemo.model.Data;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class MapFXMLController implements Initializable, MapComponentInitializedListener, DirectionsServiceCallback {

    private static String apiServerUrl = "https://api.bigdatacloud.net/data/reverse-geocode-client?localityLanguage=pt";

    @FXML
    protected GoogleMapView mapView;

    private static GoogleMap map;
    private static Marker marker;
    private static LatLong currentMarkerPosition;


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

        map = mapView.createMap(options, false);
        map.addMouseEventHandler(UIEventType.click, (GMapMouseEvent event) -> {
            Data data = getMapInfo(currentMarkerPosition);
            InfoWindowOptions infoOptions = new InfoWindowOptions();
            infoOptions.content(data.getHtmlPage(currentMarkerPosition));
            InfoWindow window = new InfoWindow(infoOptions);
            window.open(map, marker);
        });
        addMarker(map);
    }


    public void addMarker(GoogleMap map) {
        MarkerOptions Moptions = new MarkerOptions();
        LatLong initialMarkerPosition = new LatLong(36.9715223, -9.2428545);
        Moptions.position(initialMarkerPosition)
                .visible(true)
                .title("My new Marker")
                .animation(Animation.DROP);
        currentMarkerPosition = initialMarkerPosition;
        marker = new Marker(Moptions);
        map.addMarker(marker);
    }

    public static void UpdateMarker(LatLong latLong) {
        currentMarkerPosition = latLong;
        marker.setPosition(latLong);
    }

    public Data getMapInfo(LatLong latLong) {
        Data data = new Data();
        try {
            URL url = new URL(apiServerUrl + "&latitude=" + latLong.getLatitude() + "&longitude=" + latLong.getLongitude());
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.setDoOutput(true);
            request.setRequestMethod("GET");
            request.connect();

            String apiResponse = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String inputLine;
            while ((inputLine = reader.readLine()) != null) apiResponse += inputLine;

            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(apiResponse);

            data = new Data();
            data.setCity((String) obj.get("city"));
            data.setCountryName((String) obj.get("countryName"));
            data.setLocality((String) obj.get("locality"));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

}