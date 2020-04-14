import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPaneDemo extends JFrame {

    private static final int SIZE = 500;
    JPaneDemo() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(SIZE,SIZE);
        getContentPane().add(new WhitePanel());


    }


    public static void main(String[] args) {
        new JPaneDemo().setVisible(true);

    }

    public Image createNewImage ()
    {
        BufferedImage retval = new BufferedImage(SIZE,SIZE,BufferedImage.TYPE_INT_RGB);
        int index = 0;
           for (int y = 0; y < SIZE; y++)
           {
               int red = (y * 255) / (SIZE - 1);
               for (int x = 0; x < SIZE; x++)
               {
                   int blue = (x * 255) / (SIZE - 1);
                   retval.setRGB(x, y, (255 << 24) | (red << 16) | blue)  ;
               }
           }

        return retval;
    }

    class WhitePanel extends JPanel
    {
        private Image theImage;
        public WhitePanel()
        {

            theImage= createNewImage ();

            // Dieser Teil ist nicht noetig. Er schreibt nur den Text ins Bild....
            Graphics g = theImage.getGraphics();
            g.drawString("So gehts!", 50, 50);


        }

        public void paint(Graphics g) {
            g.drawImage(theImage, 0,0,SIZE,SIZE, this);
        }
    }

}