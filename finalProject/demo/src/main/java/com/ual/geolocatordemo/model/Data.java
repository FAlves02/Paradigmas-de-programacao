package com.ual.geolocatordemo.model;


import com.dlsc.gmapsfx.javascript.object.LatLong;

// contains data returned by external API
public class Data {

    private String countryName;
    private String city;
    private String locality;


    public String getCountryName() {
        return countryName;
    }

    public String getCity() {
        return city;
    }

    public String getLocality() {
        return locality;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getHtmlPage(LatLong latLong) {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <body>\n" +
                "\n" +
                "    <p><b>Country: </b>" + getCountryName() + " </p>\n" +
                "    <p><b>City: </b>" + getCity() +  "  </p>\n" +
                "    <p><b>Locality: </b> " + getLocality() + "  </p>\n" +
                "\n" +
                "    <p>Lat: " + latLong.getLatitude() + " </p>\n" +
                "    <p>Long: " + latLong.getLongitude() + " </p>\n" +
                "\n" +
                "    </body>\n" +
                "</html>";
    }

}
