package fractal;

import java.util.ArrayList;
import java.util.Collections;

public class CurveB extends ICurve {
    
    public final Direction d;
    
    public CurveB(Point p1, Point p2, Point p3, CurveB.Direction ad) {
        super(p1, p2, p3);
        d = ad;
        sortPoints();
    }
    
    public CurveB(double x1, double y1, double x2, double y2, double x3, double y3, CurveB.Direction ad) {
        super(x1, y1, x2, y2, x3, y3);
        d = ad;
        sortPoints();
    }
    
    @Override
    protected void sortPoints() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        Collections.sort(points, (Point p4, Point p5) -> (p4.roundedY() - p5.roundedY() == 0)?p4.roundedX() - p5.roundedX():p4.roundedY() - p5.roundedY());
        p1 = new Point(points.get(0));
        p2 = new Point(points.get(1));
        p3 = new Point(points.get(2));
        System.out.println(p1.toString()+p2+p3);
    }
    
    /*
     *  _    /\/
     * |  -> \
     */
    
    @Override
    public ArrayList<ICurve> replicate() {
        ArrayList<ICurve> output = new ArrayList<>();
        switch(d) {
            case NE:
                output.add(new CurveA(p1, new Point((p1.x+p2.x)/2, p1.y-((p2.x-p1.x)/2)), p2, CurveA.Direction.UP));
                output.add(new CurveA(p2, new Point((p1.x+p2.x)/2, (p2.y+p3.y)/2), p3, CurveA.Direction.LEFT));
                break;
            case NW:
                output.add(new CurveA(p3, new Point(p1.x-((p2.x-p1.x)/2), (p1.y+p3.y)/2), p1, CurveA.Direction.LEFT));
                output.add(new CurveA(p1, new Point((p1.x+p2.x)/2, (p1.y+p3.y)/2), p2, CurveA.Direction.DOWN));
                break;
            case SE:
                //Check!
                output.add(new CurveA(p1, new Point(((p1.x-p2.x)/2)+p1.x, (p1.y+p3.y)/2), p3, CurveA.Direction.RIGHT));
                output.add(new CurveA(p3, new Point((p2.x+p3.x)/2, (p1.x+p2.x)/2), p2, CurveA.Direction.UP));
                break;
            case SW:
                output.add(new CurveA(p1, new Point((p2.x+p3.x)/2,(p1.y+p2.y)/2), p2, CurveA.Direction.RIGHT));
                output.add(new CurveA(p2, new Point((p2.x+p3.x)/2, p2.y+((p3.x-p2.x)/2)), p3, CurveA.Direction.DOWN));
                break;
            default:
                assert false : "There are no other cases";
        }
        return output;
    }
    
    enum Direction {
        NE(), SE(), SW(), NW();
    }
    
}