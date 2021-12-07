package api;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class My_DirectedWeightedGraphAlgorithmsImplTest {
    public  My_DirectedWeightedGraphAlgorithmsImpl test  ;
    @Test
    void init() {
    }

    @Test
    void getGraph() {
    }

    @Test
    void copy() {
    }

    @Test
    void isConnected() {
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