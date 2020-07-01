/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

public class BlockBorder extends Block{
    
    public BlockBorder() {
        this(Color.GRAY);
    }
    
    public BlockBorder(Color c) {
        super(c);
    }

    @Override
    public void draw(Graphics g, int x, int y, int dx, int dy) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, dx, dy);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, dx, dy);      
    }
    
}
