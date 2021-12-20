package emulator;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Display extends JPanel {
    int[][] gfx;
    //JPanel panel;

    public Display(int[][] gfx) {
        this.gfx = gfx;
    }

    /*
    public void initialize() {
        JFrame frame = new JFrame();
        Canvas canvas = new Display(gfx);
        canvas.setSize(384,192);
        canvas.setBackground(Color.black);
        this.panel = new JPanel();
        this.panel.add(canvas);
        frame.setContentPane(this.panel);
        frame.pack();
        frame.setTitle("Chip8");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

     */

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform oldTransform = g2.getTransform();
        g2.scale(6,6);
        g2.setColor(Color.white);
        for (int i = 0; i < gfx.length; i++) {
            for (int k = 0; k < gfx[0].length; k++) {
                if (gfx[i][k] == 1) g2.fillRect(i, k, 1, 1);
                //System.out.println("YEP");
            }
        }
        //System.out.println("hello");
        g2.setTransform(oldTransform);

    }


}
