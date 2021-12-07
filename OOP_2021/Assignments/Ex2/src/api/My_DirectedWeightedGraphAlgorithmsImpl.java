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
        public int check(double arr[][] ,int i ,int k, double x )
        {
            for(int j=0;j<this.Graph.nodeSize();j++){
                if(this.Graph.getEdge(j,k)==null)
                    continue;;
                if(this.Graph.getEdge(j,k).getWeight()+arr[i][j]==x)
                    return j;
            }
            return arr.length-1;
        }
        public  List<NodeData> getShortestPathTo(int src,int dest) {
        int size = this.Graph.nodeSize();
        double [] [] ans = new double[size][size];
        for(int i = 0 ; i < size ; i ++){
                for(int j=0 ; j < size ; j++){
                    if(i==0||i==j || this.getGraph().getEdge(i,j)==null)
                    ans[i][j]=Double.MAX_VALUE;
                    else
                    ans[i][j]=this.getGraph().getEdge(i,j).getWeight();
                }

        }
            for(int k = 0; k<size ; k++) {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if(ans[i][j]>ans[i][k]+ans[k][j])
                            ans[i][j]=ans[i][k]+ans[k][j];
                    }

                }
            }
            List <NodeData> result = new LinkedList<>();

            int temp = dest;
                    for(int i = size-1 ; i > 0 ; i--){
                        if(ans[i][temp]!=ans[i-1][temp])
                            temp = check(ans,i,temp,ans[i][temp]);
                            result.add(this.Graph.getNode(temp));
                        }
                    Collections.reverse(result);
           return result;

    }    @Override
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
        double [] [] arr = new double[size][size];

        //save all shortest paths between every two nodes in a matrix
        for(int i = 0 ; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j)
                    arr[i][i] = Double.MAX_VALUE;
                arr[i][j] = shortestPathDist(cities.get(i).getKey(), cities.get(j).getKey());
            }
        }
        double shortest= Double.MAX_VALUE, curr=0;
        int [] ans = new int[cities.size()];
        int [] Per = new int[cities.size()];
        ArrayList <int[]> permuted= new ArrayList<>();
        //init both arrays to be the indexes of the original list
        for(int i = 0 ;i < cities.size();i++ )
        {
            ans[i]=i;
            Per[i]=i;
        }
        //save all the permutaions of the array per into permuted list
        Permutations(permuted,Per,Per.length);
        //go over al the permuted arrays
        for(int i=0;i < permuted.size() ; i++)
        {
            Per=permuted.get(i);
            //compute the path dist between all of the nodes in the array
            for(int j= 0 ; j < cities.size()-1 ; j++){
                curr+=arr[Per[j]][Per[j+1]];
            }
            //check if the current array generated the shortest path
            if(curr<shortest){
                shortest=curr;
                ans=Per;
            }
        }
        List<NodeData> end = new ArrayList<>();
        //put all the elements from the ans array (and the nodes we need to go through between them) to the end list
        for (int i=0;i<ans.length-1;i++){
            end.addAll(shortestPath(ans[i],ans[i+1]));
        }
        return end;
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
