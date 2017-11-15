package fractal;

import java.util.ArrayList;
import java.util.Collections;

public class CurveA extends ICurve {

    public CurveA(Point p1, Point p2, Point p3) {
        super(p1, p2, p3);
        sortPoints();
    }
    
    public CurveA(double x1, double y1, double x2, double y2, double x3, double y3) {
        super(x1, y1, x2, y2, x3, y3);
        sortPoints();
    }
    
    @Override
    protected void sortPoints() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        Collections.sort(points, (Point p4, Point p5) -> p4.roundedX() - p5.roundedX());
        p1 = new Point(points.get(0));
        p2 = new Point(points.get(1));
        p3 = new Point(points.get(2));
    }
    
    /*
     *          _
     *   /\ -> | |_
     */
    @Override
    public ArrayList<ICurve> replicate() {
        ArrayList<ICurve> output = new ArrayList<>();
        output.add(new CurveB(p1, new Point(p1.x, p2.y), p2));
        output.add(new CurveB(p2, new Point(p2.x, p3.y), p3));
        return output;
    }
}