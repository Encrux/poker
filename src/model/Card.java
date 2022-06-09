package model;

public class Card implements Comparable<Card>{
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

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.value.ordinal(), o.value.ordinal());
    }
}
