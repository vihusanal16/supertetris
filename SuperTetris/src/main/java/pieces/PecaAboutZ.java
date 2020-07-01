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

public class PecaAboutZ extends Peca{

    static Block [][] AZ = {{new Block(Color.GREEN), new Block(Color.GREEN), new Block(transparent)}, {new Block(transparent), new Block(Color.GREEN), new Block(Color.GREEN)}};
    
    public PecaAboutZ(){
        super(AZ);
    }
    
}
