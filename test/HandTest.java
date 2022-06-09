import model.Card;
import model.HandClass;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class HandTest {

    @Test
    public void testHighCard() {
        validate(ExampleHands.HIGH_CARD, HandClass.HighCard);
    }

    @Test
    public void testPair() {
        validate(ExampleHands.PAIR, HandClass.Pair);
    }

    @Test
    public void testTwoPairs() {
        validate(ExampleHands.TWO_PAIRS, HandClass.TwoPairs);
    }

    @Test
    public void testThreeOfAKind() {
        validate(ExampleHands.THREE_OF_A_KIND, HandClass.ThreeOfAKind);
    }

    @Test
    public void testStraight() {
        validate(ExampleHands.STRAIGHT, HandClass.Straight);
    }

    @Test
    public void testFlush() {
        validate(ExampleHands.FLUSH, HandClass.Flush);
    }

    @Test
    public void testFullHouse() {
        validate(ExampleHands.FULL_HOUSE, HandClass.FullHouse);
    }

    @Test
    public void testFourOfAKind() {
        validate(ExampleHands.FOUR_OF_A_KIND, HandClass.FourOfAKind);
    }

    @Test
    public void testStraightFlush() {
        validate(ExampleHands.STRAIGHT_FLUSH, HandClass.StraightFlush);
    }

    public static void validate(final List<Card> cards, final HandClass expected) {
        final var hand = new Hand(cards);
        Assert.assertEquals(expected, hand.getHandClass());
    }
}
