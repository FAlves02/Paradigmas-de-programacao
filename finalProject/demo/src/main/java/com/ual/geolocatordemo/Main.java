package com.ual.geolocatordemo;

import com.dlsc.gmapsfx.javascript.object.LatLong;
import com.ual.geolocatordemo.controller.MapFXMLController;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 600;

    private Slider xSlider;
    private Slider ySlider;
    private Label xlabel;
    private Label ylabel;
    private double currLat=36.9715223 ;
    private double currLog=-9.2428545 ;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        drawLayout(stage);
    }

    public void drawLayout(Stage stage) throws IOException {
        stage.setTitle("Geolocation");
        BorderPane borderPanel = new BorderPane();
        //38.7690907,-8.7873661,7 (oeste)
        //39.2875888,-9.2428545 (este)
        //36.9715223,-7.8953387 (sul de portugal)
        //41.7058314,-7.4149595 (norte)
        // header slider and label
        HBox header = new HBox();
        xSlider = new Slider(0,300,5);
        xSlider.setValue(1);
        xSlider.setShowTickLabels(true);
        xSlider.setShowTickLabels(true);
        xSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                if (newValue == null) {
                    return;
                }
                xlabel.setText("x: " + Math.round(newValue.intValue()));
                MapFXMLController.UpdateMarker(calculateLat(newValue.intValue()));
            }
        });
        xlabel = new Label("x: 0");
        xlabel.setPadding(new Insets(0,0,0,30));
        ylabel = new Label("y: 0");
        ylabel.setPadding(new Insets(0,0,0,15));
        header.getChildren().addAll(xSlider, xlabel, ylabel);
        header.setPadding(new Insets(10,0,10,0));
        header.setMaxWidth(Double.MAX_VALUE);
        header.setMaxHeight(Double.MAX_VALUE);
        header.setAlignment(Pos.CENTER);
        borderPanel.setTop(header);

        // body map and slider
        HBox body = new HBox();
        body.setPadding(new Insets(0,0,25, 0));
        Parent map = FXMLLoader.load(getClass().getResource("/com/ual/geolocatordemo/Scene.fxml"));
        Slider ySlider = new Slider(0,600,50);
        ySlider.setValue(0);
        ySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                if (newValue == null) {
                    return;
                }
                ylabel.setText("y: " + Math.round(newValue.intValue()) );
                MapFXMLController.UpdateMarker(calculateLong(newValue.intValue()));

            }
        });
        ySlider.setShowTickLabels(true);
        ySlider.setShowTickLabels(true);
        ySlider.setOrientation(Orientation.VERTICAL);
        ySlider.setMaxHeight(250);
        ySlider.setMinHeight(100);
        ySlider.setPadding(new Insets(0,0,0,35));
        body.getChildren().addAll(map,  ySlider);
        body.setMaxHeight(Double.MAX_VALUE);
        body.setMaxWidth(Double.MAX_VALUE);
        body.setAlignment(Pos.CENTER);
        borderPanel.setCenter(body);

        Scene scene = new Scene(borderPanel, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public LatLong calculateLong(int y) {
        currLat =  36.9715223 + (0.0078* y);//y
        return new LatLong(currLat,currLog);
    }
    public LatLong calculateLat(int x) {
        currLog = -9.2428545 + (0.009 * x);//x
        return new LatLong(currLat,currLog);
    }

}
