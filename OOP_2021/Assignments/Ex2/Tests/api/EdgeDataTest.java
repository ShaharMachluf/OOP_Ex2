package api;

import src.My_EdgeDataImpl;
import org.junit.Assert;
import static  org.junit.Assert.*;
class EdgeDataTest {
    int Src=10,Dest=0,tag=1;
    double weight=0.4;
    String Info = "blalalal";
    Ex2.src.My_EdgeDataImpl test = new My_EdgeDataImpl(Src,Dest,weight,Info,tag);
    @org.junit.jupiter.api.Test
    void getSrc() {
        assertEquals(test.getSrc(),Src);
    }

    @org.junit.jupiter.api.Test
    void getDest() {
        assertEquals(test.getDest(),Dest);
    }

    @org.junit.jupiter.api.Test
    void getWeight() {
    }

    @org.junit.jupiter.api.Test
    void getInfo() {
    }

    @org.junit.jupiter.api.Test
    void setInfo() {
    }

    @org.junit.jupiter.api.Test
    void getTag() {
    }

    @org.junit.jupiter.api.Test
    void setTag() {
    }
}