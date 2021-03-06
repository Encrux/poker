import model.Card;
import model.CardSuit;
import model.CardValue;
import model.HandClass;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class Hand {

    private final List<Card> cards;

    /**
     * Always assumes exactly 5 cards are passed
     */
    public Hand(final List<Card> cards) {
        var myCards = new ArrayList<>(cards);
        Collections.sort(myCards);
        this.cards = myCards;
    }

    public HandClass getHandClass() {
        return Hand.getHandClass(this.cards);
    }

    public static HandClass getHandClass(final List<Card> cards) {
        if (isStraightFlush(cards)) return HandClass.StraightFlush;
        if (isFourOfAKind(cards)) return HandClass.FourOfAKind;
        if (isFullHouse(cards)) return HandClass.FullHouse;
        if (isFlush(cards)) return HandClass.Flush;
        if (isStraight(cards)) return HandClass.Straight;
        if (isThreeOfAKind(cards)) return HandClass.ThreeOfAKind;
        if (isTwoPairs(cards)) return HandClass.TwoPairs;
        if (isPair(cards)) return HandClass.Pair;

        return HandClass.HighCard;
    }

    private static boolean isPair(final List<Card> cards) {
        return isNOfAKind(cards, 2);
    }

    private static boolean isTwoPairs(final List<Card> cards) {
        if (isNOfAKind(cards, 2)) {
            final var cardsPerValue = groupCardsByValue(cards);
            return cardsPerValue.size() == 3;
        }

        return false;
    }

    private static boolean isThreeOfAKind(final List<Card> cards) {
        return isNOfAKind(cards, 3);
    }

    private static boolean isStraight(final List<Card> cards) {
        if (cards.size() < 5) {
            return false;
        }

        var current = cards.get(0).getValue().ordinal();

        for (int i = 0; i <= 3; i++) {
            final var next = cards.get(i + 1).getValue().ordinal();
            if (current + 1 != next) {
                return false;
            }
            current = next;
        }
        return true;
    }

    private static boolean isFlush(final List<Card> cards) {
        final var cardsPerSuit = groupCardsBySuit(cards);
        return cardsPerSuit.size() == 1;
    }

    private static boolean isFullHouse(final List<Card> cards) {
        if (isNOfAKind(cards, 3)) {
            final var cardsPerValue = groupCardsByValue(cards);
            return cardsPerValue.size() == 2;
        }
        return false;
    }

    private static boolean isFourOfAKind(final List<Card> cards) {
        return isNOfAKind(cards, 4);
    }

    private static boolean isStraightFlush(final List<Card> cards) {
        return isStraight(cards) && isFlush(cards);
    }

    private static boolean isNOfAKind(final List<Card> cards, final int n) {
        final var cardsPerValue = groupCardsByValue(cards);

        for (List<Card> group : cardsPerValue.values()) {
            if (group.size() == n) {
                return true;
            }
        }

        return false;
    }

    public static Map<CardValue, List<Card>> groupCardsByValue(final List<Card> cards) {
        return cards.stream().collect(groupingBy(Card::getValue));
    }

    public static Map<CardSuit, List<Card>> groupCardsBySuit(final List<Card> cards) {
        return cards.stream().collect(groupingBy(Card::getSuit));
    }

    public List<Card> getCards() {
        return cards;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Card card : cards) {
            res.append(card.toString()).append(" ");
        }

        return res.toString();
    }
}
