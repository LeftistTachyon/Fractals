package fractal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Curve {
    Graphics window;
    Point one, two, middle;
    
    public Curve(Point one, Point two) {
        this.one = new Point(one);
        this.two = new Point(two);
        swapIfNeeded();
        this.middle = findMiddle();
    }
    
    public Curve(int x1, int y1, int x2, int y2) {
        one = new Point(x1, y1);
        two = new Point(x2, y2);
        swapIfNeeded();
        middle = findMiddle();
    }
    
    private void swapIfNeeded() {
        if(one.x >= two.x) {
            Point temp = new Point(two);
            two = new Point(one);
            one = new Point(temp);
        }
    }
    
    private Point findMiddle() {
        Line between = new Line(one, two);
        Line lOne = between.rotate(-45);
        Line lTwo = between.rotate(45);
        System.out.println(findIntersection(lTwo, lTwo));
        return findIntersection(lOne, lTwo);
    }
    
    private Point findIntersection(Line a, Line b) {
        double x, y;
        if(a instanceof VerticalLine) {
            x = a.p.x;
            y = (b.slope*(x - b.p.x)) + b.p.y;
        } else if(b instanceof VerticalLine) {
            x = b.p.x;
            y = (a.slope*(x - a.p.x)) + a.p.y;
        } else {
            x = ((b.slope*b.p.x*-1) + b.p.y + (a.slope*a.p.x) - a.p.y)/(a.slope-b.slope);
            y = (a.slope*x)-(a.p.x)+a.slope;
        }
        return new Point(x, y);
    }
    
    public ArrayList<Curve> replicate() {
        ArrayList<Curve> output = new ArrayList<>();
        output.add(new Curve(one, middle));
        output.add(new Curve(middle, two));
        return output;
    }
    
    public void draw(Graphics window) {
        window.setColor(Color.RED);
        window.drawLine(one.roundedX(), one.roundedY(), middle.roundedX(), middle.roundedY());
        window.drawLine(middle.roundedX(), middle.roundedY(), two.roundedX(), two.roundedY());
    }
}