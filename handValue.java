package poker;

public class handValue {
	
	public static int test(Card[] Hand) {
		
		//Method that spits back the hierarchy value of your hand
		int best = 0;
		
		if (Hand != null)
			
			//Adding all methods that test for hand values, i.e. pair, straight etc.
			best =  Card.pair(Hand) + Card.flush(Hand) + Card.straight(Hand) + Card.handVals(Hand);
	
			return best;

		}
	
	public static int bestHand(Card[] Hand) {
		
		int best = 0;
		
//		System.out.println(Card.printHand(Hand));
		Card.sort(Hand);
//		System.out.println(Card.printHand(Hand));
		
		Card[] bestHold = new Card[5];
		
		if (Hand[4] != null) 
		{
			Card[] test0 = new Card[5];
				
			test0[0] = Hand[0];
			test0[1] = Hand[1];
			test0[2] = Hand[2];
			test0[3] = Hand[3];
			test0[4] = Hand[4];
			
			best = test(test0);
			bestHold = test0;
			
			if (Hand[5] != null)
			{				
				Card[] test1 = new Card[5];
				test1[0] = Hand[0];
				test1[1] = Hand[1];
				test1[2] = Hand[3];
				test1[3] = Hand[4];
				test1[4] = Hand[5];
				
				if (best <= test(test1)) {
					best = test(test1);
					bestHold = test1;
				}
				
				Card[] test2 = new Card[5];

				test2[0] = Hand[1];
				test2[1] = Hand[2];
				test2[2] = Hand[3];
				test2[3] = Hand[4];
				test2[4] = Hand[5];
				
				
				if (best <= test(test2)) {
					best = test(test2);
					bestHold = test2;
				}
					
				Card[] test3 = new Card[5];
				test3[0] = Hand[0];
				test3[1] = Hand[2];
				test3[2] = Hand[3];
				test3[3] = Hand[4];
				test3[4] = Hand[5];
				
				if (best <= test(test3)) {
					best = test(test3);
					bestHold = test3;
				}
				
				if (Hand[6] != null) 
				{			
					Card[] test4 = new Card[5];
					test4[0] = Hand[0];
					test4[1] = Hand[2];
					test4[2] = Hand[3];
					test4[3] = Hand[5];
					test4[4] = Hand[6];
					
					if (best <= test(test4)) {
						best = test(test4);
						bestHold = test4;
					}
					
					Card[] test5 = new Card[5];
					test5[0] = Hand[0];
					test5[1] = Hand[3];
					test5[2] = Hand[4];
					test5[3] = Hand[5];
					test5[4] = Hand[6];
					
					if (best <= test(test5)) {
						best = test(test5);
						bestHold = test5;
					}
					
					Card[] test6 = new Card[5];
					test6[0] = Hand[0];
					test6[1] = Hand[1];
					test6[2] = Hand[4];
					test6[3] = Hand[5];
					test6[4] = Hand[6];
				
					if (best <= test(test6)) {
						best = test(test6);
						bestHold = test6;
					}
					
					Card[] test7 = new Card[5];
					test7[0] = Hand[1];
					test7[1] = Hand[2];
					test7[2] = Hand[4];
					test7[3] = Hand[5];
					test7[4] = Hand[6];
					
					if (best <= test(test7)) {
						best = test(test7);
						bestHold = test7;
					}
					
					Card[] test8 = new Card[5];
					test8[0] = Hand[1];
					test8[1] = Hand[3];
					test8[2] = Hand[4];
					test8[3] = Hand[5];
					test8[4] = Hand[6];
					
					
					if (best <= test(test8)) {
						best = test(test8);
						bestHold = test8;
					}
					
					Card[] test9 = new Card[5];
					test9[0] = Hand[2];
					test9[1] = Hand[3];
					test9[2] = Hand[4];
					test9[3] = Hand[5];
					test9[4] = Hand[6];
			
					
					if (best <= test(test9)) {
						best = test(test9);
						bestHold = test9;
					}
				}
			}
		}
			
	
	//		System.out.println(Card.printHand(bestHold));
	
			
			//test methods return an int value that can be translated to their respective conditions
				if (best <= 0) {
					System.out.println("Invalid or empty input");
					return best;
				}
				if (best > 0  && best < 250) {
					System.out.println("You merely have card high...");
					return best;
				}
				if (best >= 250  && best < 500) {
					System.out.println("You have a pair.");
					return best;
				}
				if (best >= 500  && best < 2000) {
					System.out.println("You have a two pair!");
					return best;
				}
				if (best >= 2000  && best < 2500) {
					System.out.println("You have a three of a kind!");
					return best;
				}
				
				if (best >= 2500  && best < 3000) {
				System.out.println("You have a straight!");
					return best;
				}
				if (best >= 3000   && best < 4000) {
					System.out.println("You have a flush!");		
					return best;
				}
				if (best >= 4000  && best < 5000) {
					System.out.println("You have a full house!");
					return best;
				}
				if (best >= 5000  && best < 5500) {
					System.out.println("You have a four of a kind!");
					return best;
				}
				if (best >= 5500) {
					System.out.println("You have a straight flush!");
					return best;
				}
			
		
		return best;
	
	}
	
}
