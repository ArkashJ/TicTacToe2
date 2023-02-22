import java.util.HashMap;

// import Main.Players.Player;

public class Win {
    private HashMap<String, Integer> wins = new HashMap<>();
    //if new player add to hashmap else add number of wins
    public void addWin(String name){
        if(wins.containsKey(name)){
            wins.put(name, wins.get(name)+1);
        }   else {
            wins.put(name, 1);
        }
    }
    //return the hash map as key value pairs
    public void printHashMap() {
        for (String key : wins.keySet()) {
            System.out.println(key + ": " + wins.get(key));
        }
    }
}
