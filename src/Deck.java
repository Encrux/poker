import model.Card;
import model.CardSuit;
import model.CardValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        reset();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Hand dealFive() {
        final var handCards = new ArrayList<Card>();

        for (int i = 0; i < 5; i++) {
            final var card = cards.get(i);
            cards.remove(card);
            handCards.add(card);
        }

        return new Hand(handCards);
    }

    public void reset() {
        final var cards = new ArrayList<Card>();

        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                cards.add(
                        new Card(suit, value)
                );
            }
        }

        this.cards = cards;
    }

}
