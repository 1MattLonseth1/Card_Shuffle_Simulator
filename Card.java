import java.util.ArrayList;

public class Card {
	public static int MIN_RANK = 1; // minimum rank a card can assume, i.e. the ace
	public static int MAX_RANK = 13; // where 11 is the Jack, 12 is the Queen, 13 is the King

	public static int MIN_SUIT = 0;
	public static int MAX_SUIT = 3; // 0 represents spades, 1 is hearts, 2 is clubs, 3 is diamonds

	// Used to create String representations
	public static String[] RANK_REPR = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

	// If you see '?' when printing cards, comment out line 14 and uncomment line 15
	public static char[] SUIT_REPR = {'\u2660' ,'\u2764', '\u2663', '\u2666'};
	// public static char[] SUIT_REPR = {'S' ,'H', 'C', 'D'}; // spades, hearts, clubs, and diamonds respectively

	// Instance variables
	private int suit;
	private int rank;

	// Constructor
	public Card(int suit, int rank) {
		if (!isBetween(suit, MIN_SUIT, MAX_SUIT) || !isBetween(rank, MIN_RANK, MAX_RANK)) {
			throw new IllegalArgumentException("Invalid card parameters provided.");
		}
		this.suit = suit;
		this.rank = rank;
	}

	// Constructor validation helpers
	private static boolean isBetween(int arg, int low, int high) {
		return (arg <= high && arg >= low);
	}

	// Accessor methods
	public int getSuit() {
		return this.suit;
	}

	public int getRank() {
		return this.rank;
	}

	// This might be useful in 3.2...
	public Card getNext() {
		if (this.rank == MAX_RANK) {
			return null;
		}
		return new Card(this.suit, this.rank + 1);
	}

	// Overriden from Object
	public String toString() {
		return SUIT_REPR[this.suit] + RANK_REPR[this.rank - 1];
	}

	// We will need this method for some ArrayList methods that your Pack implementation might use!
	public boolean equals(Object other) {
		if (other instanceof Card) {
			Card casted = (Card)other;
			if (this.rank == casted.rank && this.suit == casted.suit) {
				return true;
			}
			return false;
		}
		return false;
	}

	// Returns a standard 52 card deck as an array
	public static Card[] standardPack() {
		Card[] result = new Card[52];
		for (int i = MIN_SUIT; i <= MAX_SUIT; i++) {
			for (int j = MIN_RANK; j <= MAX_RANK; j++) {
				result[(MAX_RANK - MIN_RANK + 1) * i + (j - 1)] = new Card(i, j);
			}
		}
		return result;
	}
}
