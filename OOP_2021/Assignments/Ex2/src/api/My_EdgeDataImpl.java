package Ex2.src;


public class My_EdgeDataImpl implements api.EdgeData {


    private int Src;
    private int Dest;
    private double Weight;
    private String Info;
    private int tag;

    public My_EdgeDataImpl(int Srcc , int Destt , double Weightt ,String Infoo , int tagg) {
        this.Src=Srcc;
        this.Dest=Destt;
        this.tag=tagg;
        this.Weight=Weightt;
        this.Info=Infoo;
    }

    public void My_EdgeDataImpl(api.EdgeData a){
       this.Src=a.getSrc();
       this.Dest=a.getDest();
       this.Info=a.getInfo();
       this.tag=a.getTag();
       this.Weight=a.getWeight();
    }


    public int getSrc() {
        return this.Src;
    }

    @Override
    public int getDest() {
        return this.Dest;
    }

    @Override
    public double getWeight() {
        return this.Weight;
    }

    @Override
    public String getInfo() {
        return this.Info;
    }

    @Override
    public void setInfo(String s) {
    this.Info=s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
    this.tag=t;
    }
}
