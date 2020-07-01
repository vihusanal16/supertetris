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


//OBS: As classes denominadas por "PecaAbout" foram criadas unicamente para serem utilizadas pela classe "Sobre" do pacote "apps"

public class PecaAboutS extends Peca{

    static Block [][] AS = {{new Block(transparent), new Block(Color.RED), new Block(Color.RED)}, {new Block(Color.RED), new Block(Color.RED), new Block(transparent)}};
    
    public PecaAboutS(){
        super(AS);
    }
    
}
