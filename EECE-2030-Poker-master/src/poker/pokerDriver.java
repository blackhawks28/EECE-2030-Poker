package poker;

import java.util.Scanner;

public class pokerDriver {

	public static void main(String[] args) {
		poker();
	}
		public static void poker() {
		Scanner scnr = new Scanner(System.in);
		Card[] hand = new Card[7];
		String input = "";
		String input2 = "";
		boolean i = true;
		System.out.println("Enter your first hole card. First the Card number/name, enter, and then the suit.  Also, you can type \"fold\" if you fold.");
		while(i != false) {
			input = scnr.nextLine();
			input2 = scnr.nextLine();
			hand[0] = cardMaker(inputCheck(input), inputCheck2(input2));
			System.out.println("Enter your second hole card.  Also, you can type \"fold\" if you fold.");
			input = scnr.nextLine();
			input2 = scnr.nextLine();
			hand[1] = cardMaker(inputCheck(input), inputCheck2(input2));
			System.out.println("Your cards are " + hand[0] + " " + hand[1] );
			System.out.println("Enter the first flop card.  Also, you can type \"fold\" if you fold.");
			input = scnr.nextLine();
			input2 = scnr.nextLine();
			hand[2] = cardMaker(inputCheck(input), inputCheck2(input2));
			System.out.println("Enter the second flop card.  Also, you can type \"fold\" if you fold.");
			input = scnr.nextLine();
			input2 = scnr.nextLine();
			hand[3] = cardMaker(inputCheck(input), inputCheck2(input2));
			System.out.println("Enter the third flop card.  Also, you can type \"fold\" if you fold.");
			input = scnr.nextLine();
			input2 = scnr.nextLine();
			hand[4] = cardMaker(inputCheck(input), inputCheck2(input2));
			System.out.println("Enter the turn card.  Also, you can type \"fold\" if you fold.");
			input = scnr.nextLine();
			input2 = scnr.nextLine();
			hand[5] = cardMaker(inputCheck(input), inputCheck2(input2));
			System.out.println("Enter the river card.  Also, you can type \"fold\" if you fold.");
			input = scnr.nextLine();
			input2 = scnr.nextLine();
			hand[6] = cardMaker(inputCheck(input), inputCheck2(input2));
			
		}
	}
	

	public static int inputCheck(String input) {
		
		int n = 0;
		
		if (input == "a")
			n = 1;
		if (input == "2")
			n = 2;
		if (input == "3")
			n = 3;
		if (input == "4")
			n = 4;
		if (input == "5")
			n = 5;
		if (input == "6")
			n = 6;
		if (input == "7")
			n = 7;
		if (input == "8")
			n = 8;
		if (input == "9")
			n = 9;
		if (input == "10")
			n = 10;
		if (input == "j")
			n = 11;
		if (input == "q")
			n = 12;
		
		if (input == "k")
			n = 13;
		

		if(!input.equals("fold")) {
		}
		else {
			System.out.println("You've decided to fold.");
			poker();
		}
		
		return n;
	}		
	public static int inputCheck2(String input2) {
		int s = 0;
		if (input2 == "c")
			s = 1;
		if (input2 == "d")
			s = 2;
		if (input2 == "h")
			s = 3;
		if (input2 == "s")
			s = 4;
		return s;
	}
	public static Card cardMaker(int n, int s) {
		Card thing = new Card(n,s);
		return thing;
	}

}
