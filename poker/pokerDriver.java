package poker;

import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

//Main Method Class
public class pokerDriver {

	//For formatting decimals
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	//For reading user inputs
	static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Driver Program to test objects and methods created in other classes
		System.out.println("Welcome to the Poker Hand Reader! \nTo use this program follow the prompts showm. "
				+ "\nCards are inputted as follows, \"kh\" for King of Hearts, \"10s\" for 10 of spades, \"ad\" For Ace of Diamonds,"
				+ " and so on. \nType \"fold\" at any time to restart the hand or \"Close\" to stop the program. Enjoy!");
		poker();
	
	}
		
	public static void poker() {
			
		//Recursive method that runs the whole program
		
			System.out.println();
			Card[] Hand = new Card[7];
		
		//Calling to method that gathers preflop information
			Card[] hold = pre();
			
		//Using copy constructor that allows the display of the preflop cards
			Card h0 = new Card(hold[0]);
			Card h1 = new Card(hold[1]);
			
			
			Hand[0] = h0;
			Hand[1] = h1;
			
		//Repeating back what the cards are
			System.out.println("Your cards are: " + Card.printHand(feature.getUser()));
			
		//Starting the flop method 
			Card[] Flop = new Card[3];
			Flop = flop();
			Hand[2] = Flop[0]; 
			Hand[3] = Flop[1]; 
			Hand[4] = Flop[2];
			
		//Setting flop cards so they can be "universally" accessed
			feature.setUserNum(handValue.bestHand(Hand));
			
		//Calling to method that tells the user what they have
			handValue.outcome(feature.getUserNum());
			System.out.println();
			
		//Repeating back what the cards are
			System.out.println("Your cards: " + Card.printHand(feature.getUser()) + "\nTable Cards: " + Card.printHand(feature.getTable()) + "\n");
			
		//Gathering and printing combination stats
			double percent = (feature.combo()/1093.0)*100;
			System.out.println("The percent of starting hands that beat yours: " + df2.format(percent) + "%");
		
		//Going to the turn and river methods which do the same thing
			Hand[5] = turn();
			feature.setUserNum(handValue.bestHand(Hand));
			handValue.outcome(feature.getUserNum());
			System.out.println();
			System.out.println("Your cards: " + Card.printHand(feature.getUser()) + "\nTable Cards: " + Card.printHand(feature.getTable()) + "\n");
			percent = (feature.combo()/1047.0)*100;
			System.out.println("The percent of starting hands that beat yours: " + df2.format(percent) + "%");
			Hand[6] = river();
			feature.setUserNum(handValue.bestHand(Hand));
			handValue.outcome(feature.getUserNum());
			System.out.println();
			System.out.println("Your cards: " + Card.printHand(feature.getUser()) + "\nTable Cards: " + Card.printHand(feature.getTable()) + "\n");
			percent = (feature.combo()/1001.0)*100;
			System.out.println("The percent of starting hands that beat yours: " + df2.format(percent) + "%");
			
			System.out.println();
			
			
			feature.resetTable();
			feature.resetUserNum();
			feature.restUser();
			
			poker();
	}
	//Method that takes the users first input and converts it to the format for a Card (ex: 'k' = king)
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
		
	//Failsafes for incorrect/unique inputs
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
	//Method that takes the users second input and converts it to the format for a Card (ex: 's' = spade)
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
		
	//Failsafes for incorrect/unique inputs
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
	
	//Converts inputs to the "Card" datatype
	public static Card cardMaker(int n, int s) {
		Card thing = new Card(n,s);
		return thing;
	}
	
	//Preflop method
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
	//flop method
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
	//turn method
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
	//river method
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
		
