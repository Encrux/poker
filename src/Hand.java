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

    private boolean isPair(final List<Card> cards) {
        return isNOfAKind(cards, 2);
    }

    private boolean isTwoPairs(final List<Card> cards) {
        if (isNOfAKind(cards, 2)) {
            final var cardsPerValue = groupCardsByValue(cards);
            return cardsPerValue.size() == 3;
        }

        return false;
    }

    private boolean isThreeOfAKind(final List<Card> cards) {
        return isNOfAKind(cards, 3);
    }

    private boolean isStraight(final List<Card> cards) {
        final var lowest = cards.get(0).getValue().ordinal();

        for (int i = lowest; i <= lowest + 3; i++) {
            final var current = cards.get(i).getValue().ordinal();
            final var next = cards.get(i + 1).getValue().ordinal();
            if (current + 1 != next) {
                return false;
            }
        }
        return true;
    }

    private boolean isFlush(final List<Card> cards) {
        final var cardsPerSuit = groupCardsBySuit(cards);
        return cardsPerSuit.size() == 1;
    }

    private boolean isFullHouse(final List<Card> cards) {
        if (isNOfAKind(cards, 3)) {
            final var cardsPerValue = groupCardsByValue(cards);
            return cardsPerValue.size() == 2;
        }
        return false;
    }

    private boolean isFourOfAKind(final List<Card> cards) {
        return isNOfAKind(cards, 4);
    }

    private boolean isStraightFlush(final List<Card> cards) {
        return isStraight(cards) && isFlush(cards);
    }

    private boolean isNOfAKind(final List<Card> cards, final int n) {
        final var cardsPerValue = groupCardsByValue(cards);

        for (List<Card> group : cardsPerValue.values()) {
            if (group.size() == n) {
                return true;
            }
        }

        return false;
    }

    private Map<CardValue, List<Card>> groupCardsByValue(final List<Card> cards) {
        return cards.stream().collect(groupingBy(Card::getValue));
    }

    private Map<CardSuit, List<Card>> groupCardsBySuit(final List<Card> cards) {
        return cards.stream().collect(groupingBy(Card::getSuit));
    }

    public List<Card> getCards() {
        return cards;
    }
}
