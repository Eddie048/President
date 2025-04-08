import java.util.List;

public class LowestStrategy implements Strategy{
    @Override
    public Card play(List<Card> hand, Card current) {
        Card lowest = null;

        for (Card c : hand) {
            if (c.value() >= current.value() && (lowest == null || c.value() < lowest.value())) {
                lowest = c;
            }
        }

        return lowest;
    }
}
