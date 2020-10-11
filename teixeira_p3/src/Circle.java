public class Circle extends Shape2D {

    private final double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "circle";
    }

    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}