package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class My_DirectedWeightedGraphAlgorithmsImpl implements DirectedWeightedGraphAlgorithms {
    private  My_DirectedWeightedGraphImpl Graph ;

    public  My_DirectedWeightedGraphAlgorithmsImpl()
    {
        this.Graph=new My_DirectedWeightedGraphImpl();
    }

    @Override
    public void init(DirectedWeightedGraph g) {
        this.Graph=new My_DirectedWeightedGraphImpl();
        Iterator <NodeData> itn = g.nodeIter();
        while(itn.hasNext()){
            this.Graph.addNode(itn.next());
        }
        Iterator <EdgeData> ite = g.edgeIter();
        while(ite.hasNext()){
            EdgeData e = ite.next();
            this.Graph.connect(e.getSrc(), e.getDest(), e.getWeight());
        }
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
        DirectedWeightedGraph GTranspose = new My_DirectedWeightedGraphImpl(Graph.getNodes(), Graph.getEdgedest(), Graph.getEdgesrc(), Graph.getEdges());
        NodeData start = Graph.nodeIter().next();
        if(dfs(Graph, start) < Graph.nodeSize()){
            return false;
        }
        return dfs(GTranspose, start) == GTranspose.nodeSize();
    }

    private int dfs (DirectedWeightedGraph G, NodeData start){
        Iterator <NodeData> it = G.nodeIter();
        while(it.hasNext()){
            it.next().setTag(0);
        }
        int count =0;
        count = dfs_visit(count, start, G);
        return count;
    }

    private int dfs_visit(int count, NodeData n, DirectedWeightedGraph G){
        n.setTag(1);
        count++;
        Iterator<EdgeData> it = G.edgeIter(n.getKey());
        while(it.hasNext()){
            NodeData n2 = G.getNode(it.next().getDest());
            if(n2.getTag() == 0){
                dfs_visit(count, n2, G);
            }
        }
        return count;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        if(src == dest){
            return 0;
        }
        List<NodeData> l = shortestPath(src,dest);
        if(l == null){
            return -1;
        }
        double pathSize = 0;
        Iterator <NodeData> itSrc= l.listIterator();
        Iterator <NodeData> itDest= l.listIterator();
        itDest.next();
        while(itDest.hasNext()){
            EdgeData e =Graph.getEdge(itSrc.next().getKey(), itDest.next().getKey());
            pathSize += e.getWeight();
        }
        return pathSize;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {//inspired by stackbuse.com/graphs-in-java-dijkstras-algorithms/
        List <NodeData> pathList = new ArrayList<>();
        int parent = Integer.MAX_VALUE;
        HashMap<Integer,Integer> changed = new HashMap<>();
        changed.put(src,null);
        HashMap<Integer,Double> shortestPathMap = new HashMap<>();
        Iterator <NodeData> it = Graph.nodeIter();
        while(it.hasNext()){
            NodeData n =it.next();
            if(n.getKey() == src){
                shortestPathMap.put(src,0.0);
            }else{
                shortestPathMap.put(n.getKey(),Double.POSITIVE_INFINITY);
            }
        }
        Iterator <EdgeData> itE = Graph.edgeIter(src);
        while(itE.hasNext()){
            EdgeData e = itE.next();
            shortestPathMap.put(e.getDest(),e.getWeight());
            changed.put(e.getDest(),src);
        }
        Graph.getNode(src).setTag(1);//visited
        while(true){
            NodeData currNode = closestReachableUnvisited(shortestPathMap);
            if(currNode == null){
                return null;
            }
            if(currNode.getKey() == dest) {
                int child = dest;
                pathList.add(0,Graph.getNode(dest));
                while (true) {
                    parent = changed.get(child);
                    if(parent == Integer.MAX_VALUE){
                        break;
                    }
                    pathList.add(0,Graph.getNode(parent));
                    child = parent;
                }
                pathList.add(0,Graph.getNode(src));
                return pathList;
            }
            currNode.setTag(1);
            Iterator <EdgeData> itEdges = Graph.edgeIter(currNode.getKey());
            while(itEdges.hasNext()){
                EdgeData e = itEdges.next();
                if(Graph.getNode(e.getDest()).getTag() == 1){
                    continue;
                }
                if(shortestPathMap.get(currNode.getKey()) + e.getWeight() < shortestPathMap.get(e.getDest())){
                    shortestPathMap.put(e.getDest(), shortestPathMap.get(currNode.getKey())+e.getWeight());
                    changed.put(e.getDest(), currNode.getKey());
                }
            }
        }
    }

    private NodeData closestReachableUnvisited(HashMap<Integer,Double> ShortestPathMap){
        double shortestDist = Double.POSITIVE_INFINITY;
        NodeData closestReachableNode = null;
        Iterator <NodeData> it = Graph.nodeIter();
        while(it.hasNext()){
            NodeData n = it.next();
            if(n.getTag() == 1){
                continue;
            }
            double currDist = ShortestPathMap.get(n.getKey());
            if(currDist == Double.POSITIVE_INFINITY){
                continue;
            }
            if(currDist < shortestDist){
                shortestDist = currDist;
                closestReachableNode = n;
            }
        }
        return closestReachableNode;
    }

    @Override
    public NodeData center() {
        int size = this.Graph.getNodes().size();
        double min =  Double.MAX_VALUE;
        double [][] matrix = new double[size][size];
        double maxrow = 0,maxmin=Double.MAX_VALUE;
        NodeData ans =null;
        for (int i=0 ; i <size ;i++)
        {
            for(int j=0;j<size;j++) {
                if(i==j)
                    matrix[i][j]=Integer.MAX_VALUE;
                matrix[i][j]=shortestPathDist(i,j);
            }

        }

        for (int i=0 ; i <size ;i++)
        {
            for(int j=0;j<size;j++) {
                if(i==j)
                    continue;

                if(maxrow<matrix[i][j])
                    maxrow=matrix[i][j];
            }

            if(maxmin>maxrow) {
                maxmin = maxrow;
                ans=this.Graph.getNode(i);
            }
        }

        return ans;
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
