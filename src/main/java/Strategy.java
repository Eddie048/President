import java.util.List;

public interface Strategy {

    public Card play(List<Card> hand, Card current);
}
