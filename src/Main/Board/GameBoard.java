package Main.Board;
import Main.Cell.*;

public abstract class GameBoard implements IBoard{
    protected Cell[][] board;
    private int ROWS;
    private int COLS;
    
    public GameBoard(int ROWS, int COLS){
        this.board = new Cell[ROWS+1][COLS+1];
        this.ROWS = ROWS;
        this.COLS = COLS;
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLS; j++){
                board[i][j] = Cell.Blank;
            }
        }
    }

    @Override
    public void printBoard(){
        for (int i = 0; i < board.length-1; i++){
            for (int j = 0; j < board[0].length-1; j++) {
                System.out.print("| " + board[i][j] + "  " );
            }
            System.out.println("| ");
            for (int j = 0; j < COLS; j++){
                System.out.print("--- ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean isFull(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != Cell.Blank)
                    return false;
            }
        }
        return true;
    }

    @Override
    public boolean placePlayer(int r, int c, Cell cell){
        if (board[r][c] != Cell.Blank)
            return false;
        
        board[r][c] = cell;
        return true;
    }

    public abstract boolean checkWin();
    
    public boolean isGameOver(){
        if (checkWin() || isFull())
            return true;
        
        return false;
    }

    public abstract Cell getWinner();

    public int rowLength(){
        return board.length;
    }
    public int colLength(){
        return board[0].length;
    }
}
