package api;

import org.junit.Test;

import static org.junit.Assert.*;

public class My_GeoLocationTest {
    final double EPS = 0.000001;
    @Test
    public void distance() {
        GeoLocation g1 = new My_GeoLocation(0, 0, 0);
        GeoLocation g2 = new My_GeoLocation(1, 1, 1);
        double d = g1.distance(g2);
        assertEquals(d, 1.73205, EPS);
        g1 = new My_GeoLocation(1, 2, 3);
        g2 = new My_GeoLocation(-2, 4.7, 7);
        d = g1.distance(g2);
        assertEquals(d, 5.682429, EPS);
    }
}
