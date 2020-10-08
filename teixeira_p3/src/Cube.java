public class Cube extends Shape3D {

    private final double edge;

    public Cube(double edge) {
        this.edge = edge;
    }

    @Override
    public String getName() {
        return "cube";
    }

    @Override
    public double getArea() {
        return 6 * (edge * edge);
    }

    @Override
    public double getVolume() {
        return (edge * edge * edge);
    }
}
