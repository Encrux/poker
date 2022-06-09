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

    public List<Card> getCards() {
        return cards;
    }
}
