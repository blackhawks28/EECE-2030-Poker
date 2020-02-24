package poker;


public class pokerDriver {

	public static void main(String[] args) {
		Card [] test = new Card[7];
		Card [] hand = new Card[2];
		test[0] = new Card(2,1);
		test[1] = new Card(11,2);
		test[2] = new Card(9,1);
		test[3] = new Card(4,1);
		test[4] = new Card(10,2);
		test[5] = new Card(12,3);
		test[6] = new Card(13,4);
		System.out.println(handValue.pair(test));
		handValue.sort(test);
		System.out.println(handValue.straight(test));


	}

}
