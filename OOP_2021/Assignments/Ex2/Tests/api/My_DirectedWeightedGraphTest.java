package api;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class My_DirectedWeightedGraphTest {
    int Edgcount=0,mc=0;
    boolean NodeIter=false, EdgeIter = false;
    HashMap<Integer,NodeData> Nodes = new HashMap<Integer, NodeData>();
    HashMap <Integer,HashMap<Integer,EdgeData>> Edgesrc = new HashMap<Integer,HashMap<Integer, EdgeData>>();
    HashMap <Integer,HashMap<Integer,EdgeData>> Edgedest = new HashMap<Integer,HashMap<Integer, EdgeData>>();

    My_DirectedWeightedGraphImpl test = new My_DirectedWeightedGraphImpl();
    My_GeoLocation first = new My_GeoLocation(0.0 , 0.0 ,0.0 );
    My_GeoLocation second = new My_GeoLocation(0.0 , 1.0 ,0.0 );
    My_GeoLocation third = new My_GeoLocation(1.0 , 1.0 ,0.0 );
    My_NodeData n0 =new My_NodeData(0,first);
    My_NodeData n1 =new My_NodeData(1,second);
    My_NodeData n2 =new My_NodeData(2,third);

    @Test
    void getNode() {
        test.addNode(n0);
        assertEquals(test.getNode(0),n0);
    }

    @Test
    void getEdge() {

        My_EdgeDataImpl x = new My_EdgeDataImpl(0,1,0.8);
        test.connect(0,1,0.8);
        assertEquals(test.getEdge(0,1).getDest(),x.getDest());
        assertEquals(test.getEdge(0,1).getSrc(),x.getSrc());
        assertEquals(test.getEdge(0,1).getWeight(),x.getWeight());

    }

    @Test
    void addNode() {
        test.addNode(n0);
        test.addNode(n1);
        assertEquals(test.getNode(0),n0);
        assertEquals(test.getNode(1),n1);
    }

    @Test
    void connect(int src , int deat , int w) {
        My_EdgeDataImpl x = new My_EdgeDataImpl(0,1,0.8);
        test.connect(0,1,0.8);
        assertEquals(test.getEdge(0,1).getDest(),x.getDest());
        assertEquals(test.getEdge(0,1).getSrc(),x.getSrc());
        assertEquals(test.getEdge(0,1).getWeight(),x.getWeight());

    }

    @Test
    void nodeIter() {
        try{
        test.addNode(n0);
        test.addNode(n1);
            Iterator<NodeData> it =test.nodeIter();
        int counter=0;

        while(it.hasNext()) {
           it.next();
            counter++;
        }
        assertEquals(2,counter);
        test.connect(0,1,0.8);
        }
        catch (RuntimeException e ){
            assertEquals(RuntimeException.class,e.getClass());
        }

    }

    @Test
    void edgeIterA() {
        try{
            test.addNode(n0);
            test.addNode(n1);
            test.addNode(n2);
            test.connect(0,1,0.8);
            test.connect(0,2,2.1);
            Iterator<EdgeData> it =test.edgeIter(0);
            int counter=0;

            while(it.hasNext()) {
                it.next();
                counter++;
            }
            assertEquals(2,counter);
            test.connect(0,1,0.8);
        }
        catch (RuntimeException e ){
            assertEquals(RuntimeException.class,e.getClass());
        }

    }
    @Test
    void edgeIterB() {
        try{
            test.addNode(n0);
            test.addNode(n1);
            test.addNode(n2);
            test.connect(2,1,0.8);
            test.connect(1,2,2.1);
            test.connect(0,1,0.8);
            test.connect(1,0,2.1);
            test.connect(2,0,0.8);
            test.connect(0,2,2.1);
            Iterator<EdgeData> it =test.edgeIter(0);
            int counter=0;

            while(it.hasNext()) {
                it.next();
                counter++;
            }
            assertEquals(6,counter);
            test.removeNode(0);
        }
        catch (RuntimeException e ){
            assertEquals(RuntimeException.class,e.getClass());
        }

    }

    @Test
    void removeNode() {
        test.addNode(n0);
        test.addNode(n1);
        test.addNode(n2);
        test.connect(0,1,0.8);
        test.connect(2,0,0.8);
        test.removeNode(0);
        assertEquals(test.nodeSize(),2);
        assertEquals(test.edgeSize(),0);
        assertNull(  test.removeNode(0));
    }

    @Test
    void removeEdge() {
        test.addNode(n0);
        test.addNode(n1);
        test.addNode(n2);
        test.connect(0,1,0.8);
        test.connect(2,0,0.8);
        test.removeEdge(2,0);
        assertEquals(test.edgeSize(),1);
        assertNull(  test.removeEdge(2,0));
    }

    @Test
    void nodeSize() {
        test.addNode(n0);
        test.addNode(n1);
        test.addNode(n2);
        assertEquals(test.nodeSize(),3);
    }

    @Test
    void edgeSize() {
        test.addNode(n0);
        test.addNode(n1);
        test.addNode(n2);
        test.connect(0,1,0.8);
        test.connect(2,0,0.8);
        assertEquals(test.edgeSize(),2);
    }

    @Test
    void getMC() {
        test.addNode(n0);
        test.addNode(n1);
        test.addNode(n2);
        test.connect(0,1,0.8);
        test.connect(0,2,0.8);
        test.removeEdge(0,2);
        test.removeNode(0);
        assertEquals(test.getMC(),7);
    }
}