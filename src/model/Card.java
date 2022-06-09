package model;

public class Card {
    private final CardSuit suit;
    private final CardValue value;

    public Card(final CardSuit suit, final CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }
}
