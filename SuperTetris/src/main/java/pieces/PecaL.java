package pieces;

import blocks.Block;
import blocks.EmptyBlock;
import java.awt.Color;

/**
 *************************
 *                       *
 * @author Vitor Alencar *
 *************************
 */

public class PecaL extends Peca {

    static Block [][] l = {{new Block(Color.ORANGE), new EmptyBlock()},
                          { new Block(Color.ORANGE), new EmptyBlock()}, 
                          { new Block(Color.ORANGE), new Block(Color.ORANGE)}};

    public PecaL() {
        super(l);       
    }

}
