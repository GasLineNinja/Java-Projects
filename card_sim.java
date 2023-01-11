/****************************************************************************************************************************
 * Michael Strand
 * CompSci 250 401-805
 * 
 * Program 09
 * 
 * This program emulate a deck of 36 cards
 * @author mstra
 *
 **************************************************************************************************************************/


public class Program09 
{
	public static void main(String[] args)
	{
		int[] deck = new int[36];
		
		System.out.println("Unshuffled deck");
		System.out.println("---------------");
		initDeck(deck);
		displayDeck(deck);
		
		System.out.println("\nShuffled deck");
		System.out.println("---------------");
		shuffleDeck(deck, 128);
		displayDeck(deck);	
	}
	
	public static int cardValue(int card)
	{
		return card % 9 + 1;
	}
	
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
	
	public static void displayCard(int card)
	{
		System.out.println(cardValue(card) + " " + cardSuit(card));
	}
	
	public static void initDeck(int[] deck)
	{
		for (int i = 0; i < 36; ++i)
		deck[i] = i;
	}
	
	public static void shuffleDeck(int[] deck, int n)
	{
		for (int i = 0; i < n; i++)
		{
			int j = (int)(Math.random() * 36);
			int k = (int)(Math.random() * 36);
			
			int temp = deck[j];
			deck[j] = deck[k];
			deck[k] = temp;
		}
	}
	
	public static void displayDeck(int[] deck)
	{
		for (int i = 0; i < 35; ++i)
		{
			displayCard(deck[i]);
			
		}
	}
}
