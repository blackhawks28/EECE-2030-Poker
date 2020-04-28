package poker;

public class deck {
	
	public static Card[] deck = new Card[52];
	
	private static int suit;
	private static int value;
	
	
	public static void newDeck() {
		int i = 0;
		
		for(suit = 1; suit<=4; suit++) {
			for(value = 1; value<=13; value++) {
				deck[i] = new Card(value,suit);
				i++;
			}
		}
	}
}
