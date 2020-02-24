package poker;

public class handValue {
	public static void bestHand(Card[] Hand) {
		
		
		
	}
	public static int test(Card[] Hand) {
		int val = 0;
		if (Hand != null)
			val =  Card.pair(Hand) + Card.flush(Hand) + Card.straight(Hand) + Card.handVals(Hand);
			if (val == 0) {
				System.out.println("Invalid or empty input");
				return val;
			}
			if (val > 0  && val < 250) {
				System.out.println("You merely have card high...");
				return val;
			}
			if (val >= 250  && val < 500) {
				System.out.println("You have a pair.");
				return val;
			}
			if (val >= 500  && val < 2000) {
				System.out.println("You have a two pair!");
				return val;
			}
			if (val >= 2000  && val < 2500) {
				System.out.println("You have a three of a kind!");
				return val;
			}
			
			if (val >= 2500  && val < 3000) {
			System.out.println("You have a straight!");
				return val;
			}
			if (val >= 3000   && val < 4000) {
				System.out.println("You have a flush!");		
				return val;
			}
			if (val >= 4000  && val < 5000) {
				System.out.println("You have a full house!");
				return val;
			}
			if (val >= 5000  && val < 5500) {
				System.out.println("You have a four of a kind!");
				return val;
			}
			if (val >= 5500) {
				System.out.println("You have a straight flush!");
				return val;
			}
			else
				return 0;
		}
}
