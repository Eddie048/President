import java.util.ArrayList;
import java.util.List;

public class RandomStrategy implements Strategy{
    @Override
    public Card play(List<Card> hand, Card current) {
        // If current card is null, pick card at random
        if (current == null) return hand.get((int) (Math.random() * hand.size()));

        // Finds all cards that can be played
        ArrayList<Card> possible = new ArrayList<>();

        for (Card c : hand) {
            if (c.value() >= current.value()) possible.add(c);
        }

        if (possible.size() == 0) return null;

        return possible.get((int) (Math.random() * possible.size()));
    }
}
