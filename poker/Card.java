package poker;

public class Card {
	
	//Setting up card class that will be used throughout
	int number;
	int suit;
	
	public Card(int number, int suit) {

		this.number = number;
		this.suit = suit;
		
	}
	//Setting a null card if necessary
	public static Card setZero() {
		Card zero = new Card(0,0);
		return zero;
	}
	
	//Method to return numerical hand values for tiebreakers
	public static int handVals(Card[] Hand) {
		Card high = new Card(0,0);
		int ace = 14;
		int sum = 0;
		
		//Cycling through cards
		for (int i=0;i<5;i++) {
			if ((Hand[i].getNum() > high.getNum() || (Hand[i].getNum() == 1)) && (high.getNum() != 1)) {
				high.setNum(Hand[i].getNum());
				high.setSuit(Hand[i].getSuit());
			}
			
			//Ave has the highest numerical value but is defaulted to 1
			if (Hand[i].getNum() == 1) {
				sum+= ace; 
			}
			else 
				sum += Hand[i].getNum();
		}
	//	System.out.println("Your highest card is a(n) " + high);
		return sum;
	}
	//Getter of number value for Card objects
	public int getNum() {
		return number;
	}
	//Getter of suit number for Card objects
	public int getSuit() {
		return suit;
	}
	//Setter of number value for Card objects
	public void setNum(int newNum) {
		this.number=newNum;
	}
	//Setter of suit number for Card objects
	public void setSuit(int newSuit) {
		this.suit = newSuit;
	}
	
	//Checks for pair, 2pair, 3 of a Kind, full house, and four of a kind
	public static int pair(Card[] Hand) {	
		
		int parry = 0;
		int hold = 0;
		int hold2 = 0;
		int kind = 1;
		int kind2 = 1;
		
		//Nested for loops for gathering every combination of cards
		for (int i = 0; i < 4; i++) {
			
			//Checking if pair ever formed on second loop through
			if (hold != 0 && kind < 2) {
				kind = 2;
				parry = 1;
				}
			
			//Checking if a second pair ever formed
			if (hold2 != 0 && kind2 < 2)
				kind2 = 2;
			
			for (int j = 1 + i; j < 5; j++) {
				
				//Card can't check itself
				if (j == i) {
					j++;
				}
//				System.out.println(Hand[i].getNum() + " " +  Hand[j].getNum() + " " + kind + " " + kind2); 
				
				//Logic for checking for pairs
					if (Hand[i].getNum() == Hand[j].getNum() && Hand[i].getNum() == hold && Hand[i].getNum() != 0) {
						kind++;
				}
					if (Hand[i].getNum() == Hand[j].getNum() && Hand[i].getNum() == hold2  && Hand[i].getNum() != 0) {
						kind2++;
				}
					if (Hand[i].getNum() == Hand[j].getNum() && Hand[i].getNum() != hold && hold2 == 0 && hold != 0  && Hand[i].getNum() != 0) {
						parry++;
						hold2 = Hand[i].getNum();
				}
					if (Hand[i].getNum() == Hand[j].getNum() && hold == 0  && Hand[i].getNum() != 0) {
						hold = Hand[i].getNum();
//						kind++;
//						parry++;
				}
			}
		}
//		System.out.println(kind + " " + kind2);
		
		//Return value cases for each type of check
		if (kind >= 4 || kind2 >= 4) {
			return 5000;
		}
		if ((kind == 2 && kind2 == 3) || (kind == 3 && kind2 == 2)) {
		
			return 4000;
		}
		if (kind == 3) {
			return 2000;
		}
		if (parry == 2) {
			return 500;
		}
		if (kind == 2) {
			return 250;
		}
		else return 0;
	}
	
	//Method for checking for a flush with O(1) efficiency
	public static int flush(Card[] Hand) {
				if (Hand[0].getSuit() == Hand[1].getSuit() && Hand[0].getSuit() == Hand[2].getSuit() 
				&& Hand[0].getSuit() == Hand[3].getSuit() && Hand[0].getSuit() == Hand[4].getSuit() && Hand[0].getSuit() != 0) {
				
					return 3000;
		}
			return 0;
	}
	
	//Sorting method for straight check
	public static void sort(Card[] Hand) {

		int hold;
		//Formats Cards into the array least to greatest
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 4; j++) {
				if ((Hand[i].getNum() > Hand[j].getNum()) && i != j) {
					hold = Hand[i].getNum();
					Hand[i].setNum(Hand[j].getNum());
					Hand[j].setNum(hold);
				}
			}
		}
	}

	//Checking for straight method
	public static int straight(Card [] Hand){

		int count = 1;
		int t = 0;
		
		//Loops that run through the Card array and increments if conditions are met
		for(int i = 4; i >= 1; i--){
			for(int j = i-1; j >= 0; j--){
				if((Hand[i].getNum() == 0) || (Hand[j].getNum() == 0)){
					continue;
				}
				 if((Hand[i].getNum() - 1) == (Hand[j].getNum())) {
					  count++;
				 }
					}
				}
		
		//Returning value if straight is true
		if (count == 5) {
//			System.out.println("You have a straight.");
			return 2500;
		}
		return 0;
	}
 
	//Method for printing the Card object
	public String toString(){
		String s = "Spades";
		if (suit == 0)
			s = "no suit";
		if (suit == 1)
			s = "Clubs";
		else if (suit == 2)
			s = "Diamonds";
		else if (suit == 3)
			s = "Hearts";
		else;
		
		if (number == 0)
			return "Empty Card with " + s;
		else if (number == 1)
			return "Ace of " + s;
		else if (number == 13)
			return "King of " + s;
		else if (number == 12)
			return "Queen of " + s;
		else if (number == 11)
			return "Jack of " + s;
		else
			return number + " of " + s; 
	}

	public static String printHand(Card[] Hand){
		String s = "";
		for(int i=0; i<Hand.length; i++){
			
			if(Hand[i] != null) {
				s+= Hand[i];
				if(i != Hand.length && Hand[i+1] == null)
					break;
				s+= ", ";
			}
		}
		return s;
	}
}
