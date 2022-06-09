public class Main {

    public static void main(String[] args) {
        final var deck = new Deck();

        for (int i = 0; i < 50; i++) {
            play(deck);
            deck.reset();
            deck.shuffle();
        }
    }

    private static void play(final Deck deck) {
        final var hand1 = deck.dealFive();
        final var hand2 = deck.dealFive();

        final var handComparator = new HandComparator(hand1, hand2);

        handComparator.printWinner();
    }
}
