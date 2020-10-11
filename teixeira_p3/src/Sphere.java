public class Sphere extends Shape3D {

    private final double radius;

    public Sphere(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "sphere";
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * (this.radius * this.radius);
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(this.radius, 3);
    }
}