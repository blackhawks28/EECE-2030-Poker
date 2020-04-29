package poker;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Poker_GUI extends JFrame {
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	private static Poker_GUI frame = new Poker_GUI();
	private JPanel contentPane;
	private static String number= "";
	private static String suit="";
	
	static Scanner scnr = new Scanner(System.in);  //copied in
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					System.out.println("Welcome to the Poker Hand Reader! \nTo use this program follow the prompts showm. "
							+ "\nCards are inputted as follows, \"kh\" for King of Hearts, \"10s\" for 10 of spades, \"ad\" For Ace of Diamonds,"
							+ " and so on. \nType \"fold\" at any time to restart the hand or \"Close\" to stop the program. Enjoy!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); //start copy
		//Driver Program to test objects and methods created in other classes
		poker(); //end copy
	}

	/**
	 * Create the frame.
	 */
	public Poker_GUI() { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea Console2 = new JTextArea();
		Console2.setColumns(1);
		Console2.setRows(15);
		Console2.setEditable(false);
		Console2.setBounds(10, 11, 988, 321);
		contentPane.add(Console2);
		PrintStream printStream = new PrintStream(new TextAreaOutputStream(Console2));
		System.setOut(printStream);
		System.setErr(printStream);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(778, 499, 89, 23);
		contentPane.add(btnClear);
		
		JLabel lblNewLabel = new JLabel("Value");
		lblNewLabel.setBounds(170, 361, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Suit");
		lblNewLabel_1.setBounds(476, 361, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAce = new JButton("Ace");
		btnAce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				number = Console2.getText();
				//Console2.setText(number);
				System.out.println("a");
				
				
				
				
			}
		});
		btnAce.setBounds(90, 386, 89, 23);
		contentPane.add(btnAce);
		
		JButton btnTwo = new JButton("Two (2)");
		btnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				number = "2";
			}
		});
		btnTwo.setBounds(90, 420, 89, 23);
		contentPane.add(btnTwo);
		
		JButton btnThree = new JButton("Three (3)");
		btnThree.setBounds(90, 454, 89, 23);
		contentPane.add(btnThree);
		
		JButton btnFour = new JButton("Four (4)");
		btnFour.setBounds(90, 488, 89, 23);
		contentPane.add(btnFour);
		
		JButton btnFive = new JButton("Five (5)");
		btnFive.setBounds(90, 522, 89, 23);
		contentPane.add(btnFive);
		
		JButton btnSix = new JButton("Six (6)");
		btnSix.setBounds(90, 556, 89, 23);
		contentPane.add(btnSix);
		
		JButton btnSeven = new JButton("Seven (7)");
		btnSeven.setBounds(90, 590, 89, 23);
		contentPane.add(btnSeven);
		
		JButton btnEight = new JButton("Eight (8)");
		btnEight.setBounds(189, 386, 89, 23);
		contentPane.add(btnEight);
		
		JButton btnNine = new JButton("Nine (9)");
		btnNine.setBounds(189, 420, 89, 23);
		contentPane.add(btnNine);
		
		JButton btnTen = new JButton("Ten (10)");
		btnTen.setBounds(189, 454, 89, 23);
		contentPane.add(btnTen);
		
		JButton btnJack = new JButton("Jack");
		btnJack.setBounds(189, 488, 89, 23);
		contentPane.add(btnJack);
		
		JButton btnQueen = new JButton("Queen");
		btnQueen.setBounds(189, 522, 89, 23);
		contentPane.add(btnQueen);
		
		JButton btnKing = new JButton("King");
		btnKing.setBounds(189, 556, 89, 23);
		contentPane.add(btnKing);
		
		JButton btnNewButton = new JButton("Clubs");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suit = Console2.getText();
				System.out.println("c");
			}
		});
		btnNewButton.setBounds(444, 386, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnDiamonds = new JButton("Diamonds");
		btnDiamonds.setBounds(444, 420, 89, 23);
		contentPane.add(btnDiamonds);
		
		JButton btnHearts = new JButton("Hearts");
		btnHearts.setBounds(444, 454, 89, 23);
		contentPane.add(btnHearts);
		
		JButton btnSpades = new JButton("Spades");
		btnSpades.setBounds(444, 488, 89, 23);
		contentPane.add(btnSpades);
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
		String input = number;
		String input2 = suit;
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