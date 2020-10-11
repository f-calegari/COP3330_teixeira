public class Triangle extends Shape2D {

    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        super();
        this.base = base;
        this.height = height;
    }
    @Override
    public String getName() {
        return "triangle";
    }

    @Override
    public double getArea() {
        return (this.base * this.height) / 2;
    }
}