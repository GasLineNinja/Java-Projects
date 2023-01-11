/********************************************************************************************************************************
 * MIchael Strand
 * CompSci 250 401-805
 * Program 08
 * 
 * This program is meant to simulate a roulette game
 * @author mstra
 *
 */

import java.util.Scanner;

public class Program08
{
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);
		
		//Calling welcome method
		welcome();
		
		int chipsNow = 100;
		int menuChoice = getMenuChoice(stdIn);
		String actColor;
		//getMenuChoice(new Scanner(System.in));
		
		while (menuChoice >= 1 && menuChoice <= 2)
		{
			
			int spinNum = (int)(Math.random() * 37);
			actColor = determineColor(spinNum);
		
		if (menuChoice == 1)
		{
			int numChoice = getNumber(stdIn);
			int betAmount = getBet(stdIn, chipsNow);
			
			
			if (spinNum == 0)
			{
				System.out.println("\nSpinning wheel....");
				System.out.println("Spin number: " + spinNum);
				System.out.println("Spin color : " + actColor);
				System.out.println("\nSorry you lose!");
				chipsNow = chipsNow - betAmount;
				System.out.println("You now have " + chipsNow + " chips left.");
				System.out.println("---------------------------");
				if (chipsNow > 0)
				{
					menuChoice = getMenuChoice(stdIn);
				}
				else
				{
					report(chipsNow);
					break;
				}	
			}
			else if (spinNum == numChoice)
			{
				System.out.println("\nSpinning wheel....");
				System.out.println("Spin number: " + spinNum);
				System.out.println("Spin color : " + actColor);
				System.out.println("\nYou win!");
				chipsNow = chipsNow + (betAmount * 35);
				System.out.println("You now have " + chipsNow + " chips left.");
				System.out.println("---------------------------");
				menuChoice = getMenuChoice(stdIn);
				
			}
			else
			{
				System.out.println("\nSpinning wheel....");
				System.out.println("Spin number: " + spinNum);
				System.out.println("Spin color : " + actColor);
				System.out.println("\nSorry you lose!");
				chipsNow = chipsNow - betAmount;
				System.out.println("You now have " + chipsNow + " chips left.");
				System.out.println("---------------------------");
				if (chipsNow > 0)
				{
					menuChoice = getMenuChoice(stdIn);
				}
				else
				{
					report(chipsNow);
					break;
				}
			}
		}
		else if (menuChoice == 2)
		{
			String colorChoice = getColor(stdIn);
			int betAmount = getBet(stdIn, chipsNow);
			
			
			if (colorChoice.equals(actColor))
			{
				System.out.println("\nSpinning wheel....");
				System.out.println("Spin number: " + spinNum);
				System.out.println("Spin color : " + actColor);
				System.out.println("\nYou win!");
				chipsNow = chipsNow + betAmount;
				System.out.println("You now have " + chipsNow + " chips left.");
				System.out.println("---------------------------");
				menuChoice = getMenuChoice(stdIn);
			}
			else if (colorChoice != actColor)
			{
				System.out.println("\nSpinning wheel....");
				System.out.println("Spin number: " + spinNum);
				System.out.println("Spin color : " + actColor);
				System.out.println("\nSorry you lose!");
				chipsNow = chipsNow - betAmount;
				System.out.println("You now have " + chipsNow + " chips left.");
				System.out.println("---------------------------");
				if (chipsNow > 0)
				{
					menuChoice = getMenuChoice(stdIn);
				}
				else
				{
					report(chipsNow);
					break;
				}
			}
		}
		}
		if (menuChoice == 3)
		{
			report(chipsNow);
		}	
	stdIn.close();
	}
	
	//Menu method
	public static void welcome()
	{
		System.out.println("#################################");
		System.out.println("#      Welcome to Roulette      #");
		System.out.println("#################################");
		System.out.println("#    Number bets payout 35:1    #");
		System.out.println("#     Color bets payout 1:1     #");
		System.out.println("#################################");
		System.out.println("\nYou have 100 chips");
		
	}
	//User input for menu choice
	public static int getMenuChoice(Scanner stdIn)
	{
		String menuChoice;
		do 
		{
			System.out.println("\n\n1. Pick a number to bet on");
			System.out.println("2. Pick a color to bet on");
			System.out.println("3. Cash out");
			System.out.print("\nPlease enter your choice [1-3]: ");
			menuChoice = stdIn.next();
			
		}while (!(menuChoice.equals("1") || menuChoice.equals("2") || menuChoice.equals("3")));
		return menuChoice.charAt(0) - ('0');
	}
	
	//User input for number bet choice
	public static int getNumber(Scanner stdIn)
	{
		int numChoice;
		do
		{
			
		System.out.print("\nEnter a number to bet on [1-36]: ");
		numChoice = stdIn.nextInt();
		
		}while (!(numChoice >= 1 && numChoice <= 36));
			
		return numChoice;
	}
	
	//User input for color bet choice
	public static String getColor(Scanner stdIn)
	{
		String colorChoice;
		do 
		{
			System.out.print("\nEnter a color to bet on [Red or Black]: ");
			colorChoice = stdIn.next();
			
		}while (!(colorChoice.equalsIgnoreCase("red") || colorChoice.equalsIgnoreCase("black")));
		return colorChoice;
	}
	
	//User input for chip amount to bet
	public static int getBet(Scanner stdIn, int chipsNow)
	{
		int betChoice;
		
		do
		{
			System.out.print("\nEnter number of chips to bet: ");
			betChoice = stdIn.nextInt();
			
			
			if (betChoice > chipsNow)
			{
				System.out.println("You cannot bet more than you have!");
				
			}
			
		}while (!(betChoice <= chipsNow));
		
		return betChoice;
	}
	
	//Determining color from spin
	public static String determineColor(int spinNum)
	{
		String color = null;
		if (spinNum == 0)
		{
			color = "green";
		}
		else if (spinNum % 2 == 0)
		{
			color = "red";
		}
		else if (spinNum % 2 == 1)
		{
			color = "black";
		}
		return color;
	}
	
	//Reporting final chip count
	public static void report(int chipsNow)
	{
		if ( chipsNow > 100)
		{
			System.out.print("\n\nThanks for playing, you won " + (chipsNow - 100) + " chips!");
		}
		else
		{
			System.out.println("\n\nThanks for playing, you lost " + (100 - chipsNow) + " chips.");
		}
	}

}// class closing
