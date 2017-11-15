package fractal;

public class Point {

    public final double x, y;

    public Point(double x, double y)  {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public int roundedX() {
        return (int) Math.round(x);
    }

    public int roundedY() {
        return (int) Math.round(y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}