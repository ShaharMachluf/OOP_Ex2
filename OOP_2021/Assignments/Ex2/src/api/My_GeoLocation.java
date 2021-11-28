package api;

public class My_GeoLocation implements GeoLocation{
    private double x, y, z;
    public My_GeoLocation(double x1, double y1, double z1){
        this.x = x1;
        this.y = y1;
        this.z = z1;
    }

    public  My_GeoLocation(GeoLocation other){
        this.x = other.x();
        this.y = other.y();
        this.z = other.z();
    }
    @Override
    public double x() {
        return this.x;
    }

    @Override
    public double y() {
        return this.y;
    }

    @Override
    public double z() {
        return this.z;
    }

    @Override
    public double distance(GeoLocation g) {
        double d = Math.sqrt(Math.pow(this.x - g.x(), 2) + Math.pow(this.y - g.y(),2) + Math.pow(this.z - g.z(),2));
        return d;
    }
}

