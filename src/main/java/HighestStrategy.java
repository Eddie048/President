import java.util.List;

public class HighestStrategy implements Strategy{
    @Override
    public Card play(List<Card> hand, Card current) {
        Card highest = null;

        for (Card c : hand) {
            if ((current == null || c.value() >= current.value()) && (highest == null || c.value() > highest.value())) {
                highest = c;
            }
        }

        return highest;
    }
}
