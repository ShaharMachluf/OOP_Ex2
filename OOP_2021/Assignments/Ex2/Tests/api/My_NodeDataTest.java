package api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class My_NodeDataTest {
    GeoLocation g = new My_GeoLocation(0,0,0);
    My_NodeData n = new My_NodeData(1,g,0.0,"",1);
    @Test
    void getKey() {
        int k = n.getKey();
        assertEquals(k, 1);
    }

    @Test
    void getLocation() {
        GeoLocation g1 = n.getLocation();
        assertEquals(g.x(), g1.x());
        assertEquals(g.y(),g1.y());
        assertEquals(g.z(), g1.z());
    }

    @Test
    void setLocation() {
        GeoLocation g2 = new My_GeoLocation(1,1,1);
        n.setLocation(g2);
        GeoLocation g3 = n.getLocation();
        assertEquals(g2.x(),g3.x());
        assertEquals(g2.y(),g3.y());
        assertEquals(g2.z(),g3.z());
    }

    @Test
    void getWeight() {
        double w = n.getWeight();
        assertEquals(w, 0.0);
    }

    @Test
    void setWeight() {
        n.setWeight(1.0);
        assertEquals(n.getWeight(),1.0);
    }

    @Test
    void getInfo() {
        String i = n.getInfo();
        assertTrue(i.equals(""));
    }

    @Test
    void setInfo() {
        n.setInfo("1");
        String i = n.getInfo();
        assertTrue(i.equals("1"));
    }

    @Test
    void getTag() {
        int t = n.getTag();
        assertEquals(t, 1);
    }

    @Test
    void setTag() {
        n.setTag(2);
        int t = n.getTag();
        assertEquals(t,2);
    }
}