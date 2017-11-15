package fractal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class ICurve {
    
    protected Point p1, p2, p3;
    
    public ICurve(Point p1, Point p2, Point p3) {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
        this.p3 = new Point(p3);
    }
    
    public ICurve(double x1, double y1, double x2, double y2, double x3, double y3) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
        p3 = new Point(x3, y3);
    }
    
    protected abstract void sortPoints();
    
    public abstract ArrayList<ICurve> replicate();
    
    public void draw(Graphics window) {
        window.setColor(Color.RED);
        window.drawLine(p1.roundedX(), p1.roundedY(), p2.roundedX(), p2.roundedY());
        window.drawLine(p2.roundedX(), p2.roundedY(), p3.roundedX(), p3.roundedY());
    }
}