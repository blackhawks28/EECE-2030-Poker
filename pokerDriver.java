package poker;


public class pokerDriver {

	public static void main(String[] args) {
		
		
		Card[] highC = new Card[5];
		highC[0] = new Card(3,4);
		highC[1] = new Card(5,1);
		highC[2] = new Card(4,0);
		highC[3] = new Card(8,1);
		highC[4] = new Card(9,1);
		System.out.println(handValue.test(highC));
		
		Card[] pair = new Card[5];
		pair[0] = new Card(1,4);
		pair[1] = new Card(3,1);
		pair[2] = new Card(4,0);
		pair[3] = new Card(4,1);
		pair[4] = new Card(2,1);
		System.out.println(handValue.test(pair));
		
		Card[] tpair = new Card[5];
		tpair[0] = new Card(12,4);
		tpair[1] = new Card(12,1);
		tpair[2] = new Card(3,0);
		tpair[3] = new Card(4,1);
		tpair[4] = new Card(4,1);
		System.out.println(handValue.test(tpair));
		
		Card[] tkind = new Card[5];
		tkind[0] = new Card(4,4);
		tkind[1] = new Card(1,1);
		tkind[2] = new Card(3,0);
		tkind[3] = new Card(4,1);
		tkind[4] = new Card(4,1);
		System.out.println(handValue.test(tkind));
		
		Card[] str = new Card[7];
		str[0] = new Card(1,4);
		str[1] = new Card(2,1);
		str[2] = new Card(3,0);
		str[3] = new Card(4,1);
		str[4] = new Card(5,1);
		System.out.println(handValue.test(str));
		
		Card[] fhouse = new Card[5];
		fhouse[0] = new Card(4,4);
		fhouse[1] = new Card(3,1);
		fhouse[2] = new Card(3,0);
		fhouse[3] = new Card(4,1);
		fhouse[4] = new Card(4,1);
		System.out.println(handValue.test(fhouse));
	}
}