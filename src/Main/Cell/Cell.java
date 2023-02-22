package Main.Cell;


public enum Cell implements ICell {
    X("X"), O("O"), Blank("-");

    private final String symbol;

    Cell(String symbol){
        this.symbol = symbol;
    }   

    @Override
    public String getSymbol(){
        return symbol;
    }
}
