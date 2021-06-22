package com.example.dwp.utils;

public class CityGeoPoint {
    // LONDON
    private static final double LONDON_LATITUDE = 51.444512;
    private static final double LONDON_LONGITUDE = -0.241852;

    //ATHENS
    private static final double ATHENS_LATITUDE = 37.982276;
    private static final double ATHENS_LONGITUDE = 23.723857;

    //MUNICH
    private static final double MUNICH_LATITUDE = 48.137584;
    private static final double MUNICH_LONGITUDE = 11.553821;

    //LIVERPOOL
    private static final double LIVERPOOL_LATITUDE = 53.417832;
    private static final double LIVERPOOL_LONGITUDE = -2.911314;

    //BRIGHTON
    private static final double BRIGHTON_LATITUDE = 51.775760;
    private static final double BRIGHTON_LONGITUDE = -1.260821;


    private static final GeoPoint londonGeo = new GeoPoint(LONDON_LATITUDE, LONDON_LONGITUDE);
    private static final GeoPoint athensGeo = new GeoPoint(ATHENS_LATITUDE, ATHENS_LONGITUDE);
    private static final GeoPoint munichGeo = new GeoPoint(MUNICH_LATITUDE, MUNICH_LONGITUDE);
    private static final GeoPoint liverpoolGeo = new GeoPoint(LIVERPOOL_LATITUDE, LIVERPOOL_LONGITUDE);
    private static final GeoPoint brightonGeo = new GeoPoint(BRIGHTON_LATITUDE, BRIGHTON_LONGITUDE);

    public static GeoPoint getFor(String city) {
        switch (city.toLowerCase()) {
            case "london":
                return londonGeo;
            case "athens":
                return athensGeo;
            case "munich":
                return munichGeo;
            case "liverpool":
                return liverpoolGeo;
            case "brighton":
                return brightonGeo;
            default:
                return new GeoPoint();
        }
    }
}
