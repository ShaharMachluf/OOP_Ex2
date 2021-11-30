package api;

import org.junit.Test;

import static org.junit.Assert.*;
class EdgeDataTest {
    int Src=10,Dest=0,tag=1;
    double weight=0.4;
    String Info = "blalalal";
    My_EdgeDataImpl test = new My_EdgeDataImpl(Src,Dest,weight,Info,tag);
    @org.junit.jupiter.api.Test
    void getSrc() {
        assertEquals(test.getSrc(),Src);
    }

    @org.junit.jupiter.api.Test
    void getDest() {
        assertEquals(test.getDest(),Dest);
    }

    @org.junit.jupiter.api.Test
    void getWeight() {assertEquals((int) test.getWeight(),(int) weight);
    }

    @org.junit.jupiter.api.Test
    void getInfo() {assertEquals(test.getInfo(),Info);
    }

    @org.junit.jupiter.api.Test
    void setInfo() {
        test.setInfo("a");
        assertEquals(test.getInfo(),"a");
    }

    @org.junit.jupiter.api.Test
    void getTag() {assertEquals(test.getTag(),tag);

    }

    @org.junit.jupiter.api.Test
    void setTag() {
    }
}