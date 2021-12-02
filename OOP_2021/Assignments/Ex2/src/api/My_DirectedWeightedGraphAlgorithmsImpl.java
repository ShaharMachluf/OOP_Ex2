package api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.util.List;

public class My_DirectedWeightedGraphAlgorithmsImpl implements DirectedWeightedGraphAlgorithms {
   private  My_DirectedWeightedGraphImpl Graph ;

   public  My_DirectedWeightedGraphAlgorithmsImpl()
   {
       this.Graph=new My_DirectedWeightedGraphImpl();
   }

    @Override
    public void init(DirectedWeightedGraph g) {
        this.Graph=(My_DirectedWeightedGraphImpl) g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.Graph;
    }

    @Override
    public DirectedWeightedGraph copy() {
        return new My_DirectedWeightedGraphImpl(this.Graph);

    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        return 0;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        return null;
    }

    @Override
    public NodeData center() {
        return null;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return null;
    }

    @Override
    public boolean save(String file) {
       try {
           Gson gson = new Gson();
           gson.toJson(new FileWriter(file));
           return false;
       }
       catch (Exception a)
       {

       }

    }

    @Override
    public boolean load(String file) {
        return false;
    }
}
