package fractal;

public class VerticalLine extends Line {

    public VerticalLine(Point p) {
        super(p, new Point(p.x, p.y+1));
    }

    public VerticalLine(double x, double y) {
        super(new Point(x, y), new Point(x, y+1));
    }

    @Override
    public Line rotate(double degrees) {
        return new Line(p, Math.tan(Math.toRadians(90 + degrees)));
    }

    @Override
    public double angledSlope() {
        return 90;
    }
}