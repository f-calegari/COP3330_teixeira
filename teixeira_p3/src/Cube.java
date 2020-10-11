public class Cube extends Shape3D {

    private final double edge;

    public Cube(double edge) {
        super();
        this.edge = edge;
    }

    @Override
    public String getName() {
        return "cube";
    }

    @Override
    public double getArea() {
        return 6 * (this.edge * this.edge);
    }

    @Override
    public double getVolume() {
        return (this.edge * this.edge * this.edge);
    }
}