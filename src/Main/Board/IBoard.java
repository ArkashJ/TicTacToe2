package Main.Board;
import Main.Cell.*;

//interface to print the board, set players, check who won and check if its full or not
public interface IBoard {
    public void     printBoard();
    public boolean  isGameOver();
    public boolean  isFull();
    public boolean  placePlayer(int row, int col, Cell cell);
    public boolean  checkWin();
    public Cell     getWinner();
    public int      getLowestEmptyCell(int col);
    public int      rowLength();
    public int      colLength();
}
