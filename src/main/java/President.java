import java.util.ArrayList;

public class President {

    public static void main(String[] args) {

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(new LowestStrategy(), "Player 1"));
        players.add(new Player(new LowestStrategy(), "Player 2"));
        players.add(new Player(new LowestStrategy(), "Player 3"));
        players.add(new Player(new LowestStrategy(), "Player 4"));

        Game game = new Game(players);

        game.runGame();
    }
}
