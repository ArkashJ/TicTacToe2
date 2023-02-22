package Main.Games;
import Main.Players.*;

public interface ITurnGame {
    public Player getCurrentPlayer();
    public void nextMove();
}
