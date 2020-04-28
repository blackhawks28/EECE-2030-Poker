package poker;

public class feature {
	
	private static int userNum;
	private static Card[] table = new Card[5];
	private static Card[] user;
	private static int suit;
	private static int value;
	
	//Creating the 52 deck of cards
	public static Card[] newDeck() {
		Card[] deck = new Card[52];
		int i = 0;
		for(suit = 1; suit<=4; suit++) {
			for(value = 1; value<=13; value++) {
				deck[i] = new Card(value,suit);
				i++;
				}
		}
		return deck;
	}

	//Feature that tells you the amount of starting hands that beat your starting hand
	public static int combo() {
		int count = 0;
		int hold  = 0;
		int total = 0;
		
		Card[] d = newDeck();
		
		//Nested for loop that goes through every combination of two cards
		for(int i = 0; i < 51; i++)
		{
			for(int j = i + 1; j < 52; j++)
			{
			
			//Creating two new cards to pair with the ones on the table 
				Card[] test = new Card[7];
				test[0] = d[i];
				test[1] = d[j];
				test[2] = getTable()[0];
				test[3] = getTable()[1];
				test[4] = getTable()[2];
				test[5] = getTable()[3];
				test[6] = getTable()[4];
				
			//Getting the values of the generated hands
				hold = handValue.bestHand(test);
				
			//Foregoing any repeats of cards with themselves
				if (Card.compareTo(test[0],test[2]) || Card.compareTo(test[0],test[3]) || Card.compareTo(test[0],test[4]) || Card.compareTo(test[0],test[5]) || Card.compareTo(test[0],test[6]) ||
						Card.compareTo(test[1],test[2]) || Card.compareTo(test[1],test[3]) || Card.compareTo(test[1],test[4]) || Card.compareTo(test[1],test[5]) || Card.compareTo(test[1],test[6])
						|| Card.compareTo(test[0],getUser()[0]) || Card.compareTo(test[0],getUser()[1]) || Card.compareTo(test[0],getUser()[0]) || Card.compareTo(test[1],getUser()[1]))	{
					hold = 0;
				}
			//Testing if the generated hands are better than the user's
				if (hold > getUserNum()) {
					count++;
				}
//				if (hold != 0) {
//					total++;
//				}
				
			}
		}
		return count;
		
	}
	
	//Getters, Setters, and Resetters
	public static void setFlop(Card[] flop) {
		table[0] = flop[0];
		table[1] = flop[1];
		table[2] = flop[2];
	}
	public static void setTurn(Card turn) {
		table[3] = turn;
	}
	public static void setRiver(Card river) {
		table[4] = river;
	}
	public static Card[] getTable() {
		return table;
	}
	public static void resetTable() { 
		table[0] = Card.setZero();
		table[1] = Card.setZero();
		table[2] = Card.setZero();
		table[3] = Card.setZero();
		table[4] = Card.setZero();
	}
	public static void restUser() { 
		user[0] = Card.setZero();
		user[1] = Card.setZero();
	}
	public static void setUser(Card[] pre) {
		user = pre;
	}
	public static Card[] getUser() {
		return user;
	}
	public static void setUserNum(int u) {
		userNum = u;
	}
	public static int getUserNum() {
		return userNum;
	}
	public static void resetUserNum() { 
		userNum = 0;
	}
}