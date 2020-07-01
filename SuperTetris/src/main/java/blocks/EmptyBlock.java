package blocks;

import java.awt.Color;
import java.awt.Graphics;

/**
 *************************
 *                       *
 * @author Vitor Alencar *
 *                       *
 *************************
 */
 
public class EmptyBlock extends Block {
    
    @Override
    public void draw(Graphics g, int x, int y, int dx, int dy) {
        g.setColor(Color.BLACK);
        g.drawRect(x, y, dx, dy);      
    }

}
