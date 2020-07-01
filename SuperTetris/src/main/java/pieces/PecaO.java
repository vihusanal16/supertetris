package pieces;

import blocks.Block;
import java.awt.Color;

/**
 *************************
 *                       *
 * @author Vitor Alencar *
 *                       *
 *************************
 */

public class PecaO extends Peca{

    static Block [][] o = {{new Block(Color.YELLOW), new Block(Color.YELLOW)},
                          { new Block(Color.YELLOW), new Block(Color.YELLOW)}};
    
    public PecaO(){
        super(o);
    }
    
}
