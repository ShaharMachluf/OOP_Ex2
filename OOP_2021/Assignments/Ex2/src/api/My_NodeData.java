package api;

public class My_NodeData implements NodeData {
    private int key, tag;
    private GeoLocation location;
    private double weight;
    private String info;

    public My_NodeData(int key, GeoLocation location, double weight, String info, int tag){
        this.key = key;
        this.location = new My_GeoLocation(location);
        this.weight = weight;
        this.info = info;
        this.tag = tag;
    }

    public My_NodeData(My_NodeData other){
        this.key = other.getKey();
        this.location = new My_GeoLocation(other.getLocation());
        this.weight = other.getWeight();
        this.info = other.getInfo();
        this.tag = other.getTag();
    }
    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public GeoLocation getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.location = new My_GeoLocation(p);
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight = w;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag = t;
    }
}