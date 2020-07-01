package block;

import blocks.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *************************
 *                       *
 * @author Vitor Alencar *
 *************************
 */

public class Block extends JComponent {

    private Color myColor;

    public Block(Color color) {
        this.myColor = color;
    }
    
    public Block(){
        
    }

    public void draw(Graphics g, int x, int y, int dx, int dy) {
        if (!myColor.equals(new Color(0f, 0f, 0f, 0f))) {
            g.setColor(myColor);
            g.fillRect(x, y, dx, dy);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, dx, dy);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        int w = this.getWidth();
        int h = this.getHeight();
        draw(g, 1, 1, w - 1, h - 2);
    }

}
