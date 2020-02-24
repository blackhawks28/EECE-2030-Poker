package poker;


public class pokerDriver {

	public static void main(String[] args) {
		
		
		Card[] highC = new Card[5];
		highC[0] = new Card(3,4);
		highC[1] = new Card(5,1);
		highC[2] = new Card(4,0);
		highC[3] = new Card(8,1);
		highC[4] = new Card(9,1);
		System.out.println("Your hand has a value of: " + handValue.test(highC));
		
		Card[] pair = new Card[5];
		pair[0] = new Card(1,4);
		pair[1] = new Card(3,1);
		pair[2] = new Card(4,4);
		pair[3] = new Card(4,1);
		pair[4] = new Card(2,1);
		System.out.println("Your hand has a value of: " + handValue.test(pair));
		
		Card[] tpair = new Card[5];
		tpair[0] = new Card(12,4);
		tpair[1] = new Card(12,1);
		tpair[2] = new Card(3,2);
		tpair[3] = new Card(4,1);
		tpair[4] = new Card(4,1);
		System.out.println("Your hand has a value of: " + handValue.test(tpair));
		
		Card[] tkind = new Card[5];
		tkind[0] = new Card(4,4);
		tkind[1] = new Card(1,1);
		tkind[2] = new Card(3,3);
		tkind[3] = new Card(4,1);
		tkind[4] = new Card(4,1);
		System.out.println("Your hand has a value of: " + handValue.test(tkind));
		
		Card[] str = new Card[7];
		str[0] = new Card(1,4);
		str[1] = new Card(2,1);
		str[2] = new Card(3,2);
		str[3] = new Card(4,1);
		str[4] = new Card(5,1);
		System.out.println("Your hand has a value of: " + handValue.test(str));
		
		System.out.println();
		
		Card[] fhouse = new Card[5];
		fhouse[0] = new Card(4,4);
		fhouse[1] = new Card(3,1);
		fhouse[2] = new Card(3,2);
		fhouse[3] = new Card(4,1);
		fhouse[4] = new Card(3,1);
		System.out.println("Your hand has a value of: " + handValue.test(fhouse));
		
		Card[] stFl = new Card[5];
		stFl[0] = new Card(5,1);
		stFl[1] = new Card(6,1);
		stFl[2] = new Card(8,1);
		stFl[3] = new Card(7,1);
		stFl[4] = new Card(9,1);
		System.out.println("Your hand has a value of: " + handValue.test(stFl));
	}
}