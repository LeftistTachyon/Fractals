package fractal;

public class Line {
    public final Point p;
    public final double slope;

    public Line(double x, double y, double slope) {
        p = new Point(x, y);
        this.slope = slope;
    }

    public Line(Point p, double slope) {
        this.p = new Point(p);
        this.slope = slope;
    }

    public Line(Point p1, Point p2) {
        p = new Point(p1);
        slope = (p2.x-p1.x)/(p2.y-p1.y);
    }

    public Line(Line l) {
        p = new Point(l.p);
        slope = l.slope;
    }

    protected Line(double x, double y) {
        p = new Point(x, y);
        slope = new Double(null);
    }

    public double angledSlope() {
        return Math.toDegrees(Math.atan2(slope, 1));
    }

    public Line setSlope(double slope) {
        return new Line(p, slope);
    }

    public Line rotate(double degrees) {
        double d = angledSlope() + degrees;
        if(d == 90) {
            return new VerticalLine(p);
        } else {
            return new Line(p, Math.tan(Math.toRadians(d)));
        }
    }

    @Override
    public String toString() {
        return "Point: " + p.toString() + ", Slope: " + slope;
    }
}