import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import model.Card;
import model.HandClass;

import java.util.List;

public class Hand {

    private final List<Card> cards;

    /**
     * Always assumes exactly 5 cards are passed
     */
    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    private boolean isPair(final List<Card> cards) {
        return false;
    }

    private boolean isTwoPairs(final List<Card> cards) {
        return false;
    }

    private boolean isThreeOfAKind(final List<Card> cards) {
        return false;
    }

    private boolean isStraight(final List<Card> cards) {
        return false;
    }

    private boolean isFlush(final List<Card> cards) {
        return false;
    }

    private boolean isFullHouse(final List<Card> cards) {
        return false;
    }

    private boolean isFourOfAKind(final List<Card> cards) {
        return false;
    }

    private boolean isStraightFlush(final List<Card> cards) {
        return false;
    }
}
