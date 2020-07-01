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

public class PecaZ extends Peca{

    static Block [][] z = {{new Block(Color.GREEN), new Block(Color.GREEN), new EmptyBlock()}, 
                          { new EmptyBlock(), new Block(Color.GREEN), new Block(Color.GREEN)}};
    
    public PecaZ(){
        super(z);
    }
    
}
