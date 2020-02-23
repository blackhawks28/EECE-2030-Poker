package poker;

public class handValue {
	public static int bestHand(Card[] Hand) {
		Card[] best = new Card[5];
		Card[] empty = new Card [5];
		Card[] hold = empty;
		
		for(int i=0; i<3;i++) {	
			if (hold != null && best != null) {
				if (pokerDriver.test(hold) > pokerDriver.test(best))
					best = hold;
			}
			int index = 1;
			hold = empty;
			hold[0] = Hand[i];
			
			for(int j=i+1; j<i+5;j++) {
				hold[index] = Hand[j];
				System.out.println(hold[0].getNum()+ " " + hold[index].getNum());
				index++;
			}
		}
		
		return pokerDriver.test(best);
	}

}
