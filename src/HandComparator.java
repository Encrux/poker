import model.Winner;

public class HandComparator {

    private final Hand hand1;
    private final Hand hand2;

    public HandComparator(final Hand hand1, final Hand hand2) {
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public Winner determineWinner() {
        final var hand1Class = hand1.getHandClass();
        final var hand2Class = hand2.getHandClass();

        if (hand1Class.ordinal() > hand2Class.ordinal()) {
            return Winner.HAND1;
        }

        if (hand2Class.ordinal() > hand1Class.ordinal()) {
            return Winner.HAND2;
        }

        return switch (hand1Class) {
            case HighCard -> compareHighCard();
            case Pair -> comparePair();
            case TwoPairs -> compareTwoPairs();
            case ThreeOfAKind -> compareThreeOfAKind();
            case Straight -> compareStraight();
            case Flush -> compareFlush();
            case FullHouse -> compareFullHouse();
            case FourOfAKind -> compareFourOFAKind();
            case StraightFlush -> compareStraightFlush();
        };
    }

    private Winner compareHighCard() {
        return null;
    }

    private Winner comparePair() {
        return null;
    }

    private Winner compareTwoPairs() {
        return null;
    }

    private Winner compareThreeOfAKind() {
        return null;
    }

    private Winner compareStraight() {
        return null;
    }

    private Winner compareFlush() {
        return null;
    }

    private Winner compareFullHouse() {
        return null;
    }

    private Winner compareFourOFAKind() {
        return null;
    }

    private Winner compareStraightFlush() {
        return null;
    }
}
