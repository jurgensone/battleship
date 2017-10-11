package lv.ctco.battleship.model;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class GameManager implements Serializable {
    private static final Logger logger = Logger.getLogger(GameManager.class.getName());
    private static final long serialVersionUID = 1;

    private Game incompleteGame;

    public synchronized Game registerPlayer(Player player) {
        if (incompleteGame == null) {
            incompleteGame = new Game();
            logger.log(Level.FINE, "No incomplete games found, creating for user {0}", player);
            incompleteGame.setPlayer1(player);
            return incompleteGame;
        } else {
            incompleteGame.setPlayer2(player);
            Game completeGame = incompleteGame;
            incompleteGame = null;
            logger.log(Level.FINE, "Completeng game {0}", completeGame);
            return completeGame;
        }
    }
}
