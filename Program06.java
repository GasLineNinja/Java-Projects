/***********************************************************
 * Michael Strand
 * CompSci 250 401-805
 * 
 * Program 06
 * 
 * This program is meant to simulate a dice game of chance
 * @author mstra
 *
 ***********************************************************/
import java.util.Scanner;

public class Program06 
{
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);
		System.out.println("Welcome to Computer Dice");

		//Rules to the game laid out
		System.out.println("\nYou will first roll your dice.");
		System.out.println("\nNext the outcome will be determined:");
		System.out.println("\nany Quad and you Win");
		System.out.println("any Tripe and you Win");
		System.out.println("any High Pair" + '(' + "4's" + ')' + "and you Win");
		System.out.println("anything else and you lose");
		System.out.println(" ");

		String responce;
		char ch;
		boolean roll = true;
		System.out.print("Would you like to play Computer Dice? [y, n]: ");
		responce = stdIn.next();
		ch = responce.charAt(0);
		int rounds = 0;
		int won =  0;
		int lost = 0;


		do
		{	
			
			int d1 = (int)(Math.random() * 4) + 1;
			int d2 = (int)(Math.random() * 4) + 1;
			int d3 = (int)(Math.random() * 4) + 1;
			int d4 = (int)(Math.random() * 4) + 1;
			
			if (d1 <= 4 && d2 <= 4 && d3 <= 4 && d4 <= 4)//Making sure all dice show 1-4
			{
					System.out.println("\nPlayer:");
					System.out.println("-------");
					System.out.println(d1 + " " + d2 + " " + d3 +" " + d4 + " ");

			if (d1 == d2 && d2 == d3 && d3 == d4)//Checking if all dice are the same
				{
					System.out.println("Quad, you win!");
					System.out.print("\nWould you like to play again? [y, n]: ");
					responce = stdIn.next();
					++rounds;
					++won;

				}
			else if ((d1 == d2 && d2 == d3 && d3 != d4) || //Checking if three dice are the same
						(d1 == d2 && d2 == d4 && d2 != d3) ||
						(d1 == d3 && d3 == d4 && d1 != d2) ||
						(d2 == d3 && d3 == d4 && d2 != d1))
				{
					System.out.println("Triple, you win!");
					System.out.print("\nWould you like to play again? [y, n]: ");
					responce = stdIn.next();
					++rounds;
					++won;

				}
			else if ((d1 == d2 & d3 == d4 && d2 != d3) ||//Checking if there are two pair of dice the same
						(d1 == d3 && d2 == d4 && d1 != d2) ||
						(d1 == d4 && d2 == d3 && d1 != d2))
				{
					System.out.println("Two Pair, you win!");
					System.out.print("\nWould you like to play again? [y, n]: ");
					responce = stdIn.next();
					++rounds;
					++won;

				}
			else if ((d1 == 4 && d2 == 4 && d3 != 4 && d4 != 4) ||//Checking if there is one pair of 4's
						(d1 == 4 && d3 == 4 && d2 != 4 && d4 != 4) ||
						(d1 == 4 && d4 == 4 && d2 != 4 && d3 != 4) ||
						(d2 == 4 && d3 == 4 && d1 != 4 && d4 != 4) ||
						(d2 == 4 && d4 == 4 && d1 != 4 && d3 != 4) ||
						(d3 == 4 && d4 == 4 && d1 != 4 && d2 != 4))
				{
					System.out.println("High Pair, you win!");
					System.out.print("\nWould you like to play again? [y, n]: ");
					responce = stdIn.next();
					++rounds;
					++won;

				}
			else
				{
					System.out.println("Sorry, you lose!");
					System.out.print("\nWould you like to play again? [y, n]: ");
					responce = stdIn.next();
					++rounds;
					++lost;
				}
			if (responce.charAt(0) == 'n' || responce.charAt(0) == 'N')
				{
					roll = false;

					System.out.println("\nComputer Dice Results");
					System.out.println("---------------------");
					System.out.println("You played " + rounds + " rounds");
					System.out.println("\nRounds won : " + won);
					System.out.print("Rounds lost : " + lost);

				
				/*else
				{
					System.out.print("Please enter vaild responce.");
				}*/
			}
			}
		}while (!(responce.charAt(0) == 'n' || responce.charAt(0) == 'N'));	
		



		stdIn.close();
	}

}


