package poker;


public class pokerDriver {

	public static void main(String[] args) {
		Card[] test = new Card[7];
		test[0] = new Card(2,2);
		test[1] = new Card(2,2);
		test[2] = new Card(5,2);
		test[3] = new Card(12,1);
		test[4] = new Card(1,3);
		System.out.println(Card.pair(test));
		System.out.println(handValue.bestHand(test));
	}


	public static int test(Card[] Hand) {
	if (Hand != null)
		return Card.pair(Hand) + Card.flush(Hand) + Card.straight(Hand) + Card.handVals(Hand);
	else
		return 0;
	}
}