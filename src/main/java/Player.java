import java.util.ArrayList;

public class Player {
    private final String name;
    private ArrayList<Card> hand;
    private final Strategy strategy;

    public Player(ArrayList<Card> hand, Strategy strategy, String name) {
        this.hand = hand;
        this.strategy = strategy;
        this.name = name;
    }

    public Player(Strategy strategy, String name) {
        this(null, strategy, name);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public boolean hasWon() {
        return hand.size() == 0;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public Card doTurn(Card current) {
        Card toPlay = strategy.play(hand, current);
        hand.remove(toPlay);
        return toPlay;
    }
}
