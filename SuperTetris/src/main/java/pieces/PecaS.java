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

public class PecaS extends Peca{

    static Block [][] s = {{new EmptyBlock(), new Block(Color.RED), new Block(Color.RED)},
                          { new Block(Color.RED), new Block(Color.RED), new EmptyBlock()}};
    
    public PecaS(){
        super(s);
    }
    
}
