package emulator;

import java.io.IOException;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

public class Main {
    public static void main(String[] args) {
        Chip8 chip8 = new Chip8();
        try {
            chip8.loadGame("c8games/INVADERS");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Display display = new Display(chip8.gfx);
        Display canvas = new Display(chip8.gfx);
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    //Display canvas = new Display(chip8.gfx);
                    canvas.setPreferredSize(new Dimension(384, 192));
                    canvas.setBackground(Color.black);
                    frame.setContentPane(canvas);
                    frame.pack();
                    frame.setTitle("Chip8");
                    frame.setResizable(false);
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    Keyboard keyboard = new Keyboard(canvas, chip8.key, chip8.isPressed, chip8.pressedKey);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Keyboard keyboard = new Keyboard(display.panel, chip8.key, chip8.isPressed, chip8.pressedKey);

        for (;;) {
            try {
                chip8.emulateCycle();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (chip8.drawFlag) {
                canvas.repaint();
                //System.out.println("yo");
                chip8.drawFlag = false;
            }
            //System.out.println(System.nanoTime() - begin);

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
