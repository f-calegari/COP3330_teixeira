public class Square extends Shape2D {

    private final double side;

    public Square(double side) {
        super();
        this.side = side;
    }

    @Override
    public String getName() {
        return "square";
    }

    @Override
    public double getArea() {
        return this.side * this.side;
    }
}