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

public class PecaI extends Peca{

    static Block [][] I = {{new Block(Color.BLUE)},
                          { new Block(Color.BLUE)},
                          { new Block(Color.BLUE)},
                          { new Block(Color.BLUE)}};
    
    public PecaI (){
        super(I);
    }

    
}
