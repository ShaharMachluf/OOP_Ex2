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
            Writer writer = new FileWriter(file);
            gson.toJson(this.Graph, writer);
            writer.close();
            return true;
        }
        catch (Exception a)
        {
            return false;
        }
    }

    @Override
    public boolean load(String file) {
        try {
            Gson gson = new Gson();
            FileReader reader =new FileReader(file);
            HashMap<String, List<HashMap>> h = gson.fromJson(reader, HashMap.class);
            List <HashMap> nodes = h.get("Nodes");
            Iterator <HashMap> it = nodes.iterator();
            while(it.hasNext()){
                HashMap n = it.next();
                int key = Integer.parseInt((String) n.get("id"));
                String[] location = ((String)n.get("pos")).split(",");
                GeoLocation g = new My_GeoLocation(Double.parseDouble(location[0]), Double.parseDouble(location[1]), Double.parseDouble(location[2]));
                Graph.addNode(new My_NodeData(key, g));
            }
            List <HashMap> edges = h.get("Edges");
            it = edges.iterator();
            while(it.hasNext()){
                HashMap e = it.next();
                int src = Integer.parseInt((String) e.get("src"));
                int dest = Integer.parseInt((String) e.get("dest"));
                double weight = Double.parseDouble((String) e.get("w"));
                Graph.connect(src, dest, weight);
            }
            reader.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
