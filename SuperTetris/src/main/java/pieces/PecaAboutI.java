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

public class PecaAboutI extends Peca{

    static Block [][] AI = {{new Block(Color.BLUE), new Block(transparent)}, {new Block(Color.BLUE), new Block(transparent)}, {new Block(Color.BLUE), new Block(transparent)}, {new Block(Color.BLUE), new Block(transparent)}};
   
    public PecaAboutI (){
        super(AI);
    }

    
}
