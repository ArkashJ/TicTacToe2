package Main.Games;

import Main.Board.Connect4Board;
import Main.Board.OrderAndChaosBoard;
import Main.Board.TicTacToeBoard;
import Main.Players.Player;

public class GamesDefiner {
    //Private GameDefiner constructor to prevent code errors (recommended by the IDE)
    private GamesDefiner() {}

    public static Game createGame(String gameType, Player player1, Player player2, int ROWS, int COLS, int winningCondition) {
        Game game = null;
        switch(gameType) {
            case "TicTacToe":
                game = new TicTacToeGame(player1, player2, new TicTacToeBoard(ROWS, COLS, winningCondition));
                break;
            case "OrderAndChaos":
                game = new OrderAndChaosGame(player1, player2, new OrderAndChaosBoard(ROWS, COLS, winningCondition));
                break;
            case "Connect4":
                game = new Connect4Game(player1, player2, new Connect4Board(ROWS, COLS, winningCondition));
                break;
            default:
                throw new IllegalArgumentException("Invalid game type: " + gameType);
        }
        return game;
    }

}
