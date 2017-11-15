package fractal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class FractalPanel extends JPanel implements Runnable{
    
    private ArrayList<ICurve> curves;
    private int count = 0;
    
    public FractalPanel() {
        curves = new ArrayList<>();
        curves.add(new CurveA(238, 650, 750, 138, 1262, 650));
        super.setVisible(true);
        new Thread(this).start();
    }
    
    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        count++;
        drawBackground(g);
        for(ICurve c:curves) {
            c.draw(g);
        }
        if(count > 20) {
            count = 0;
            ArrayList<ICurve> temp = new ArrayList<>(curves);
            for(ICurve ic:temp) {
                curves.remove(ic);
                curves.addAll(ic.replicate());
            }
        }
    }
    
    private void drawBackground(Graphics window) {
        window.setColor(Color.BLACK);
        window.fillRect(0, 0, getWidth(), getHeight());
    }
    
    @Override
    public void run() {
        try {
            while(true) {
                Thread.currentThread().sleep(100);
                repaint();
            }
        } catch(InterruptedException ie) {}
    }
}