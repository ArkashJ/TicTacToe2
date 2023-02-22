package Main.Games;

import java.util.Scanner;

import Main.Board.IBoard;
import Main.Players.Player;

public class TicTacToeGame extends GameAbstract{
    public TicTacToeGame(Player player1, Player player2, IBoard board){
        super(player1, player2, board);
    }

    @Override
    public void end(){
        System.out.println("Ending the TicTacToe Game");
    }

    @Override
    public void start(){
        System.out.println("Starting the TicTacToe Game");
    }

    @Override
    public boolean playAgain(){
        System.out.println("Play Again? (Y/N): ");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();
        if (!decision.toUpperCase().equals("Y"))
            return false;
        return true;
    }
    
    @Override
    public String play(){
        Scanner scanner = new Scanner(System.in);
        start();
        String winner = "";
        boolean placedSuccess = true;

        board.printBoard();

        
        while (!board.isGameOver()) {
            Player currentPlayer = getCurrentPlayer();
            System.out.println("It's " + currentPlayer.getPlayerName() + "'s turn.");
            System.out.println("Enter row : ");
            int row = Integer.parseInt(scanner.nextLine());

            if (row > board.rowLength()){
                row = Integer.parseInt(scanner.nextLine());
            }

            System.out.println("Enter column : ");
            int col = Integer.parseInt(scanner.nextLine());
            
            if (col > board.colLength()){
                col = Integer.parseInt(scanner.nextLine());
            }

            if (!board.placePlayer(row, col, currentPlayer.getPlayerCell())){
                System.out.println("Enter another combination");
                System.out.println("Enter row : ");
                row = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter column : ");
                col = Integer.parseInt(scanner.nextLine());
                board.placePlayer(row, col, currentPlayer.getPlayerCell());
            }
            
            board.printBoard();
            
            if (board.isGameOver()){
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