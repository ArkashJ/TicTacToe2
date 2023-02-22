package Main.Games;
import Main.Board.IBoard;
import Main.Players.Player;

public abstract class GameAbstract extends Game implements ITurnGame {
    protected Player player1;
    protected Player player2;
    protected IBoard board;
    protected boolean isPlayer1Turn;

    public GameAbstract(Player player1, Player player2, IBoard board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.isPlayer1Turn = true;
    }

    @Override
    public Player getCurrentPlayer() {
        return isPlayer1Turn ? player1 : player2;
    }

    @Override
    public void nextMove() {
        isPlayer1Turn = !isPlayer1Turn;
    }

}