package Main.Board;

import Main.Cell.Cell;

public class TicTacToeBoard extends GameBoard{
    protected int winningCondition;
    private Cell winnerCell = null;
    private int ROWS;
    private int COLS;

    public TicTacToeBoard(int ROWS, int COLS, int winningCondition){
        super(ROWS, COLS);
        this.winningCondition = winningCondition;
        this.ROWS = ROWS;
        this.COLS = COLS;
    }
    
    @Override
    public boolean checkWin() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] != Cell.Blank) {
                    if (checkHorizontal(i, j) || checkVertical(i, j) || checkDiagonal(i, j, true) || checkDiagonal(i, j, false))
                        return true;
                }//if
            }   //inner for
        }      //outer for
        return false;
    }

    private boolean checkHorizontal(int i, int j) {
        for (int c = j - winningCondition + 1; c <= j; c++) {
            if (c >= 0 && c + winningCondition <= COLS) {
                boolean win = true;
                for (int k = c; k < c + winningCondition; k++) {
                    if (board
                            [i][k] != board[i][j]) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    winnerCell = board[i][j];
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVertical(int i, int j) {
        for (int r = i - winningCondition + 1; r <= i; r++) {
            if (r >= 0 && r + winningCondition <= ROWS) {
                boolean win = true;
                for (int k = r; k < r + winningCondition; k++) {
                    if (board[k][j] != board[i][j]) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    winnerCell = board[i][j];
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(int i, int j, boolean isTopLeftToBottomRight) {
        int count = 1;
        Cell piece = board[i][j];
        int r = i + (isTopLeftToBottomRight ? - 1 : 1);
        int c = j + (isTopLeftToBottomRight ? - 1 : 1);
        while (r >= 0 && r < ROWS && c >= 0 && c < COLS) {
            if (board[r][c] == piece) {
                count++;
                r += (isTopLeftToBottomRight ? -1 : 1);
                c += (isTopLeftToBottomRight ? -1 : 1);
            } else {
                break;
            }
        }
        r = i + (isTopLeftToBottomRight ? 1 : -1);
        c = j + (isTopLeftToBottomRight ? 1 : -1);
        while (r >= 0 && r < ROWS && c >= 0 && c < COLS) {
            if (board[r][c] == piece) {
                count++;
                r += (isTopLeftToBottomRight ? 1 : -1);
                c += (isTopLeftToBottomRight ? 1 : -1);
            } else {
                break;
            }
        }
        if (count >= winningCondition) {
            winnerCell = board[i][j];
            return true;
        }
        return false;
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
