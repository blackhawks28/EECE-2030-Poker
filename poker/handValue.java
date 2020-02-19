package poker;

public class handValue {
	public static Card[] Hand = new Card[7];
	
	public int pair(Card[] Hand) {	
		for (int i = 0; i<7; i++) {
			for (int j = 1; j<7; j++) {
				if (j == i) j++;
					if (Hand[i].getNum() == Hand[j].getNum) {
					
				}
			}
		}
		return 10;
	}
}
