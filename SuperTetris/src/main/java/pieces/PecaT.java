package pieces;

import blocks.Block;
import blocks.EmptyBlock;
import java.awt.Color;

/**
 *************************
 *                       *
 * @author Vitor Alencar *
 *                       *
 *************************
 */

public class PecaT extends Peca{

    static Block [][] T = {{new Block(Color.MAGENTA), new Block(Color.MAGENTA), new Block(Color.MAGENTA)},
                          { new EmptyBlock(), new Block(Color.MAGENTA), new EmptyBlock()}};
    
    public PecaT(){
        super(T);
    }
    
}
