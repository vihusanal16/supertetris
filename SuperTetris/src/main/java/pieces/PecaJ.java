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

public class PecaJ extends Peca{

    static Block [][] matriz = {{new EmptyBlock(), new Block(Color.BLACK)},
                               { new EmptyBlock(), new Block(Color.BLACK)},
                               { new Block(Color.BLACK), new Block(Color.BLACK)}};      

    public PecaJ(){
        super(matriz);
    }
    
}
