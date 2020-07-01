package listeners;

import apps.TetrisBoard;
import java.util.EventListener;

/**
 *************************
 *                       *
 * @author Vitor Alencar *
 *                       *
 *************************
 */

public interface TetrisListeners extends EventListener{

    public void onNewPiece(TetrisBoard board);
    
}
