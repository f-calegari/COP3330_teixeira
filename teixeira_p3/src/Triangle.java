public class Triangle extends Shape2D {

    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    public String getName() {
        return "triangle";
    }

    @Override
    public double getArea() {
        return (base * height) / 2;
    }
}
