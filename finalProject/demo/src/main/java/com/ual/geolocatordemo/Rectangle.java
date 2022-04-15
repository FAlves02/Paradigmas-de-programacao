package com.ual.geolocatordemo;

import com.dlsc.gmapsfx.javascript.object.GMapObjectType;
import com.dlsc.gmapsfx.javascript.object.LatLongBounds;
import com.dlsc.gmapsfx.javascript.object.MapShape;
import com.dlsc.gmapsfx.shapes.RectangleOptions;

public class Rectangle extends MapShape {

    public Rectangle() {
        super(GMapObjectType.RECTANGLE);
    }

    public Rectangle(RectangleOptions opts) {
        super(GMapObjectType.RECTANGLE, opts);
    }

    //setBounds
    public void setBounds(LatLongBounds bounds) {
        invokeJavascript("setBounds", bounds);
    }

}