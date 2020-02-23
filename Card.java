package poker;

public class Card {
	
	int number;
	int suit;
	int newNum;
	public Card(int number, int suit) {
		this.number = number;
		this.suit = suit;
		
	}
	public int getNum() {
		return number;
	}

	public void setNum(int newNum) {
		this.number = newNum;
	}
	
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

}
