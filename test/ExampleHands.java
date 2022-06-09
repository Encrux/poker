import model.Card;
import model.CardSuit;
import model.CardValue;

import java.util.List;

/**
 * Example hands.
 * The Hand of the same class ending with "1" wins
 *
 * When comparing two hands of the same class, there will be duplicates.
 * I didn't bother removing them from the test cases, because it shouldn't matter for the result.
 */
public class ExampleHands {

    static final List<Card> HIGH_CARD = List.of(
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.H, CardValue.V4),
            new Card(CardSuit.D, CardValue.V6),
            new Card(CardSuit.S, CardValue.V8),
            new Card(CardSuit.C, CardValue.V10)
    );

    static final List<Card> HIGH_CARD_1 = List.of(
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.D, CardValue.V4),
            new Card(CardSuit.S, CardValue.V6),
            new Card(CardSuit.C, CardValue.V8),
            new Card(CardSuit.C, CardValue.A)
    );

    static final List<Card> PAIR = List.of(
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.D, CardValue.V2),
            new Card(CardSuit.C, CardValue.V6),
            new Card(CardSuit.C, CardValue.V8),
            new Card(CardSuit.C, CardValue.V10)
    );

    static final List<Card> PAIR_1 = List.of(
            new Card(CardSuit.C, CardValue.V3),
            new Card(CardSuit.D, CardValue.V3),
            new Card(CardSuit.C, CardValue.V6),
            new Card(CardSuit.C, CardValue.V8),
            new Card(CardSuit.C, CardValue.V10)
    );

    static final List<Card> TWO_PAIRS = List.of(
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.D, CardValue.V2),
            new Card(CardSuit.C, CardValue.V6),
            new Card(CardSuit.D, CardValue.V6),
            new Card(CardSuit.C, CardValue.V10)
    );

    static final List<Card> TWO_PAIRS_1 = List.of(
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.D, CardValue.V2),
            new Card(CardSuit.C, CardValue.V8),
            new Card(CardSuit.D, CardValue.V8),
            new Card(CardSuit.C, CardValue.V10)
    );

    static final List<Card> THREE_OF_A_KIND = List.of(
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.D, CardValue.V2),
            new Card(CardSuit.H, CardValue.V2),
            new Card(CardSuit.D, CardValue.V6),
            new Card(CardSuit.C, CardValue.V10)
    );

    static final List<Card> THREE_OF_A_KIND_1 = List.of(
            new Card(CardSuit.C, CardValue.V3),
            new Card(CardSuit.D, CardValue.V3),
            new Card(CardSuit.H, CardValue.V3),
            new Card(CardSuit.D, CardValue.V6),
            new Card(CardSuit.C, CardValue.V10)
    );

    static final List<Card> STRAIGHT = List.of(
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.D, CardValue.V3),
            new Card(CardSuit.C, CardValue.V4),
            new Card(CardSuit.D, CardValue.V5),
            new Card(CardSuit.C, CardValue.V6)
    );

    static final List<Card> STRAIGHT_1 = List.of(
            new Card(CardSuit.C, CardValue.V3),
            new Card(CardSuit.D, CardValue.V4),
            new Card(CardSuit.C, CardValue.V5),
            new Card(CardSuit.D, CardValue.V6),
            new Card(CardSuit.C, CardValue.V7)
    );

    static final List<Card> FLUSH = List.of(
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.C, CardValue.V6),
            new Card(CardSuit.C, CardValue.V6),
            new Card(CardSuit.C, CardValue.V10)
    );

    static final List<Card> FLUSH_1 = List.of(
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.C, CardValue.V6),
            new Card(CardSuit.C, CardValue.V6),
            new Card(CardSuit.C, CardValue.V10)
    );

    static final List<Card> FULL_HOUSE = List.of(
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.D, CardValue.V2),
            new Card(CardSuit.C, CardValue.V6),
            new Card(CardSuit.D, CardValue.V6),
            new Card(CardSuit.H, CardValue.V6)
    );

    static final List<Card> FULL_HOUSE_1 = List.of(
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.D, CardValue.V2),
            new Card(CardSuit.C, CardValue.A),
            new Card(CardSuit.D, CardValue.A),
            new Card(CardSuit.H, CardValue.A)
    );

    static final List<Card> FOUR_OF_A_KIND = List.of(
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.D, CardValue.V2),
            new Card(CardSuit.H, CardValue.V2),
            new Card(CardSuit.S, CardValue.V2),
            new Card(CardSuit.H, CardValue.V6)
    );

    static final List<Card> FOUR_OF_A_KIND_1 = List.of(
            new Card(CardSuit.C, CardValue.V10),
            new Card(CardSuit.D, CardValue.V10),
            new Card(CardSuit.H, CardValue.V10),
            new Card(CardSuit.S, CardValue.V10),
            new Card(CardSuit.H, CardValue.V6)
    );

    static final List<Card> STRAIGHT_FLUSH = List.of(
            new Card(CardSuit.C, CardValue.V2),
            new Card(CardSuit.C, CardValue.V3),
            new Card(CardSuit.C, CardValue.V4),
            new Card(CardSuit.C, CardValue.V5),
            new Card(CardSuit.C, CardValue.V6)
    );

    static final List<Card> STRAIGHT_FLUSH_1 = List.of(
            new Card(CardSuit.C, CardValue.V10),
            new Card(CardSuit.C, CardValue.J),
            new Card(CardSuit.C, CardValue.Q),
            new Card(CardSuit.C, CardValue.K),
            new Card(CardSuit.C, CardValue.A)
    );
}
