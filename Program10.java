/**********************************************************************************************
 * Michael Strand
 * CompSci 250 401-805
 * 
 * Program 10
 * 
 * This program is meant to simulate a game of single player poker
 *
 *********************************************************************************************/

import java.util.*;

public class Program10 
{
	//Main method heading
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);

		int[] deck = new int[36];
		int[] hand = new int[4];
		int nextCard = 0;
		int hands = 0;
		int wins = 0;
		int loses = 0;
		int bankRoll = 100;
		int bet = 0;

		//Calling welcome method
		welcome();
		String menuChoice;

		do 
		{
			menuChoice = gameMenu(stdIn);//Calling game menu
			String response = menuChoice;

			if (response.equalsIgnoreCase("y"))
			{
				if (bankRoll > 0)
				{
					hands++;
					
					//Calling getBet user varification
					do
					{
						bet = getBet(bankRoll, stdIn);
					} while (!(bet > 0 && bet <= bankRoll));

					//Initializing deck and creating player sorted hand
					initDeck(deck);
					shuffleDeck(deck, 128);
					dealHand(deck, nextCard, hand);
					sortHand(hand);
					displayHand(hand);

				}

				//Checking results of player hand against win/loss parameters
				if (isQuad(hand, bankRoll, bet))
				{

					bankRoll = bankRoll + (bet * 6545);
					wins++;

				}
				else if (isStraightFlush(hand, bankRoll, bet))
				{

					bankRoll = bankRoll + (bet * 2454);
					wins++;

				}
				else if (isFlush(hand, bankRoll, bet))
				{

					bankRoll = bankRoll + (bet * 123);
					wins++;

				}
				else if (isStraight(hand, bankRoll, bet))
				{

					bankRoll = bankRoll + (bet * 79);
					wins++;

				}
				else if (isTrip(hand, bankRoll, bet))
				{

					bankRoll = bankRoll + (bet * 51);
					wins++;

				}
				else if (is2Pair(hand, bankRoll, bet))
				{

					bankRoll = bankRoll + (bet * 23);
					wins++;

				}
				else if (isPair(hand, bankRoll, bet))
				{

					bankRoll = bankRoll + (bet * 1);
					wins++;

				}
				else
				{
					System.out.println("Sorry you got bubkiss");
					System.out.println("\nYou lost " + (bet) + " chips.");
					bankRoll = bankRoll - bet;
					loses++;

				}
				
			}
			else if ((menuChoice.equalsIgnoreCase("n")))
			{
				System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("\nThanks for playing...");
				System.out.println("\nYou played a total of " + hands + " hands.");
				System.out.println("Of which, you won " + wins + " games.");
				System.out.println("And you lost " + loses + " games.");
				
				if (bankRoll < 100)
					{
					System.out.println("\nIn the end you lost $" + (100 - bankRoll));
					break;
					}
				
				else
				{
					System.out.println("\nIn the end you won $" + (bankRoll - 100));
					break;
				}
			}
			
		} while (!(bankRoll <= 0));
		
		//Ending game if player runs out of chips
		if (bankRoll <= 0 )
		{
			System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("\nThanks for playing...");
			System.out.println("\nYou played a total of " + hands + " hands.");
			System.out.println("Of which, you won " + wins + " games.");
			System.out.println("And you lost " + loses + " games.");
			System.out.println("\nSorry, you lost all of your chips!");
			
		}

	}

	//Welcome to game method
	public static void welcome()
	{
		System.out.println("Welcome to 4 Card Poker");
		System.out.println("\tYour initial bank roll is $100.00");
	}

	//Method displaying initial game menu
	public static String gameMenu(Scanner stdIn)
	{

		String response;
		
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
			System.out.print("\n\n\nWould you like to play a hand [ Y / N ]? : ");
			response = stdIn.next();
			
		
		return response;
	}

	//Method getting the player bet amount
	public static int getBet(int bankRoll, Scanner stdIn)
	{
		int bet;
	
		System.out.print("\nPlace your bet [1, " + bankRoll + "]: ");
		bet = stdIn.nextInt();
	
		return bet;
	}

	//Initializes deck
	public static void initDeck(int[] deck)
	{
		for (int i = 0; i < 36; ++i)
			deck[i] = i;
	}

	//Method shuffling deck
	public static void shuffleDeck(int[] deck, int n)
	{
		System.out.println("\n\n... Shuffling Deck ...");
		for (int i = 0; i < n; i++)
		{
			int j = (int)(Math.random() * 36);
			int k = (int)(Math.random() * 36);

			int temp = deck[j];
			deck[j] = deck[k];
			deck[k] = temp;
		}
	}

	//dealing player hand method
	public static int dealHand(int[] deck, int nextCard, int[] hand)
	{
		System.out.println("\n\nLet the cards fall where they may ...");

		if (nextCard != 36)
		{
			for (int i = 0; i <= 3; ++i)
			{
				hand[i] = deck[i + nextCard];
			}
			return nextCard + 4;
		}
		else
		{
			initDeck(deck);
			shuffleDeck(deck, 128);
		}
		return 4;
	}


	//Method getting value of each card
	public static int cardValue(int card)
	{
		return card % 9 + 1;
	}

	//Method getting cards suit 
	public static String cardSuit(int card)
	{
		String suit = null;

		if (card / 9 == 0)
		{
			suit = "Clubs";
		}
		else if (card / 9 == 1)
		{
			suit = "Spades";
		}
		else if (card / 9 == 2)
		{
			suit = "Hearts";
		}
		else if (card / 9 == 3)
		{
			suit = "Diamonds";
		}

		return suit;
	}

	//Displays user hand
	public static void displayHand(int[] hand)
	{
		for(int i = 0; i < hand.length; i++)
		{
			int card = hand[i];
			displayCard(card); 
		}
		System.out.println();
	}

	//Sorts user hand
	public static void sortHand(int[] hand)
	{
		for (int i = 0; i < hand.length; ++i)
		{
			int maxLoc = i;
			for (int j = i + 1; j < hand.length; ++j)
				if ( cardValue(hand[j]) > cardValue(hand[maxLoc]) )
					maxLoc = j;

			int tmp = hand[i];
			hand[i] = hand[maxLoc];
			hand[maxLoc] = tmp;
		}
	}

	//Determines if cards are four of a kind
	public static boolean isQuad(int[] hand, int bankRoll, int bet)
	{
		if (hand[0] % 9 + 1 == hand[1] % 9 + 1 &&
				hand[1] % 9 + 1 == hand[2] % 9 + 1 &&
				hand[2] % 9 + 1 == hand[3] % 9 + 1)
		{
			System.out.println("Congrats: You got four of a kind!");
			System.out.println("\nYou won " + (bet * 6545) + " chips!");

			return true;
		}
		else
		{
			return false;
		}
	}

	//Determines if cards are a straight flush
	public static boolean isStraightFlush(int[] hand, int bankRoll, int bet)
	{
		if (hand[3] % 9 + 1 == (hand[2] % 9 + 1) + 1 && hand[3] / 9 == hand[2] / 9 && 
				hand[2] % 9 + 1 == (hand[1] % 9 + 1) + 1 && hand[2] / 9 == hand[1] / 9 &&
				hand[1] % 9 + 1 == (hand[0] % 9 + 1) + 1 && hand[1] / 9 == hand[0] / 9 )
		{
			System.out.println("Congrats: You got a straight flush!");
			System.out.println("\nYou won " + (bet * 2454) + " chips!");
			
			return true;
		}

		else
			return false;
	}

	//Determines if cards are a flush
	public static boolean isFlush(int[] hand, int bankRoll, int bet)
	{
		if (hand[0] / 9 == hand[1] / 9 &&
				hand[1] / 9 == hand[2] / 9 &&
				hand[2] / 9 == hand[3] / 9)
		{
			System.out.println("congrats: You got a flush");
			System.out.println("\nYou won " + (bet * 123) + " chips!");
			
			return true;
		}
		else
			return false;
	}

	//Determines if cards are a straight
	public static boolean isStraight(int[] hand, int bankRoll, int bet)
	{
		if (hand[3] % 9 + 1 == (hand[2] % 9 + 1) + 1 &&  
				hand[2] % 9 + 1 == (hand[1] % 9 + 1) + 1 && 
				hand[1] % 9 + 1 == (hand[0] % 9 + 1) + 1)
		{
			System.out.println("Congrats: You got a straight!");
			System.out.println("\nYou won " + (bet * 79) + " chips!");
			
			return true;
		}
		else
			return false;
	}

	//Determines if cards are a triple
	public static boolean isTrip(int[] hand, int bankRoll, int bet)
	{
		if (hand[0] % 9 + 1 == hand[1] % 9 + 1 && hand[1] % 9 + 1 == hand[2] % 9 + 1 ||
				hand[1] % 9 + 1 == hand[2] % 9 + 1 && hand[2] % 9 + 1 == hand[3] % 9 + 1 ||
				hand[2] % 9 + 1 == hand[3] % 9 + 1 && hand[3] % 9 + 1 == hand[0] % 9 + 1)
		{
			System.out.println("Congrats: You got three of a kind!");
			System.out.println("\nYou won " + (bet * 51) + " chips!");
			
			return true;
		}
		else 
			return false;
	}

	//Determines if cards are 2 pair
	public static boolean is2Pair(int[] hand, int bankRoll, int bet)
	{
		if (hand[0] % 9 + 1 == hand[1] % 9 + 1 && hand[2] % 9 + 1 == hand[3] % 9 + 1 ||
				hand[1] % 9 + 1 == hand[2] % 9 + 1 && hand[0] % 9 + 1 == hand[3] % 9 + 1 ||
				hand[2] % 9 + 1 == hand[0] % 9 + 1 && hand[1] % 9 + 1 == hand[3] % 9 + 1)
		{
			System.out.println("Congrats: You got two pair!");
			System.out.println("\nYou won " + (bet * 23) + " chips!");
			
			return true;
		}
		else
			return false;
	}

	//Determines is cards are a pair
	public static boolean isPair(int[] hand, int bankRoll, int bet)
	{
		if (hand[0] % 9 + 1 == hand[1] % 9 + 1 || hand[2] % 9 + 1 == hand[3] % 9 + 1 ||
				hand[1] % 9 + 1 == hand[2] % 9 + 1 || hand[0] % 9 + 1 == hand[3] % 9 + 1 ||
				hand[2] % 9 + 1 == hand[0] % 9 + 1 || hand[1] % 9 + 1 == hand[3] % 9 + 1)
		{
			System.out.println("Congrats: You got a pair!");
			System.out.println("\nYou won " + (bet * 1) + " chips!");
			
			return true;
		}
		else
			return false;
	}


	//Displays card values
	public static void displayCard(int card)
	{
		System.out.println(cardValue(card) + " " + cardSuit(card));
	}

}
