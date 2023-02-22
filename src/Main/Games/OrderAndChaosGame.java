package Main.Games;
import java.util.*;
import Main.Board.IBoard;
import Main.Cell.Cell;
import Main.Players.Player;

public class OrderAndChaosGame extends TurnBasedBoardGame{
    public OrderAndChaosGame(Player player1, Player player2, IBoard board){
        super(player1, player2, board);
    }

    @Override
    public void end(){
        System.out.println("Ending the OrderAndChaos Game");
    }

    @Override
    public void start(){
        System.out.println("Starting the OrderAndChaos Game");
    }

    @Override
    public boolean playAgain(){
        System.out.println("Play Again? (Y/N): ");
        Scanner newScanner = new Scanner(System.in);
        String decision = newScanner.nextLine();
        if (!decision.toUpperCase().equals("Y"))
            return false;
        return true;
    }
    
    @Override
    public String play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting the Order and Chaos game!");
        String winner = "";
        board.printBoard();
    
        while (!board.isGameOver()) {
            Player currentPlayer = getCurrentPlayer();
            System.out.println("It's " + currentPlayer.getPlayerName() + "'s turn.");
            System.out.println("Enter row:");
            int row = Integer.parseInt(scanner.nextLine());

            if (row > board.rowLength()){
                System.out.println("Enter another row");
                row = Integer.parseInt(scanner.nextLine());
            }

            System.out.println("Enter column:");
            int col = Integer.parseInt(scanner.nextLine());

            if (col > board.colLength()){
                System.out.println("Enter another col");
                col = Integer.parseInt(scanner.nextLine());
            }

            System.out.println("Enter your cell value (X or O):");
            String cellValue = scanner.nextLine().toUpperCase();
            while (!cellValue.equals("X") && !cellValue.equals("O")) {
                System.out.println("Invalid cell value. Please enter X or O:");
                cellValue = scanner.nextLine().toUpperCase();
            }
            Cell playerCell = null;
            if (cellValue.equals("X")){
                playerCell = Cell.X;
            }   else{
                playerCell = Cell.O;
            }
                
            if (!board.placePlayer(row, col, playerCell)) {
                System.out.println("Invalid move. Please enter a valid row and column combination:");
                continue;
            }
    
            board.printBoard();
    
            if (board.isGameOver()) {
                winner = currentPlayer.getPlayerName();
                System.out.println(winner + " wins!");
                break;
            }
    
            nextMove();
        }
        end();
        return winner;
    }
}