/*************************************************************************************************************************************
 * Michael Strand
 * CompSci 250 401-805
 * 
 * Program 07
 * 
 * This program is a dice game between a player and the computer. Each having three die
 *
 ************************************************************************************************************************************/

import java.util.Scanner;

public class Program07
{
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);

		//Responce variables
		String response;
		
		int rounds = 0;
		int win = 0;
		int lose = 0;
		int tie = 0;

		//Greeting and game rules
		System.out.println("\t\tWelcome to Opponent Dice");
		System.out.println("----------------------------------------------------------");
		System.out.println("You will be playing dice against the opponent");
		System.out.println("\nHigh beats low, and same ties");
		System.out.println("Triples beat Pairs and Junk");
		System.out.println("Pairs beat Junk");
		System.out.println("In the case of two identical Pairs - high card decides");
		System.out.println("In case of two Junks - its a tie");
		System.out.print("----------------------------------------------------------");
		System.out.print("\n\nWould you like to play dice? (1 = yes, 2 = no): ");

		response = stdIn.next();

		//Checking valid input
		while (!(response.charAt(0) == '1' || response.charAt(0) == '2'))
		{
			System.out.print("Please choose valid input [1 = yes, 2 = no]: ");
			response = stdIn.next();
		}
		
		//Received valid input
		while (response.charAt(0) == '1' || response.charAt(0) =='2')
		{
			if (response.charAt(0) == '1')
			{

				//Player dice
				int p1 = (int)(Math.random() * 6) + 1;
				int p2 = (int)(Math.random() * 6) + 1;
				int p3 = (int)(Math.random() * 6) + 1;

				//Computer dice
				int c1 = (int)(Math.random() * 6) + 1;
				int c2 = (int)(Math.random() * 6) + 1;
				int c3 = (int)(Math.random() * 6) + 1;

				//Player win conditions
				boolean ptrip = p1 == p2 && p2 == p3;
				boolean ppair = p1 == p2 || p2 == p3 || p3 == p1;
				boolean pjunk = p1 != p2 || p2 != p3 || p3 != p1;

				//Computer win conditions
				boolean ctrip = c1 == c2 && c2 == c3;
				boolean cpair = c1 == c2 || c2 == c3 || c3 == c1;
				boolean cjunk = c1 != c2 || c2 != c3 || c3 != c1;

				//Making sure all dice show 1-6
				if ((p1 <= 6 && p2 <= 6 && p3 <= 6) && (c1 <= 6 && c2 <= 6 && c3 <= 6))
				{
					//Printing player results
					System.out.println("\nPlayer:");
					System.out.println("-------");
					System.out.println(p1 + " " + p2 + " " + p3 +" ");

					//Printing opponent results
					System.out.println("\nOpponent:");
					System.out.println("-------");
					System.out.println(c1 + " " + c2 + " " + c3 +" ");

					//Player triple vs Computer roll
					if (ptrip && ctrip)
					{
						if (p1 > c1)
						{
							System.out.println("\nPlayer Wins!");
							System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
							response = stdIn.next();
							++rounds;
							++win;
						}

						else if (c1 > p1)
						{
							System.out.println("\nPlayer loses!");
							System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
							response = stdIn.next();
							++rounds;
							++lose;
						}
						else if (p1 == c1)
						{
							System.out.println("\nPlayer Ties!");
							System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
							response = stdIn.next();
							++rounds;
							++tie;
						}
					}
					else if (ptrip && cpair)
					{
						System.out.println("\nPlayer Wins!");
						System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
						response = stdIn.next();
						++rounds;
						++win;
					}
					else if (ptrip && cjunk)
					{
						System.out.println("\nPlayer Wins!");
						System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
						response = stdIn.next();
						++rounds;
						++win;
					}
				
					//Player pair vs Computer roll
					else if (ppair && ctrip)
					{
						System.out.println("\nPlayer loses!");
						System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
						response = stdIn.next();
						++rounds;
						++lose;
					}

					else if (ppair && cpair)
					{
						int pc, pnc;
						int cc, cnc;
	
						if (p1 == p2)
						{
							pc = p1;
							pnc = p3;
						}
						else if (p1 == p3)
						{
							pc = p1;
							pnc = p2;
						}
						else
						{
							pc = p2;
							pnc = p1;
						}
						if (c1 == c2)
						{
							cc = c1;
							cnc = c3;
						}
						else if (c1 == c3)
						{
							cc = c1;
							cnc = c2;
						}
						else
						{
							cc = c2;
							cnc = c1;
						}
						if (pc > cc)
						{
							System.out.println("\nPlayer Wins!");
							System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
							response = stdIn.next();
							++rounds;
							++win;
						}
						else if (pc < cc)
						{
							System.out.println("\nPlayer Loses!");
							System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
							response = stdIn.next();
							++rounds;
							++lose;
						}
						else if (pc == cc)
						{
							if (pnc > cnc)
							{
								System.out.println("\nPlayer Wins!");
								System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
								response = stdIn.next();
								++rounds;
								++win;
							}
							else if (cnc > pnc)
							{
								System.out.println("\nPlayer loses!");
								System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
								response = stdIn.next();
								++rounds;
								++lose;
							}
							else if (pnc == cnc)
							{
								System.out.println("\nPlayer Ties!");
								System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
								response = stdIn.next();
								++rounds;
								++tie;
							}
						}
					}
					else if (ppair && cjunk)
					{
						System.out.println("\nPlayer Wins!");
						System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
						response = stdIn.next();
						++rounds;
						++win;
					}
					
					//Player junk vs Computer roll
					else if (pjunk && ctrip)
					{
						System.out.println("\nPlayer loses!");
						System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
						response = stdIn.next();
						++rounds;
						++lose;
					}
					else if (pjunk && cpair)
					{
						System.out.println("\nPlayer loses!");
						System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
						response = stdIn.next();
						++rounds;
						++lose;
					}
					else if (pjunk && cjunk)
					{
						System.out.println("\nPlayer Ties!");
						System.out.print("\nWould you like to play again? (1 = yes, 2 = no) ");
						response = stdIn.next();
						++rounds;
						++tie;
					}
				}
			}
			
			//End of game tally
			if (response.charAt(0) == '2')
			{
				System.out.println("\nPlayer's Dice results");
				System.out.println("---------------------");
				System.out.println("You played " + rounds + " rounds");
				System.out.println("\nRounds won :" + win);
				System.out.println("Rounds tied :" + tie);
				System.out.print("Rounds lost :" + lose);
				break;
			}
			
			//In game response checker
			else if (response.charAt(0) != '1' && response.charAt(0) != '2')
			{
				System.out.println("Please enter valid input.");
				response = stdIn.next();
				continue;
			}

		}

		stdIn.close();
	}

}
