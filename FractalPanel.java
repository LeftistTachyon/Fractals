package fractal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class FractalPanel extends JPanel implements Runnable{
    
    private ArrayList<Curve> curves;
    
    public FractalPanel() {
        curves = new ArrayList<>();
        curves.add(new Curve(236, 640, 1264, 660));
        super.setVisible(true);
        new Thread(this).start();
    }
    
    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        drawBackground(g);
        for(Curve c:curves) {
            c.draw(g);
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