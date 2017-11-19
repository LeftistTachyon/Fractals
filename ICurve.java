package fractal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class ICurve {
    
    protected Point p1, p2, p3;
    private final Point[] points;
    private boolean initialized = false;
    
    public ICurve(Point p1, Point p2, Point p3) {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
        this.p3 = new Point(p3);
        points = new Point[]{p1, p2, p3};
        order();
    }
    
    public ICurve(double x1, double y1, double x2, double y2, double x3, double y3) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
        p3 = new Point(x3, y3);
        points = new Point[]{p1, p2, p3};
        order();
    }
    
    private void order() {
        initialized = true;
    }
    
    protected abstract void sortPoints();
    
    public abstract ArrayList<ICurve> replicate();
    
    protected Point findOrder(int order) {
        return points[order];
    }
    
    public void draw(Graphics window) {
        if (initialized) {
            Point order0 = findOrder(0),
                    order1 = findOrder(1),
                    order2 = findOrder(2);
            window.setColor(Color.RED);
            window.drawLine(order0.roundedX(), order0.roundedY(), order1.roundedX(), order1.roundedY());
            window.drawLine(order1.roundedX(), order1.roundedY(), order2.roundedX(), order2.roundedY());
        }
    }
}