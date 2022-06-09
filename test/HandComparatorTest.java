import model.Card;
import model.Winner;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class HandComparatorTest {

    @Test
    public void compareHighCard() {
        validate(ExampleHands.HIGH_CARD, ExampleHands.HIGH_CARD_1, Winner.HAND1);
    }

    @Test
    public void comparePair() {
        validate(ExampleHands.PAIR, ExampleHands.PAIR_1, Winner.HAND1);
    }

    @Test
    public void compareTwoPairs() {
        validate(ExampleHands.TWO_PAIRS, ExampleHands.TWO_PAIRS_1, Winner.HAND1);
    }

    @Test
    public void compareThreeOfAKind() {
        validate(ExampleHands.THREE_OF_A_KIND, ExampleHands.THREE_OF_A_KIND_1, Winner.HAND1);
    }

    @Test
    public void compareStraight() {
        validate(ExampleHands.STRAIGHT, ExampleHands.STRAIGHT_1, Winner.HAND1);
    }

    @Test
    public void compareFlush() {
        validate(ExampleHands.FLUSH, ExampleHands.FLUSH_1, Winner.HAND1);
    }

    @Test
    public void compareFullHouse() {
        validate(ExampleHands.FULL_HOUSE, ExampleHands.FULL_HOUSE_1, Winner.HAND1);
    }

    @Test
    public void compareFourOfAKind() {
        validate(ExampleHands.FOUR_OF_A_KIND, ExampleHands.FOUR_OF_A_KIND_1, Winner.HAND1);
    }

    @Test
    public void compareStraightFlush() {
        validate(ExampleHands.STRAIGHT_FLUSH, ExampleHands.STRAIGHT_FLUSH_1, Winner.HAND1);
    }

    /**
     * Right now, hand2 is supposed to win every time.
     * Maybe not the best choice for test cases, but for now it'll do.
     */
    public static void validate(
            final List<Card> cards1,
            final List<Card> cards2,
            final Winner expected
    ) {
        final var hand1 = new Hand(cards1);
        final var hand2 = new Hand(cards2);
        final var handComparator = new HandComparator(hand1, hand2);
        Assert.assertEquals(expected, handComparator.determineWinner());
    }

}
