import java.util.ArrayList;

public class President {

    public static void main(String[] args) {

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(new LowestStrategy(), "Lowest 1"));
        players.add(new Player(new LowestStrategy(), "Lowest 2"));
        players.add(new Player(new RandomStrategy(), "Random"));
        players.add(new Player(new HighestStrategy(), "Highest 1"));
        players.add(new Player(new HighestStrategy(), "Highest 2"));

        Game game = new Game(players);

        game.runGame();
    }
}
