import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Pack {
	private static final int SIMPLE_GAME_N_SHUFFLES = 7;
	private static final int SIMPLE_GAME_SHUFFLE_MAX = 3;

	// Instance variable
	private ArrayList<Card> cards;

	// Constructors
	public Pack(Collection<Card> arg) { // creates a pack from provided cards
		if (arg.contains(null)) {
			throw new IllegalArgumentException("Argument collection cannot have null entries.");
		}
		this.cards = new ArrayList<Card>(arg);
	}

	public Pack(Card[] arg) { // creates a pack from provided cards
		this(Arrays.asList(arg));
	}

	public Pack() { // creates an empty pack
		this(new Card[0]);
	}

	// Creates a standard 52-card pack
	public static Pack fromStandard() {
		return new Pack(Card.standardPack());
	}

	// Instance methods
	public int size() {
		return this.cards.size();
	}

	public boolean isEmpty() {
		return this.cards.isEmpty();
	}

	public String toString() {
		return "Pack: " + this.cards.toString();
	}

	public ArrayList<Card> view() { // for testing purposes.
		return new ArrayList<Card>(this.cards);
	}
	
	// Cuts the pack of cards at the specified n
	public Pack cut(int n, boolean top) {
		int packSize = this.size();
		if (n < 0 || n > this.size()){
			throw new IllegalArgumentException("Illegal Argument");
		}
		ArrayList<Card> newPack = new ArrayList<Card>();
		if (top){
			for (int i = packSize-n; i < this.size();){
				newPack.add(this.cards.remove(i));
			}
		}
		else if (!top){
			for (int i = 0; i < n; i++){
				newPack.add(this.cards.remove(0));
			}
		}
		Pack cutPack = new Pack(newPack);
		return cutPack; // placeholder
	}

	//Adds the other pack on top of the current pack, getting rid of the other
	public void addOnTop(Pack other) {
		if (this.size() == 0 || other.size() == 0)
			throw new IllegalArgumentException("Illegal Argument");
		this.cards.addAll(other.cards);
		other.cards.clear();
	}

	//Shuffle that randomizes the deck
	public void dovetailShuffle(int max) {
		if (max < 1)
			throw new IllegalArgumentException("Illegal Argument");
		Random random = new Random();

        int half1 = 0;
        int half2;
        if (this.size() % 2 == 0){
			half2 = this.size() / 2;
		}
        else {
			half2 = (this.size() / 2) + 1;
		}
		int half1Max = half2;

        ArrayList<Card> deckHalf1 = new ArrayList<Card>();
        for (int i = 0; i < half1Max; i++){
			deckHalf1.add(this.cards.get(i));
		}
        ArrayList<Card> deckHalf2 = new ArrayList<Card>();
        for (int i = half2; i < this.size(); i++){
			deckHalf2.add(this.cards.get(i));
		}

		ArrayList<Card> midPile = new ArrayList<Card>();

		while (true){
			for (int i = 0; i < random.nextInt(max) + 1; i++){
				midPile.add(deckHalf1.remove(0));
				if (deckHalf1.size() == 0){
					midPile.addAll(deckHalf2);
					this.cards = midPile;
					return;
				}
			}
			for (int i = 0; i < random.nextInt(max) + 1; i++){
				midPile.add(deckHalf2.remove(0));
				if (deckHalf2.size() == 0){
					midPile.addAll(deckHalf1);
					this.cards = midPile;
					return;
				}
			}
		}
	}

	// 3.2 - Simulating a simple card game 
	public ArrayList<ArrayList<Card>> deal(int p, int c) {
		if (p < 0 || c < 0 || c * p > this.size())
			throw new IllegalArgumentException("Illegal Argument");

		ArrayList<ArrayList<Card>> allDeals = new ArrayList<ArrayList<Card>>();
		for (int i = 0; i < p; i++) {
            allDeals.add(new ArrayList<>());
		}

		int count = 0;
		for (int i = 0; i < c * p; i++) {
			if (this.size() > 0){
				allDeals.get(count).add(cards.remove(this.size()-1));
				count++;
				if (count >= p)
					count = 0;
			}
		}
		return allDeals; 
	}
	//public static ArrayList<Card> findBestRun(ArrayList<Card> hand) {
	// 	// Implement me!
 //
	// 	if (hand == null || hand.contains(null)) {
	// 		throw new IllegalArgumentException("Invalid hand provided: " + hand);
	// 	}
 //
	// 	ArrayList<Card> bestRun = new ArrayList<Card>();
	// 	ArrayList<ArrayList<Card>> suitArray = getSuitArray(hand);
// 	// 	for (ArrayList<Card> hand1 : suitArray){
// 	// 		for ArrayList<Card> hand2 : suitArray{
// 	// 			ArrayList<Card> currentRun = compareRuns(hand1, hand2);
// 	// 			bestRun = compareRuns(currentRun, bestRun);
//  //
// 	// 		}
// 	// 	}


// 	 	return null; // placeholder
// 	 }
//  //
// 	// private static ArrayList<ArrayList<Card>> getSuitArray(ArrayList<Card> hand){
// 	// 	ArrayList<ArrayList<Card>> suitArray = new ArrayList<ArrayList<Card>>();
// 	// 	for (int i = 0; i < 4; i++) {
//  //            suitArray.add(new ArrayList<>());
// 	// 	}
// 	// 	for (Card card : hand){
// 	// 		if (card.getSuit() == 0)
// 	// 			suitArray.get(0).add(card);
// 	// 		else if (card.getSuit() == 1)
// 	// 			suitArray.get(1).add(card);
// 	// 		else if (card.getSuit() == 2)
// 	// 			suitArray.get(2).add(card);
// 	// 		else if (card.getSuit() == 3)
// 	// 			suitArray.get(3).add(card);
// 	// 	}
// 	// 	return suitArray;
// 	// }
// 	/**
// 	 * Given two runs, return the better one. The measure of "better" should be as described
// 	 * in the instructions.
// 	 * @param	first	a run
// 	 * @param	second	another run
// 	 * @return	the better run between first and second.
// 	 */
// 	private static ArrayList<Card> compareRuns(ArrayList<Card> first, ArrayList<Card> second) {
// 		// Implement me!
// 		return null; // placeholder
// 	}

// 	public static void simpleGame(int p, int c) {
// 		// This function is mostly implemented for you. Complete the implementation!

// 		Pack pack = Pack.fromStandard(); // Create a standard deck
// 		System.out.println("Playing a simple game with " + p + " players and " + c + " cards per player!");
// 		for (int i = 0; i < SIMPLE_GAME_N_SHUFFLES; i++) {
// 			pack.dovetailShuffle(SIMPLE_GAME_SHUFFLE_MAX); // Shuffle the deck
// 		}
// 		ArrayList<ArrayList<Card>> hands = pack.deal(p, c); // Deal the cards
// 		ArrayList<Card> veryBestRun = new ArrayList<Card>(); // The best run from the players we've seen so far - starts out as empty (so that any valid run is better than this)
// 		int winner = 0; // Index of the player with the best run we've seen so far - starts out as the first player
// 		// This means that if no one has a run better than the empty run, the first player wins by default.
// 		for (int i = 0; i < hands.size(); i++) {
// 			ArrayList<Card> currentBestRun = Pack.findBestRun(hands.get(i)); // Get this player's best run
// 			System.out.println("Player #" + (i + 1) + "'s best run is: " + currentBestRun);
// 			// What needs to happen here?
// 		}
// 		System.out.println("Player #" + (winner + 1) + " wins!");
// 	}
}
