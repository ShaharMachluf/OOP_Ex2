package api;

import com.google.gson.*;
import org.w3c.dom.Node;

import java.io.*;
import java.sql.Array;
import java.util.*;

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
        DirectedWeightedGraph GTranspose = new My_DirectedWeightedGraphImpl();
        Iterator <NodeData> itn = Graph.nodeIter();
        while(itn.hasNext()){
            GTranspose.addNode(itn.next());
        }
        Iterator <EdgeData> ite = Graph.edgeIter();
        while(ite.hasNext()){
            EdgeData e = ite.next();
            GTranspose.connect(e.getDest(),e.getSrc(),e.getWeight());
        }
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
        if(it == null){
            return count;
        }
        while(it.hasNext()){
            NodeData n2 = G.getNode(it.next().getDest());
            if(n2.getTag() == 0){
                count = dfs_visit(count, n2, G);
            }
        }
        return count;
    }

    public  List<NodeData> getShortestPathTo(int src,int dest) {
        int size = this.Graph.nodeSize();
        Iterator<NodeData> it = this.Graph.nodeIter();
        NodeData [] cols = new NodeData[size];
        NodeData [] rows = new NodeData[size];
        cols[0] = this.Graph.getNode(src);
        int n=1;
        while(it.hasNext()){
            NodeData curr = it.next();
            if(curr.getKey() != src) {
                cols[n] = curr;
                n++;
            }
        }
        double[][] ans = new double[size][size];
        ans[0][0] = 0;
        rows[0] = Graph.getNode(src);
        double min = Double.MAX_VALUE;
        int minIndex = 0, lastMinIndex=0;
        int inf;
        for(int i=1;i<size;i++){
            ans[0][i] = Double.MAX_VALUE;
            ans[i][0] = Double.MAX_VALUE;
        }
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if(this.Graph.getEdge(rows[i-1].getKey(),cols[j].getKey())!=null && ans[i][j] < Double.MAX_VALUE ) {
                    ans[i][j] = Math.min(Graph.getEdge(rows[i - 1].getKey(), cols[j].getKey()).getWeight()+ans[i-1][lastMinIndex], ans[i - 1][j]);
                }else{
                    ans[i][j] = ans[i-1][j];
                }
            }
            for(int j=1; j<size;j++){
                if (ans[i][j] < min) {
                    min = ans[i][j];
                    rows[i] = cols[j];
                    minIndex = j;
                }
            }
            lastMinIndex = minIndex;
            inf = i+1;
            for(int l = inf; l<size;l++){
                ans[l][minIndex] = Double.MAX_VALUE;
            }
            min = Double.MAX_VALUE;
        }

        int colDest = 0, rowDest = 0;
        List<NodeData> result = new LinkedList<>();
        result.add(Graph.getNode(dest));
        for(int i=0;i< rows.length;i++){
            if(rows[i].getKey() == dest){
                rowDest = i;
            }
        }
        for(int i= 0; i< cols.length;i++){
            if(cols[i].getKey() == dest){
                colDest = i;
                break;
            }
        }
        int i = rowDest;
        int j = colDest;
        while(i>0){
            if(ans[i][j] == ans[i-1][j]){
                i--;
            }
            else{
                i--;
                min = Double.MAX_VALUE;
                for(int k=1;k<size;k++){
                    if(ans[i][k]<min && Graph.getEdge(cols[k].getKey(),result.get(0).getKey())!=null){
                        min = ans[i][k];
                        j=k;
                    }
                }
                result.add(0,rows[i]);
            }
        }
        return result;
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
        return getShortestPathTo(src,dest);
    }

    @Override
    public NodeData center() {
        if(!isConnected()){
            return null;
        }
        int size = this.Graph.getNodes().size();
        double min =  Double.MAX_VALUE;
        double [][] matrix = new double[size][size];
        double maxrow = 0,maxmin=Double.MAX_VALUE;
        NodeData ans =null;
        for (int i=0 ; i <size ;i++)
        {
            for(int j=0;j<size;j++) {
                if(i==j)
                    matrix[i][j]=Double.MAX_VALUE;
                else
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

    private void swap(int [] a , int i , int k )
    {
        int Temp = a[i];
        a[i] = a[k];
        a[k] = Temp;
    }
    //heap's algorithm
    private void Permutations(ArrayList<int[]> ans, int [] a, int k)
    {
        if(k==1)
            ans.add(a) ;
        else{
            k=k-1;
            Permutations(ans, a, k);

            for(int i=0 ; i< k;i++)
            {
                if(k%2==0)
                {
                    swap(a,i,k);
                }
                else
                {
                    swap(a,0,k);
                }
                Permutations(ans, a, k);
            }
        }
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        int size = cities.size();
        if(size < 40) {
            double[][] arr = new double[size][size];

            //save all shortest paths between every two nodes in a matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i == j)
                        arr[i][i] = Double.MAX_VALUE;
                    else {
                        arr[i][j] = shortestPathDist(cities.get(i).getKey(), cities.get(j).getKey());
                    }
                }
            }
            double shortest = Double.MAX_VALUE, curr = 0;
            int[] ans = new int[cities.size()];
            int[] Per = new int[cities.size()];
            ArrayList<int[]> permuted = new ArrayList<>();
            //init both arrays to be the indexes of the original list
            for (int i = 0; i < cities.size(); i++) {
                ans[i] = i;
                Per[i] = i;
            }
            //save all the permutaions of the array per into permuted list
            Permutations(permuted, Per, Per.length);
            //go over al the permuted arrays
            for (int i = 0; i < permuted.size(); i++) {
                Per = permuted.get(i);
                //compute the path dist between all of the nodes in the array
                for (int j = 0; j < cities.size() - 1; j++) {
                    curr += arr[Per[j]][Per[j + 1]];
                }
                //check if the current array generated the shortest path
                if (curr < shortest) {
                    shortest = curr;
                    ans = Per;
                }
            }
            List<NodeData> end = new ArrayList<>();
            //put all the elements from the ans array (and the nodes we need to go through between them) to the end list
            for (int i = 0; i < ans.length - 1; i++) {
                end.addAll(shortestPath(ans[i], ans[i + 1]));
            }
            return end;
        }
        List <NodeData> end = new ArrayList<>();
        double min = Double.MAX_VALUE;
        int minIndex = 0;
        NodeData lastNode = cities.remove(0), minNode = cities.get(0);
        end.add(lastNode);
        while(!cities.isEmpty()){
            for(int i = 0; i< cities.size();i++){
                NodeData curr = cities.get(i);
                double dist = shortestPathDist(lastNode.getKey(), curr.getKey());
                if(dist<min){
                    minNode = curr;
                    min = dist;
                    minIndex = i;
                }
            }
            lastNode = minNode;
            end.add(cities.remove(minIndex));
            min = Double.MAX_VALUE;
        }
        return end;
    }
    @Override
    public boolean load(String file) {
        try {
            this.Graph = new My_DirectedWeightedGraphImpl();
            Gson gson = new Gson();
            FileReader reader =new FileReader(file);
            JsonElement h = gson.fromJson(reader, JsonElement.class);
            JsonObject j = h.getAsJsonObject();
            JsonArray nodes = j.get("Nodes").getAsJsonArray();
            for(int i=0;i< nodes.size();i++){
                JsonObject nodeObj = nodes.get(i).getAsJsonObject();
                int key = nodeObj.get("id").getAsInt();
                String loc = nodeObj.get("pos").getAsString();
                String[] location = loc.split(",");
                GeoLocation g = new My_GeoLocation(Double.parseDouble(location[0]), Double.parseDouble(location[1]), Double.parseDouble(location[2]));
                Graph.addNode(new My_NodeData(key, g));
            }
            JsonArray edges = j.get("Edges").getAsJsonArray();
            for(int i=0;i< edges.size();i++){
                JsonObject edgeOb=edges.get(i).getAsJsonObject();
                int src = edgeOb.get("src").getAsInt();
                int dest = edgeOb.get("dest").getAsInt();
                double weight = edgeOb.get("w").getAsDouble();
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
