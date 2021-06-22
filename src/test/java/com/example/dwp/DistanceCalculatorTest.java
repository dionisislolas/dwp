package com.example.dwp;

import com.example.dwp.utils.DistanceCalculator;
import com.example.dwp.utils.CityGeoPoint;
import com.example.dwp.utils.GeoPoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DistanceCalculatorTest {

    @Test
    public void testDistanceCalculator() {
        // given we have 3 geo-points

        // London
        GeoPoint londonGeo = CityGeoPoint.getFor("London");

        // Liverpool
        GeoPoint liverpoolGeo = CityGeoPoint.getFor("Liverpool");

        // Brighton
        GeoPoint brightonGeo = CityGeoPoint.getFor("Brighton");

        // when we calculate the distance between tow
        double distance1 =
                DistanceCalculator.getDistanceInMiles(
                        liverpoolGeo.getLatitude(), liverpoolGeo.getLongitude(),
                        londonGeo.getLatitude(), londonGeo.getLongitude());

        double distance2 =
                DistanceCalculator.getDistanceInMiles(
                        brightonGeo.getLatitude(), brightonGeo.getLongitude(),
                        londonGeo.getLatitude(), londonGeo.getLongitude());

        double distance3 =
                DistanceCalculator.getDistanceInMiles(
                        brightonGeo.getLatitude(), brightonGeo.getLongitude(),
                        liverpoolGeo.getLatitude(), liverpoolGeo.getLongitude());

        // then the distance must be correct
        Assertions.assertTrue(distance1 > 50);
        Assertions.assertTrue(distance2 < 50);
        Assertions.assertTrue(distance3 > 50);

    }
}
