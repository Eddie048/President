import java.util.ArrayList;

public class Game {

    private final ArrayList<Player> players;
    private final Deck deck;
    private int currentTurn;

    public Game(ArrayList<Player> players) {
        this.players = players;
        deck = new Deck();
        deck.shuffle();
        currentTurn = (int) (Math.random() * players.size());
    }

    /**
     * Run the game
     * @return the winning player
     */
    public Player runGame() {

        // Ensure hands are empty
        for (Player p : players) {
            p.setHand(new ArrayList<>());
        }

        // Deal cards
        for (int curPlayer = 0; deck.size() > 0; curPlayer = (curPlayer + 1) % players.size()) {
            players.get(curPlayer).getHand().add(deck.deal());
        }



        // Run loops of the game
        while (true) {

            doRound();

            boolean gameOver = true;
            for (Player p : players) {
                if (!p.hasWon()) gameOver = false;
            }
            if (gameOver) break;

//            for (Player p : players) {
//                if (p.hasWon()) return p;
//            }

        }
        return null;
    }

    public void doRound() {
        // Initialize current card being played
        Card currentCard = null;

        // The last player to have played a card
        int lastPlayed = currentTurn - 1;
        if (lastPlayed == -1) lastPlayed = players.size() - 1;

        while (true) {
            // One player's turn

            // If no one has been able to play, end this round
            if (lastPlayed == currentTurn) {
                System.out.println("No one can play, clears to " + players.get(currentTurn).getName());
                break;
            }

            // Check for player has already won
            if (players.get(currentTurn).hasWon()) {
                currentTurn = (currentTurn + 1) % players.size();
                continue;
            }

            // Get player's played card
            Card playedCard = players.get(currentTurn).doTurn(currentCard);

            // Check for player passing
            if (playedCard == null) {
                System.out.println(players.get(currentTurn).getName() + " passes their turn.");
                currentTurn = (currentTurn + 1) % players.size();
                continue;
            }

            // If player has won, end round
//            if (players.get(currentTurn).hasWon()) return;

            // Otherwise, update currentCard
            System.out.println(players.get(currentTurn).getName() + " played the " + playedCard);
            if (players.get(currentTurn).hasWon()) System.out.println(players.get(currentTurn).getName() + " has won.");

            // If played card is the same as the last one, skip the next player
            boolean isSkip = false;
            if (currentCard != null && currentCard.value() == playedCard.value()){
                isSkip = true;
                System.out.println(players.get((currentTurn + 1) % players.size()).getName() + " was skipped!");
            }

            // Update cards and turn
            currentCard = playedCard;
            lastPlayed = currentTurn;
            currentTurn = (currentTurn + (isSkip ? 2 : 1)) % players.size();

        }
    }
}
