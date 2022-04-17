module com.ual.geolocatordemo {
    requires javafx.controls;
    requires javafx.fxml;

//    requires GMapsFX;
    requires com.dlsc.gmapsfx;
    requires java.net.http;
    requires json.simple;

    opens com.ual.geolocatordemo to javafx.fxml;
    exports com.ual.geolocatordemo;
    exports com.ual.geolocatordemo.controller;
    opens com.ual.geolocatordemo.controller to javafx.fxml;
}