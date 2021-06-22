package com.example.dwp;

import com.example.dwp.utils.GeoPoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoPointTest {

    @Test
    void test() {
        GeoPoint geoPoint = new GeoPoint(51.444512, -0.241852);
        assertEquals(51.444512, geoPoint.getLatitude());
        assertEquals(-0.241852, geoPoint.getLongitude());

        geoPoint.setLatitude(37.982276);
        geoPoint.setLongitude(23.723857);
        assertEquals(37.982276, geoPoint.getLatitude());
        assertEquals(23.723857, geoPoint.getLongitude());

    }
}
