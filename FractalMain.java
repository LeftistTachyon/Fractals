package fractal;

import java.awt.Dimension;
import javax.swing.JFrame;

public class FractalMain extends JFrame{
    public static void main(String[] args) {
        new FractalMain();
        /*Curve c = new Curve(0, 0, 0, 0);
        Curve.Line line1 = c.new Line(0, 0, -1);
        System.out.println(line1.angledSlope());
        Curve.Line line2 = line1.rotate(-46);
        System.out.println(line2.slope);
        System.out.println(line2.angledSlope());*/
    }
    
    public FractalMain() {
        super("Dragon Curve");
        setSize(new Dimension(1500, 1000));
        super.getContentPane().add(new FractalPanel());
        super.setResizable(false);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
