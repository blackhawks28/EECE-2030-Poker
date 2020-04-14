package poker;

import java.util.Scanner;

//Main Method Class
public class pokerDriver {

	static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Driver Program to test objects and methods created in other classes
		System.out.println("Welcome to the Poker Hand Reader! \nTo use this program follow the prompts showm. "
				+ "\nCards are inputted as follows, \"kh\" for King of Hearts, \"10s\" for 10 of spades, \"ad\" For Ace of Diamonds,"
				+ " and so on. \nType \"fold\" at any time to restart the hand or \"Close\" to stop the program. Enjoy!");
		poker();
	
//		Card[] test = new Card[7];
//		test[0] = new Card(7,1);
//		test[1] = new Card(3,3);
//		test[2] = new Card(4,2);
//		Card hold = new Card(test[0]);
//		Card hold2 = new Card(test[1]);
//		Card hold3= new Card(test[2]);
//		Card[] yo = new Card[7];
//		yo[0] = hold;
//		yo[1] = hold2;
//		yo[2] = hold3;
//		Card.sort(yo);
//		System.out.println(Card.printHand(yo));
//		System.out.println(Card.printHand(test));
		
//		Card[] hold = pre();
//		Card[] user = new Card[7];
//		user[0] = hold[0];
//		user[1] = hold[1]; 
//		
//		Card[] Flop = new Card[3];
//		Flop = flop();
//		user[2] = Flop[0]; 
//		user[3] = Flop[1]; 
//		user[4] = Flop[2];
//	
//		System.out.println("The cards inputted are:\n" + Card.printHand(user));
//		handValue.bestHand(user);
//		System.out.println("The cards inputted are:\n" + Card.printHand(user));
//		
//		user[5] = turn();
//		
//		System.out.println("The cards inputted are:\n" + Card.printHand(user));
//		handValue.bestHand(user);
//		System.out.println("The cards inputted are:\n" + Card.printHand(user));
//		
//		user[6] = river();
//	
//		System.out.println("The cards inputted are:\n" + Card.printHand(user));
//		handValue.bestHand(user);
//		System.out.println("The cards inputted are:\n" + Card.printHand(user));
		//feature.combo();
	}
		
	public static void poker() {
			
			System.out.println();
			Card[] Hand = new Card[7];
		
			Hand = pre();
			System.out.println("The cards inputted are:\n" + Card.printHand(Hand));
			
			Card[] Flop = new Card[3];
			Flop = flop();
			Hand[2] = Flop[0]; 
			Hand[3] = Flop[1]; 
			Hand[4] = Flop[2];
			
			feature.setUserNum(handValue.bestHand(Hand));
			handValue.outcome(feature.getUserNum());
			System.out.println("You have a hand value of: " + feature.getUserNum());
			System.out.println("The cards inputted are:\n" + Card.printHand(Hand));
			System.out.println("The amount of starting hands that beat yours: " + feature.combo());
			
			Hand[5] = turn();
			feature.setUserNum(handValue.bestHand(Hand));
//			System.out.println(Card.printHand(feature.getTable()));
			handValue.outcome(feature.getUserNum());
			System.out.println("You have a hand value of: " + feature.getUserNum());
			System.out.println("The cards inputted are:\n" + Card.printHand(Hand));
//			System.out.println(Card.printHand(feature.getTable()));
			System.out.println("The amount of starting hands that beat yours: " + feature.combo());
//			System.out.println(Card.printHand(feature.getTable()));
			Hand[6] = river();
			feature.setUserNum(handValue.bestHand(Hand));
			handValue.outcome(feature.getUserNum());
			System.out.println("You have a hand value of: " + feature.getUserNum());
			System.out.println("The cards inputted are:\n" + Card.printHand(Hand));
//			System.out.println(Card.printHand(feature.getTable()));
			System.out.println("The number of starting hands that beat yours: " + (feature.combo()));
//			System.out.println(Card.printHand(feature.getTable()));
			
			System.out.println();
			
			
			feature.resetTable();
			feature.resetUserNum();
			feature.restUser();
			
			poker();
	}
	
	public static int inputCheck(String input) {
		
		int n = 0;
		
		if (input.compareTo("a") == 0)
			n = 1;
		if (input.compareTo("2") == 0)
			n = 2;
		if (input.compareTo("3") == 0)
			n = 3;
		if (input.compareTo("4") == 0)
			n = 4;
		if (input.compareTo("5") == 0)
			n = 5;
		if (input.compareTo("6") == 0)
			n = 6;
		if (input.compareTo("7") == 0)
			n = 7;
		if (input.compareTo("8") == 0)
			n = 8;
		if (input.compareTo("9") == 0)
			n = 9;
		if (input.compareTo("10") == 0)
			n = 10;
		if (input.compareTo("j") == 0)
			n = 11;
		if (input.compareTo("q") == 0)
			n = 12;
		if (input.compareTo("k") == 0)
			n = 13;
		

		if(input.equals("fold")) {
			System.out.println("You've decided to fold.");
			poker();
		}	
		else if (input.equals("close") ||input.equals("Close")) {
			System.out.println("You've decided to close the program.");
			System.exit(0);
		}		
		else if (n ==0) {
			System.out.println("Invalid Card Entered... Restarting");
			poker();
		}
			
		return n;
	}		
	public static int inputCheck2(String input2) {
		int s = 0;
		if (input2.compareTo("c") == 0)
			s = 1;
		if (input2.compareTo("d") == 0)
			s = 2;
		if (input2.compareTo("h") == 0)
			s = 3;
		if (input2.compareTo("s") == 0)
			s = 4;
		
		if(input2.equals("fold")) {
			System.out.println("You've decided to fold.");
			poker();
		}			
		else if(input2.equals("close") ||input2.equals("Close")) {
			System.out.println("You've decided to close the program.");
			System.exit(0);
		}		
		else if (s == 0) {
			System.out.println("Invalid Suit Entered... Restarting");
			poker();
		}
		return s;
	}
	public static Card cardMaker(int n, int s) {
		Card thing = new Card(n,s);
		return thing;
	}
	
	public static Card[] pre() {
		
		Card[] pre = new Card[7];
		String input = "";
		String input2 = "";
		System.out.println("Enter your dealt hand cards. First the Card number/letter, enter, and then the suit for each card.");
		
		input = scnr.nextLine();
		input2 = scnr.nextLine();
		pre[0] = cardMaker(inputCheck(input), inputCheck2(input2));
		
		input = scnr.nextLine();
		input2 = scnr.nextLine();
		pre[1] = cardMaker(inputCheck(input), inputCheck2(input2));
		
		feature.setUser(pre);
		return pre;
	}
	private static Card[] flop() {
		
		Card[] flop = new Card[3];
		String input = "";
		String input2 = "";
		
		System.out.println("Enter the three flop cards.");
		
		input = scnr.nextLine();
		input2 = scnr.nextLine();
		flop[0] = cardMaker(inputCheck(input), inputCheck2(input2));

		input = scnr.nextLine();
		input2 = scnr.nextLine();
		flop[1] = cardMaker(inputCheck(input), inputCheck2(input2));

		input = scnr.nextLine();
		input2 = scnr.nextLine();
		flop[2] = cardMaker(inputCheck(input), inputCheck2(input2));
		
		feature.setFlop(flop);
		return flop;
	}
	private static Card turn() {
		
		Card turn = new Card(0,0);
		String input = "";
		String input2 = "";
		
		System.out.println("Enter the turn card.");
		
		input = scnr.nextLine();
		input2 = scnr.nextLine();
		turn = cardMaker(inputCheck(input), inputCheck2(input2));
		
		feature.setTurn(turn);
		return turn;
			
	}
	private static Card river() {
		
		Card river = new Card(0,0);
		String input = "";
		String input2 = "";
		
		System.out.println("Enter the river card.");
		
		input = scnr.nextLine();
		input2 = scnr.nextLine();
		river = cardMaker(inputCheck(input), inputCheck2(input2));
		
		feature.setRiver(river);
		return river;
			
	}
}
		
