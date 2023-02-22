# CS611-Assignment 2
## TicTacToe Part2
---------------------------------------------------------------------------
Arkash Jain
arkjain@bu.edu
U5874827

## Files
---------------------------------------------------------------------------
This program implements the SOLID principles and follows a completely abstracted/inheritance model. Every file does ONE thing and we can easily add more games here and they can easily be played.

The following packages or folders have been made:

1) Board: Makes the board and the features it will have for any general game

|> IBoard - Interface used all boards which contains the following functions
    public void     printBoard();    --> print the board
    public boolean  isGameOver();    --> Checks if the game is over or not if the board is full or one person wins
    public boolean  isFull();        --> Checks if no more moves can be made or not
    public boolean  placePlayer(int row, int col, Cell cell);   --> Places a player in the board. 
    public boolean  checkWin();     --> Checks who won
    public Cell     getWinner();    --> Gets the winner
    public int      getLowestEmptyCell(int col);    --> For connect4, returns the lowest row that is empty
    public int      rowLength();    --> Return Rows
    public int      colLength();    --> Return Cols

|> GameBoard - Abstract class that implements IBoard. It initializes all the methods from IBoard. Some of these functions can be used for every game like printBoard, isFull, placePlayer, isGameOver, rowLength and colLength. Furthermore, it makes a constructor to initialize the board.

All the following classes extend GameBoard
    |> Connect4Board        --> Specific board for connect4 to check the wins
    |> TicTacToeBoard       --> Specific board for tictactoe
    |> OrderAndChaosBoard   --> Specific board for orderandchaos

2) Cell: Makes a cell that is the basic element of each board and initializes its attributes.

|> ICell - Interface that returns the current value held in the cell.

|> Cell - An enum that implements the ICell
    public String getSymbol() - returns the symbol (X, O or Blank) for the current cell
    Initializes the Cell constructor
    and makes enum children as X, O, Blank

3) Players: Defines the attributes for the players who will play this game
|> IPlayer - interface to get the players name and cell
    public String getPlayerName() - get the player name
    public Cell getPlayerCell()   - get the player's cell choice (X or O)
Player implements the IPlayer
|> Player  - A player class that initializes the above functions and makes the player constructor

4) Games
|> ITurnGame  - interface to get the current player and their next move
    public Player getCurrentPlayer() - get the player
    public void nextMove();          - get the nextmove
|> Game - Abstract class to start a game, play it, end it or play it again
    public abstract void start();
    public abstract void end();
    public abstract String play();
    public abstract boolean playAgain();
|> TurnBasedBoardGame - extends Game and implements ITurnGame: Initialize the constructors and interface methods

    This class is extended by
    |> OrderAndChaosGame - Conditions to play the order and chaos game
    |> TicTacToeGame     - Conditions to play the tictactoe game
    |> Connect4Game      - Conditions to play the connect4 game 

|> GameDefiner - Based on the user's input, we make one of the 3 games by passing in the rows, columns, (player1, player2, board) (in a board class).

5) Win.java  - Makes a hashmap to add players and store their wins, and print the result

6) Main.java - Main class to start the game, prompt the user for input, and return the results

As seen above, the user could add the game of checkers or chess here for example. They would have to only make a checkers and chess board to check how a user would win, make a game class to define how the user can play the game, add it to GameDefiner and add the case in the main method to play this game. 

## Notes
---------------------------------------------------------------------------
1. Files to be parse should be stored in 4 packages, following the sturcture above. 
The Main class and Win class are global wheres others are corresponding to the Board, Cell, Games and Player Packages.
2. Please run the Main.java class to run this code. For readability I have added lines in the main function to divide into sections.
3. Notes to grader:

- You can start by looking at the main class to understand the code structure. After the first few prompts, the case variables introduce the prompts to the user for each specific game.
- From there the GameDefine class can be found (/src -> Main -> Games -> GameDefiner). This class makes a game variable. You can go to one of the three game classes (/src -> Main -> Games -> OrderAndChaosGame).
Furthermore, the abstract GameAbstract class, ITurnGame and Game classes are abstractions used by any games defined here
- After that, you can go to the Board (/src -> Main -> Board -> GameBoard). Specific boards for each game are here as well.
- From there you can look at the cell enum and the player class

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "src"
2. Run the following commands on a mac
javac Main.java
java Main.java 

## Input/Output Example
---------------------------------------------------------------------------
Welcome to the Game Board! You can play TicTacToe with a board size of your choice, Order and Chaos and Connect4
Which game would you like to play? Here's your options: 
A) TicTacToe B) OrderAndChaos C) Connect4
Choose the one you want to play by typing in the game name, the case doesn't matter
orderandChAos
Enter your name Player1: 
Arkash
Player2 - Enter your name: 
Test
Player1, choose your cell element - X or O (you can use the same for all 3 games): 
Enter your choice: 
X
This is the number of rows you need to have so that a player with a choice of a certain celltype wins
5
Starting the Order and Chaos game!
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
It's Arkash's turn.
Enter row:
0
Enter column:
0
Enter your cell value (X or O):
X
| X | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
It's Test's turn.
Enter row:
0
Enter column:
1
Enter your cell value (X or O):
X
| X | X | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
It's Arkash's turn.
Enter row:
0
Enter column:
2
Enter your cell value (X or O):s
X
| X | X | X | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
It's Test's turn.
Enter row:
0
Enter column:
3
Enter your cell value (X or O):
X
| X | X | X | X | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  
Test wins!
Ending the OrderAndChaos Game
Test
Heres the score tally: 
Test: 1
Play Again? (Y/N): 
Y
---------------------------------------------------------
Which game would you like to play? Here's your options: 
A) TicTacToe B) OrderAndChaos C) Connect4
Choose the one you want to play by typing in the game name, the case doesn't matter
CONNECT4
Enter your name Player1: 
Arkash
Player2 - Enter your name: 
NewPlayer
Player1, choose your cell element - X or O (you can use the same for all 3 games): 
Enter your choice: 
X
This is the number of rows you need to have so that a player with a choice of a certain celltype wins
4
Starting the Connect4 game!
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
It's Arkash's turn.
Enter column : 
0
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
It's NewPlayer's turn.
Enter column : 
1
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | O | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
It's Arkash's turn.
Enter column : 
0
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | O | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
It's NewPlayer's turn.
Enter column : 
3
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | O | Blank | O | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
It's Arkash's turn.
Enter column : 
0
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | O | Blank | O | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
It's NewPlayer's turn.
Enter column : 
2
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | O | O | O | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
It's Arkash's turn.
Enter column : 
0
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
| X | O | O | O | Blank | Blank | Blank | 
---  ---  ---  ---  ---  ---  ---  
Arkash wins!
Ending the Connect4 Game
Arkash
Heres the score tally: 
Test: 1
Arkash: 1
Play Again? (Y/N): 
Y
---------------------------------------------------------
Which game would you like to play? Here's your options: 
A) TicTacToe B) OrderAndChaos C) Connect4
Choose the one you want to play by typing in the game name, the case doesn't matter
tictactoe
Enter your name Player1: 
Test
Player2 - Enter your name: 
NewUser
Player1, choose your cell element - X or O (you can use the same for all 3 games): 
Enter your choice: 
X
Enter the dimensions of the board. (Rows have to be equal to columns)
5
Enter the winning condition (which should be less than the rows). 
This is the number of rows you need to have so that a player with a choice of a certain celltype wins
3
Starting the TicTacToe Game
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
It's Test's turn.
Enter row : 
0
Enter column : 
0
| X | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
It's NewUser's turn.
Enter row : 
1
Enter column : 
1
| X | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | O | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
It's Test's turn.
Enter row : 
0
Enter column : 
1
| X | X | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | O | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
It's NewUser's turn.
Enter row : 
0
Enter column : 
5
Enter another combination
Enter row : 
0
Enter column : 
2
| X | X | O | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | O | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
It's Test's turn.
Enter row : 
4
Enter column : 
0
| X | X | O | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | O | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
It's NewUser's turn.
Enter row : 
3
Enter column : 
3
| X | X | O | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | O | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | O | Blank | 
---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
It's Test's turn.
Enter row : 
0
Enter column : 
3
| X | X | O | X | Blank | 
---  ---  ---  ---  ---  
| Blank | O | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | O | Blank | 
---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
It's NewUser's turn.
Enter row : 
2
Enter column : 
2
| X | X | O | X | Blank | 
---  ---  ---  ---  ---  
| Blank | O | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | O | Blank | Blank | 
---  ---  ---  ---  ---  
| Blank | Blank | Blank | O | Blank | 
---  ---  ---  ---  ---  
| X | Blank | Blank | Blank | Blank | 
---  ---  ---  ---  ---  
NewUser wins!
Ending the TicTacToe Game
NewUser
Heres the score tally: 
Test: 1
Arkash: 1
NewUser: 1
Play Again? (Y/N): 
N
-------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------