package api;

import java.util.HashMap;
import java.util.Iterator;

public class My_DirectedWeightedGraphImpl implements DirectedWeightedGraph {
    private int Edgecount=0,mc=0;
    private boolean Iter=false;
    private HashMap <Integer,NodeData> Nodes = new HashMap<Integer, NodeData>();
    private HashMap <Integer,HashMap<Integer,EdgeData>> Edgesrc = new HashMap<Integer,HashMap<Integer, EdgeData>>();
    private HashMap <Integer,HashMap<Integer,EdgeData>> Edgedest = new HashMap<Integer,HashMap<Integer, EdgeData>>();

    public My_DirectedWeightedGraphImpl(My_DirectedWeightedGraphImpl a )
    {
        this.Edgecount=a.getEdgecount();
        this.mc=a.getMC();
        this.Edgedest=a.getEdgedest();
        this.Edgesrc=a.getEdgesrc();
        this.Nodes=a.getNodes();
    }
    public  HashMap<Integer,NodeData> getNodes()
    {
        return this.Nodes;
    }

    public int getEdgecount()
    {
        return this.Edgecount;
    }
    public HashMap<Integer,HashMap<Integer,EdgeData>> getEdgedest()
    {
        return this.Edgedest;
    }
    public HashMap<Integer,HashMap<Integer,EdgeData>> getEdgesrc()
    {
        return this.Edgesrc;
    }

    @Override
    public NodeData getNode(int key) {
        return this.Nodes.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {

        return this.Edgesrc.get(src).get(dest);
    }

    @Override
    public void addNode(NodeData n) {
        this.Nodes.put(n.getKey(),n);
        this.mc++;
    }

    @Override
    public void connect(int src, int dest, double w) {
        EdgeData e = new My_EdgeDataImpl(src,dest,w);
        if(Edgesrc.containsKey(src))
            Edgesrc.get(src).put(dest,e);
        else
        {
            HashMap<Integer,EdgeData> p = new HashMap<Integer,EdgeData>();
            p.put(dest,e);
            Edgesrc.put(src,p);
        }
        if(Edgedest.containsKey(dest))
            Edgedest.get(dest).put(src,e);
        else
        {
            HashMap<Integer,EdgeData> p = new HashMap<Integer,EdgeData>();
            p.put(src,e);
            Edgesrc.put(src,p);
        }
        this.mc++;
    }

    @Override
    public Iterator<NodeData> nodeIter() {
    if(Iter==false)
    {

    }

    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        return null;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return null;
    }

    @Override
    public NodeData removeNode(int key) {
        return null;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        return null;
    }

    @Override
    public int nodeSize() {
        return 0;
    }

    @Override
    public int edgeSize() {
        return 0;
    }

    @Override
    public int getMC() {
        return 0;
    }
}
