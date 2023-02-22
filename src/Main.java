import Main.Cell.*;
import Main.Games.*;
import Main.Players.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Variable to ask the user if they want to play again or not, scanner class and an instance of the win hashmap
        boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);
        Win wins = new Win();

        System.out.println("Welcome to the Game Board! You can play TicTacToe with a board size of your choice, Order and Chaos and Connect4");
        //---------------------------------------------------------------------------------------------------------------
        //Play till you stop
        while(playAgain){
            //---------------------------------------------------------------------------------------------------------------
            //set the choice of the player1 to null
            Cell p1Cell = null; 
            Cell p2Cell = null;
            //---------------------------------------------------------------------------------------------------------------
            //Ask the user what game they want to play and call the game designer class to start working

            System.out.println("Which game would you like to play? Here's your options: ");
            System.out.println("A) TicTacToe B) OrderAndChaos C) Connect4");
            System.out.println("Choose the one you want to play by typing in the game name, the case doesn't matter");
            String gameChoice = scanner.nextLine();

            System.out.println("Enter your name Player1");
            String name1 = scanner.nextLine();
            System.out.println("Player1, choose your cell element - X or O (you can use the same for all 3 games)");
            // loop until the user selects the current choice
            while (p1Cell == null){
                System.out.println("Enter your choice");
                String p1CellVal = scanner.nextLine();

                if(p1CellVal.equalsIgnoreCase("X")){
                    p1Cell = Cell.X; //Set the value of p1's value to X
                }  else if (p1CellVal.equalsIgnoreCase("O")){
                    p1Cell = Cell.O;
                }   else{
                    System.out.println("Invalid value, choose again");
                }
            }
            //set player1 by calling the player class from Main/Player
            Player player1 = new Player(name1, p1Cell);
            //Set the variable for player2 and ask them for their name
            System.out.println("Player2 - Enter your name");
            String name2 = scanner.nextLine();

            if (p1Cell == Cell.X)
                p2Cell = Cell.O;
            else 
                p2Cell = Cell.X;
            //setting the second player 
            Player player2 = new Player(name2, p2Cell);
            //---------------------------------------------------------------------------------------------------------------
            Game game = null;
            int winningCondition;
            switch(gameChoice.toLowerCase()){
                //First case
                case "tictactoe":
                    
                    System.out.println("Enter the dimensions of the board. (Rows have to be equal to columns)");
                    int rows = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter the winning condition (which should be less than the rows). ");
                    System.out.println("This is the number of rows you need to have so that a player with a choice of a certain celltype wins");
                    winningCondition = Integer.parseInt(scanner.nextLine());

                    if (winningCondition > rows){
                        System.out.println("Wrong choice!");
                        break;
                    }

                    game = GamesDefiner.createGame("TicTacToe", player1, player2, rows, rows, winningCondition);
                    break;
                //second case
                case "orderandchaos":
                    System.out.println("This is the number of rows you need to have so that a player with a choice of a certain celltype wins");
                    winningCondition = Integer.parseInt(scanner.nextLine());

                    if (winningCondition > 6){
                        System.out.println("Wrong choice!");
                        break;
                    }

                    game = GamesDefiner.createGame("OrderAndChaos", player1, player2, 6, 6,  winningCondition);
                    break;
                //third case
                case "connect4":
                    System.out.println("This is the number of rows you need to have so that a player with a choice of a certain celltype wins");
                    winningCondition = Integer.parseInt(scanner.nextLine());

                    if (winningCondition > 7){
                        System.out.println("Wrong choice!");
                        break;
                    }

                    game = GamesDefiner.createGame("Connect4", player1, player2, 6, 7,  winningCondition);
                    break;
                //default
                default:
                    System.out.println("Choose one the games above");
            }
            //---------------------------------------------------------------------------------------------------------------

            if(game != null){
                String winner = game.play();
                wins.addWin(winner);
                System.out.println(winner);
                System.out.println("Heres the score tally: ");
                wins.printHashMap();
                scanner.close();
                
                playAgain = game.playAgain();
            }
        } 
    }
}