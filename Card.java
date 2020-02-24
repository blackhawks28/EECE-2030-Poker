package poker;

public class Card {
	
	int number;
	int suit;
	
	public Card(int number, int suit) {

		this.number = number;
		this.suit = suit;
		
	}
	public static Card setZero() {
		Card zero = new Card(0,0);
		return zero;
	}
	
	public static int handVals(Card[] Hand) {
		Card high = new Card(0,0);
		int ace = 14;
		int sum = 0;
		for (int i=0;i<5;i++) {
			if ((Hand[i].getNum() > high.getNum() || (Hand[i].getNum() == 1)) && (high.getNum() != 1)) {
				high.setNum(Hand[i].getNum());
				high.setSuit(Hand[i].getSuit());
			}
			if (Hand[i].getNum() == 1) {
				sum+= ace; 
			}
			else 
				sum += Hand[i].getNum();
		}
		System.out.println("Your highest card is a(n) " + high);
		return sum;
	}
	
	public int getNum() {
		return number;
	}
	
	public int getSuit() {
		return suit;
	}

	public void setNum(int newNum) {
		this.number=newNum;
	}
	
	public void setSuit(int newSuit) {
		this.suit = newSuit;
	}
	
	public static int pair(Card[] Hand) {	
		
		int parry = 0;
		int hold = 0;
		int hold2 = 0;
		int kind = 1;
		int kind2 = 1;
		
		for (int i = 0; i < 4; i++) {
			
			if (hold != 0 && kind < 2) {
				kind = 2;
				parry = 1;
				}
			
			if (hold2 != 0 && kind2 < 2)
				kind2 = 2;
			
			for (int j = 1 + i; j<5; j++) {
				
				if (j == i) {
					j++;
				}
//				System.out.println(Hand[i].getNum() + " " +  Hand[j].getNum() + " " + kind + " " + kind2); 
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
	
	public static int flush(Card[] Hand) {
				if (Hand[0].getSuit() == Hand[1].getSuit() && Hand[0].getSuit() == Hand[2].getSuit() 
				&& Hand[0].getSuit() == Hand[3].getSuit() && Hand[0].getSuit() == Hand[4].getSuit() && Hand[0].getSuit() != 0) {
				
					return 3000;
		}
			return 0;
	}
	
	public static void sort(Card[] Hand) {

		int hold;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if ((Hand[i].getNum() > Hand[j].getNum()) && i != j) {
					hold = Hand[i].getNum();
					Hand[i].setNum(Hand[j].getNum());
					Hand[j].setNum(hold);
				}
			}
		}
		for (int i = 0; i < 5; i++) {
//			System.out.println(Hand[i]);
		}
	}

	public static int straight(Card [] Hand){

		int count = 1;
		int t = 0;
		sort(Hand);
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
		if (count == 5) {
//			System.out.println("You have a straight.");
			return 2500;
		}
		return 0;
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
