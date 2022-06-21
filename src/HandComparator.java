import model.Card;
import model.Winner;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HandComparator {

    private final Hand hand1;
    private final Hand hand2;

    public HandComparator(final Hand hand1, final Hand hand2) {
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public void printWinner() {
        var res = "it's a tie!";

        if (determineWinner() == Winner.HAND1) {
            res = "Hand 1 has won!";
        }

        if (determineWinner() == Winner.HAND2) {
            res = "Hand 2 has won!";
        }

        System.out.println("hand1: " + hand1.toString() + "| hand2: " + hand2.toString() + " | -> " + res);
    }

    public Winner determineWinner() {
        return determineWinner(hand1.getCards(), hand2.getCards());
    }

    private Winner determineWinner(final List<Card> cards1, final List<Card> cards2) {
        final var hand1Class = Hand.getHandClass(cards1);
        final var hand2Class = Hand.getHandClass(cards2);

        if (hand1Class.ordinal() > hand2Class.ordinal()) {
            return Winner.HAND1;
        }

        if (hand2Class.ordinal() > hand1Class.ordinal()) {
            return Winner.HAND2;
        }

        return switch (hand1Class) {
            case HighCard -> compareHighCard(cards1, cards2);
            case Pair -> comparePair(cards1, cards2);
            case TwoPairs -> compareTwoPairs(cards1, cards2);
            case ThreeOfAKind -> compareThreeOfAKind(cards1, cards2);
            case Straight -> compareStraight(cards1, cards2);
            case Flush -> compareFlush(cards1, cards2);
            case FullHouse -> compareFullHouse(cards1, cards2);
            case FourOfAKind -> compareFourOFAKind(cards1, cards2);
            case StraightFlush -> compareStraightFlush(cards1, cards2);
        };
    }

    /**
     * Highest card wins.
     */
    private Winner compareHighCard(List<Card> hand1Cards, List<Card> hand2Cards) {
        final var hand1Highest = Collections.max(hand1Cards);
        final var hand2Highest = Collections.max(hand2Cards);

        if (hand1Highest.compareTo(hand2Highest) > 0) {
            return Winner.HAND1;
        }

        if (hand2Highest.compareTo(hand1Highest) > 0) {
            return Winner.HAND2;
        }

        return Winner.TIE;
    }

    /**
     * Higher pair wins.
     */
    private Winner comparePair(List<Card> hand1Cards, List<Card> hand2Cards) {
        return compareNOfAKind(hand1Cards, hand2Cards, 2);
    }

    /**
     * The higher ranked pair wins.
     */
    private Winner compareTwoPairs(List<Card> hand1Cards, List<Card> hand2Cards) {
        final var hand1GroupedByValue = Hand.groupCardsByValue(hand1Cards);
        final var hand2GroupedByValue = Hand.groupCardsByValue(hand2Cards);

        final var hand1Pairs = hand1GroupedByValue.keySet().stream()
                .filter(key -> hand1GroupedByValue.get(key).size() == 2)
                .collect(Collectors.toList());

        final var hand2Pairs = hand2GroupedByValue.keySet().stream()
                .filter(key -> hand2GroupedByValue.get(key).size() == 2)
                .collect(Collectors.toList());

        //this is a mess
        final var hand1BiggerPair = compareHighCard(
                hand1GroupedByValue.get(hand1Pairs.get(0)),
                hand1GroupedByValue.get(hand1Pairs.get(1))
        ) == Winner.HAND1 ? hand1GroupedByValue.get(hand1Pairs.get(0))
                : hand1GroupedByValue.get(hand1Pairs.get(1));

        final var hand2BiggerPair = compareHighCard(
                hand2GroupedByValue.get(hand2Pairs.get(0)),
                hand2GroupedByValue.get(hand2Pairs.get(1))
        ) == Winner.HAND1 ? hand1GroupedByValue.get(hand1Pairs.get(0))
                : hand2GroupedByValue.get(hand2Pairs.get(1));

        final var highestPairWinner = compareHighCard(hand1BiggerPair, hand2BiggerPair);
        if (highestPairWinner != Winner.TIE) {
            return highestPairWinner;
        }

        //handle kicker
        hand1Cards.remove(hand1BiggerPair);
        hand2Cards.remove(hand2BiggerPair);

        return determineWinner(hand1Cards, hand2Cards);
    }

    /**
     * The higher ranking card wins.
     */
    private Winner compareThreeOfAKind(List<Card> hand1Cards, List<Card> hand2Cards) {
        return compareNOfAKind(hand1Cards, hand2Cards, 3);
    }

    /**
     * The straight with the highest ranking card wins.
     */
    private Winner compareStraight(List<Card> hand1Cards, List<Card> hand2Cards) {
        return compareHighCard(hand1Cards, hand2Cards);
    }

    /**
     * The flush with the highest ranking card wins.
     */
    private Winner compareFlush(List<Card> hand1Cards, List<Card> hand2Cards) {
        return compareHighCard(hand1Cards, hand2Cards);
    }

    /**
     * The hand with the higher ranking set of three cards wins.
     */
    private Winner compareFullHouse(List<Card> hand1Cards, List<Card> hand2Cards) {
        return compareNOfAKind(hand1Cards, hand2Cards, 3);
    }

    /**
     * The higher ranked set of four cards wins.
     */
    private Winner compareFourOFAKind(List<Card> hand1Cards, List<Card> hand2Cards) {
        return compareNOfAKind(hand1Cards, hand2Cards, 4);
    }

    /**
     * Higher straight flush wins.
     */
    private Winner compareStraightFlush(List<Card> hand1Cards, List<Card> hand2Cards) {
        return compareHighCard(hand1.getCards(), hand2.getCards());
    }

    private Winner compareNOfAKind(final List<Card> hand1Cards, final List<Card> hand2Cards, final int n) {
        final var hand1GroupedByValue = Hand.groupCardsByValue(hand1Cards);
        final var hand2GroupedByValue = Hand.groupCardsByValue(hand2Cards);

        final var match1 = hand1GroupedByValue
                .values().stream()
                .filter(group -> group.size() == n)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        final var match2 = hand2GroupedByValue
                .values().stream()
                .filter(group -> group.size() == n)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        final var highCardResult = compareHighCard(match1, match2);
        if (highCardResult != Winner.TIE) {
            return highCardResult;
        }

        //Kicker
        final var rest1 = hand1GroupedByValue
                .values().stream()
                .filter(group -> group.size() != n)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        final var rest2 = hand2GroupedByValue
                .values().stream()
                .filter(group -> group.size() != n)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return determineWinner(rest1, rest2);
    }
}
