package poker;

public class feature {
	
	private static int userNum;
	private static Card[] table = new Card[7];
	private static Card[] user;
	private static int suit;
	private static int value;
	
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
	//Ace of Diamonds | 3 of Hearts | 3 of Clubs | 3 of Spades | 4 of Hearts | 7 of Diamonds | Jack of Clubs
	public static int combo() {
		int count = 0;
		int hold  = 0;
		int total = 0;
		
		Card[] d = newDeck();
		for(int i = 0; i < 51; i++)
		{
			for(int j = i + 1; j < 52; j++)
			{
			//	System.out.println(Card.printHand(getTable()));
			//	test = getTable();
				Card[] test = new Card[7];
				test[0] = d[i];
				test[1] = d[j];
				test[2] = getTable()[0];
				test[3] = getTable()[1];
				test[4] = getTable()[2];
				test[5] = getTable()[3];
				test[6] = getTable()[4];
				
//				System.out.println(Card.printHand(getTable()));
				hold = handValue.bestHand(test);
				
				if (test[5] == test[0] || test[5] == test[1] || test[5] == test[2] || test[5] == test[3] || test[5] == test[4] || test[6] == test[0] || 
						test[6] == test[1] || test[6] == test[2] || test[6] == test[3] || 
						test[6] == test[4] || test[5] == user[0] || test[5] == user[1] ||
						test[6] == user[0] || test[6] == user[1])
				{
					hold = 0;
				}
				
//				System.out.println(hold);
				if (hold > getUserNum()) {
					count++;
				}
//				test[0] = d[i];
//				test[1] = d[j];
//				System.out.println(test[0] + " | " + test[1]);
				total++;
			}
		}
		
		return count;
	}
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
	

	
	
	
}
