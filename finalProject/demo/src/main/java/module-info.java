module com.ual.geolocatordemo {
    requires javafx.controls;
    requires javafx.fxml;

//    requires GMapsFX;
    requires com.dlsc.gmapsfx;

    opens com.ual.geolocatordemo to javafx.fxml;
    exports com.ual.geolocatordemo;
}