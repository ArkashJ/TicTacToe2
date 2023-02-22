package Main.Board;
import Main.Cell.Cell;

public class OrderAndChaosBoard extends GameBoard{
    protected int winningCondition;
    private int ROWS;
    private int COLS;
    private Cell winnerCell = null;

    public OrderAndChaosBoard(int ROWS, int COLS, int winningCondition){
        super(ROWS, COLS);
        this.ROWS = ROWS;
        this.COLS = COLS;
        this.winningCondition = winningCondition;
    }

    @Override
    public boolean checkWin() {
        return checkRowsForWin() || checkColsForWin() || checkDiagsForWin();
    }

    private boolean checkRowsForWin() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (checkFour(board[row][col], board[row][col + 1], board[row][col + 2], board[row][col + 3])) {
                    winnerCell = board[row][col];
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkColsForWin() {
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row < ROWS - 3; row++) {
                if (checkFour(board[row][col], board[row + 1][col], board[row + 2][col], board[row + 3][col])) {
                    winnerCell = board[row][col];
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagsForWin() {
        // top left to bottom right
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (checkFour(board[row][col], board[row + 1][col + 1], board[row + 2][col + 2], board[row + 3][col + 3])) {
                    winnerCell = board[row][col];
                    return true;
                }
            }
        }
        // bottom left to top right
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 3; col < COLS; col++) {
                if (checkFour(board[row][col], board[row + 1][col - 1], board[row + 2][col - 2], board[row + 3][col - 3])) {
                    winnerCell = board[row][col];
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkFour(Cell p1, Cell p2, Cell p3, Cell p4) {
        return p1 != Cell.Blank && p1 == p2 && p1 == p3 && p1 == p4;
    }

    public Cell getWinner(){
        if (winnerCell != null)
            return winnerCell;
        
        return null;
    }

    public int getLowestEmptyCell(int col){
        return 0;
    }
}