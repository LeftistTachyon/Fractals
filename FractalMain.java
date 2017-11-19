package fractal;

import java.awt.Dimension;
import javax.swing.JFrame;

public class FractalMain extends JFrame{
    public static void main(String[] args) {
        new FractalMain();
        /*CurveA c = new CurveA(24, 24, 0, 0, 48, 0, CurveA.Direction.UP);
        System.out.println(c.p1.toString() + c.p2 + c.p3);*/
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
