package poker;

import java.util.Arrays;

 class handValue{
	public static Card[] Hand = new Card[7];

	public static int pair(Card[] Hand) {
		for (int i = 0; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				if (j == i)
					j++;
				if (Hand[i].getNum() == Hand[j].getNum()) {
					return 100;

				}
			}
		}
	 return 10;
	}

	public static void sort(Card[] Hand) {

		int hold;
		for (int i = 0; i < Hand.length; i++) {
			for (int j = i + 1; j < Hand.length; j++) {
				if ((Hand[i].getNum() > Hand[j].getNum()) && i != j) {
					hold = Hand[i].getNum();
					Hand[i].setNum(Hand[j].getNum());
					Hand[j].setNum(hold);
				}
			}
		}
		for (int i = 0; i < Hand.length; i++) {
			System.out.println(Hand[i]);
		}
	}

	public static int straight(Card [] Hand){
		int count = 1;
		int t = 0;

		for(int i = Hand.length-1; i >= 1; i--){
			for(int j = i-1; j >= 0; j--){
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
 }




