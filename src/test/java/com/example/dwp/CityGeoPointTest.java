package com.example.dwp;

import com.example.dwp.utils.CityGeoPoint;
import com.example.dwp.utils.GeoPoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityGeoPointTest {

    @Test
    void getForTest() {
        GeoPoint londonGeoPoint = CityGeoPoint.getFor("London");
        GeoPoint geoPoint = new GeoPoint(51.444512, -0.241852);
        assertEquals(geoPoint, londonGeoPoint);

        GeoPoint fooGeoPoint = CityGeoPoint.getFor("Foo");
        GeoPoint geoPoint2 = new GeoPoint();
        assertEquals(geoPoint2, fooGeoPoint);
    }
}
