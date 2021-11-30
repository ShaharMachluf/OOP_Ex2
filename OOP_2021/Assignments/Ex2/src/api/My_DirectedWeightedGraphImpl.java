package api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class My_DirectedWeightedGraphImpl implements DirectedWeightedGraph {
    private int Edgecount=0,mc=0;
    private boolean NodeIter=false, EdgeIter = false;
    private HashMap <Integer,NodeData> Nodes = new HashMap<Integer, NodeData>();
    /*for the edges we created two hashmaps of hashmaps, the Edgesrc hashmap's keys are the sources of the edges and
    the values are hashmaps that their keys are the destinations of the edges coming out of the src key and their values
    are the edges data. the Edgedest hashmap is the opposite.
     */
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
        if(this.NodeIter){
            throw new RuntimeException();
        }
        this.Nodes.put(n.getKey(),n);
        this.mc++;
    }

    @Override
    public void connect(int src, int dest, double w) {
        if(NodeIter) {
            throw new RuntimeException();
        }
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
            Edgedest.put(src,p);
        }
        this.Edgecount++;
        this.mc++;
    }

    @Override
    public Iterator<NodeData> nodeIter() {
        Iterator<NodeData> iter = Nodes.values().iterator();
        this.NodeIter = true;
        return iter;
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        return null;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        Iterator<EdgeData> iter = Edgesrc.get(node_id).values().iterator();
        this.EdgeIter = true;
        return iter;
    }

    @Override
    public NodeData removeNode(int key) {
        if(NodeIter){
            throw new RuntimeException();
        }
        if(!Nodes.containsKey(key)){
            return null;
        }
        NodeData n = getNode(key);
        this.Nodes.remove(key);
        //remove all the edges that come out of key node
        Set<Integer> dests = Edgesrc.get(key).keySet();
        Iterator<Integer> it = dests.iterator();
        Edgedest.get(it).remove(key);
        Edgecount--;
        while(it.hasNext()){
            Edgedest.get(it.next()).remove(key);
            Edgecount--;
            it.next();
        }
        Edgesrc.remove(key);
        //remove all the edges that go into key node
        Set<Integer> srcs = Edgedest.get(key).keySet();
        it = srcs.iterator();
        Edgesrc.get(it).remove(key);
        Edgecount--;
        while(it.hasNext()){
            Edgesrc.get(it.next()).remove(key);
            Edgecount--;
            it.next();
        }
        Edgedest.remove(key);
        this.mc++;
        return n;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        if(!Edgesrc.containsKey(src)){
            return null;
        }
        if(NodeIter){
            throw new RuntimeException();
        }
        EdgeData e = getEdge(src, dest);
        this.Edgesrc.get(src).remove(dest);
        this.Edgesrc.get(dest).remove(src);
        this.Edgecount--;
        this.mc++;
        return e;
    }

    @Override
    public int nodeSize() {
        return this.Nodes.size();
    }

    @Override
    public int edgeSize() {
        return this.Edgecount;
    }

    @Override
    public int getMC() {
        return mc;
    }
}
