package api;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class My_DirectedWeightedGraphAlgorithmsImplTest {
    public  My_DirectedWeightedGraphAlgorithmsImpl test  ;
    @Test
    void init() {
        DirectedWeightedGraphAlgorithms a = new My_DirectedWeightedGraphAlgorithmsImpl();
        DirectedWeightedGraph g1 = new My_DirectedWeightedGraphImpl();
        NodeData n1 = new My_NodeData(1, new My_GeoLocation(1.0,1.0,0.0));
        NodeData n2 = new My_NodeData(2, new My_GeoLocation(2.0,2.0,0.0));
        g1.addNode(n1);
        g1.addNode(n2);
        g1.connect(n1.getKey(),n2.getKey(), 3.0);
        a.init(g1);
        DirectedWeightedGraph g2 = a.getGraph();
        Iterator <NodeData> it1 = g1.nodeIter();
        Iterator <NodeData> it2 = g2.nodeIter();
        while(it1.hasNext()&& it2.hasNext()){
            assertEquals(it1.next().getKey(),it2.next().getKey());
        }
        Iterator <EdgeData> it11= g1.edgeIter();
        Iterator <EdgeData> it22= g2.edgeIter();
        while(it11.hasNext()&& it22.hasNext()){
            assertEquals(it11.next().getSrc(),it22.next().getSrc());
        }
    }

    @Test
    void getGraph() {
        DirectedWeightedGraphAlgorithms a = new My_DirectedWeightedGraphAlgorithmsImpl();
        DirectedWeightedGraph g1 = new My_DirectedWeightedGraphImpl();
        NodeData n1 = new My_NodeData(1, new My_GeoLocation(1.0,1.0,0.0));
        NodeData n2 = new My_NodeData(2, new My_GeoLocation(2.0,2.0,0.0));
        g1.addNode(n1);
        g1.addNode(n2);
        g1.connect(n1.getKey(),n2.getKey(), 3.0);
        a.init(g1);
        DirectedWeightedGraph g2 = a.getGraph();
        Iterator <NodeData> it1 = g1.nodeIter();
        Iterator <NodeData> it2 = g2.nodeIter();
        while(it1.hasNext()&& it2.hasNext()){
            assertEquals(it1.next().getKey(),it2.next().getKey());
        }
        Iterator <EdgeData> it11= g1.edgeIter();
        Iterator <EdgeData> it22= g2.edgeIter();
        while(it11.hasNext()&& it22.hasNext()){
            assertEquals(it11.next().getSrc(),it22.next().getSrc());
        }
    }

    @Test
    void copy() {
        DirectedWeightedGraphAlgorithms a = new My_DirectedWeightedGraphAlgorithmsImpl();
        DirectedWeightedGraph g1 = new My_DirectedWeightedGraphImpl();
        NodeData n1 = new My_NodeData(1, new My_GeoLocation(1.0,1.0,0.0));
        NodeData n2 = new My_NodeData(2, new My_GeoLocation(2.0,2.0,0.0));
        g1.addNode(n1);
        g1.addNode(n2);
        g1.connect(n1.getKey(),n2.getKey(), 3.0);
        a.init(g1);
        DirectedWeightedGraph g2 = a.copy();
        Iterator <NodeData> it1 = g1.nodeIter();
        Iterator <NodeData> it2 = g2.nodeIter();
        while(it1.hasNext()&& it2.hasNext()){
            assertEquals(it1.next().getKey(),it2.next().getKey());
        }
        Iterator <EdgeData> it11= g1.edgeIter();
        Iterator <EdgeData> it22= g2.edgeIter();
        while(it11.hasNext()&& it22.hasNext()){
            assertEquals(it11.next().getSrc(),it22.next().getSrc());
        }
    }

    @Test
    void isConnected() {
        DirectedWeightedGraphAlgorithms a = new My_DirectedWeightedGraphAlgorithmsImpl();
        DirectedWeightedGraph g1 = new My_DirectedWeightedGraphImpl();
        NodeData n1 = new My_NodeData(1, new My_GeoLocation(1.0,1.0,0.0));
        NodeData n2 = new My_NodeData(2, new My_GeoLocation(2.0,2.0,0.0));
        NodeData n3 = new My_NodeData(3, new My_GeoLocation(3.0,3.0,0.0));
        g1.addNode(n1);
        g1.addNode(n2);
        g1.addNode(n3);
        g1.connect(n1.getKey(),n2.getKey(),1.2);
        g1.connect(n2.getKey(), n3.getKey(), 3.4);
        DirectedWeightedGraph g2 = new My_DirectedWeightedGraphImpl((My_DirectedWeightedGraphImpl) g1);
        a.init(g1);
        assertFalse(a.isConnected());
        a.init(g2);
        a.getGraph().connect(n3.getKey(), n1.getKey(), 3);
        assertTrue(a.isConnected());
    }

    @Test
    void shortestPathDist() {
    }

    @Test
    void shortestPath() {
    }

    @Test
    void center() {
    }

    @Test
    void tsp() {
    }

    @Test
    void save() {

    }

    @Test
    void load() {
        My_DirectedWeightedGraphAlgorithmsImpl lol =new My_DirectedWeightedGraphAlgorithmsImpl();
        lol.load("C:/Users/shaim/IdeaProjects/OOP_Ex2/OOP_2021/Assignments/Ex2/data/G1.json");
        assertNotNull(lol.getGraph());
    }
}
