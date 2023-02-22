package Main.Players;
import Main.Cell.*;

public class Player implements IPlayer {
    private String playerName;
    private Cell playerChoice;

    public Player(String playerName, Cell playerChoice){
        this.playerName = playerName;
        this.playerChoice = playerChoice;
    }

    @Override
    public String getPlayerName(){
        return playerName;
    }

    @Override
    public Cell getPlayerCell(){
        return playerChoice;
    }
}
