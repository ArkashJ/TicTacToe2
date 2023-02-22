package Main.Games;
import java.util.*;
import Main.Board.IBoard;
import Main.Players.Player;

public class Connect4Game extends GameAbstract{
    public Connect4Game(Player player1, Player player2, IBoard board){
        super(player1, player2, board);
    }

    @Override
    public void end(){
        System.out.println("Ending the Connect4 Game");
    }

    @Override
    public void start(){
        System.out.println("Starting the Connect4 Game");
    }

    @Override
    public boolean playAgain() {
        System.out.println("Play Again? (True/False): ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.nextLine();
        String decision = scanner.nextLine();
        System.out.println(decision);
        scanner.close();
        if (!decision.toUpperCase().equals("Y"))
            return false;
        return true;
    }

    @Override
    public String play(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Starting the Connect4 game!");
        String winner = "";
        board.printBoard();

        while (!board.isGameOver()) {
            Player currentPlayer = getCurrentPlayer();
            System.out.println("It's " + currentPlayer.getPlayerName() + "'s turn.");
            System.out.println("Enter column : ");
            int col = Integer.parseInt(scanner.nextLine());
            
            if (col > board.rowLength()){
                col = Integer.parseInt(scanner.nextLine());
            }

            int row = board.getLowestEmptyCell(col);
            if (row == -1) {
                System.out.println("Column is full. Enter another column.");
                continue;
            }
    
            board.placePlayer(row, col, currentPlayer.getPlayerCell());
    
            board.printBoard();
            if (board.isGameOver()){
                winner = currentPlayer.getPlayerName();
                System.out.println(winner + " wins!");
                break;
            }
    
            nextMove();
        }
        scanner.close();
        return winner;
    }
    
}

