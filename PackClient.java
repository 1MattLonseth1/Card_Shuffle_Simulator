import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;

public class PackClient {
    private static void printTest() {
        Card[] printCards = {new Card(0, 11), new Card(1, 12), new Card(2, 13), new Card(3, 1)};
        System.out.println("Printing some cards: " + Arrays.toString(printCards));
        System.out.println("If you see the suits as '?', you should modify lines 14-15 in Card.java!");
    }
    public static void main(String[] args) {
        //printTest();
        System.out.println("CUT TESTS");
        Card[] cards1 = {new Card(0, 5), new Card(0, 3), new Card(0, 8), new Card(1, 4), new Card(2, 10), new Card(3, 7), new Card(2, 1), new Card(1, 3), new Card(0, 4), new Card(3, 5), new Card(3, 12)};

        Pack pack1 = new Pack(cards1);
        System.out.println(pack1);
        System.out.println();
        Pack cutPack1 = pack1.cut(3, false);
        System.out.println(cutPack1);
        System.out.println(pack1);
        System.out.println();
        Pack cutPack2 = pack1.cut(4, true);
        System.out.println(cutPack2);
        System.out.println(pack1);
        System.out.println();


        System.out.println("AddOnTop TESTS");
        Card[] cards2 = {new Card(0, 1), new Card(0, 2), new Card(0, 3), new Card(0, 4), new Card(0, 5)};

        Card[] cards3 = {new Card(0, 6), new Card(0, 7), new Card(0, 8), new Card(0, 9), new Card(0, 10), new Card(0, 11)};

        Pack pack2 = new Pack(cards2);
        Pack pack3 = new Pack(cards3);

        pack2.addOnTop(pack3);

        System.out.println(pack2);
        System.out.println(pack3);
        System.out.println();

        System.out.println("Dovetail Shuffle TESTS");
        Card[] cards4 = {new Card(1, 3), new Card(3, 2), new Card(0, 7), new Card(2, 4), new Card(0, 11), new Card(0, 5), new Card(0, 3), new Card(0, 8), new Card(1, 4), new Card(2, 10), new Card(3, 7)};
        Pack pack4 = new Pack(cards4);

        System.out.println("Unshuffled Pack");
        System.out.println(pack4);
        System.out.println("Shuffled Pack");
        pack4.dovetailShuffle(4);
        System.out.println(pack4);
        System.out.println();

        System.out.println("Deal TESTS");
        Card[] cards5 = {new Card(0, 6), new Card(0, 7), new Card(0, 8), new Card(0, 9), new Card(0, 10), new Card(0, 11), new Card(0, 12), new Card(0, 3)};
        Pack pack5 = new Pack(cards5);
        System.out.println(pack5);
        System.out.println(pack5.deal(2, 3));
        System.out.println();
    }
}
