/*************************************************************************************************************************
 * Michael Strand
 * CompSci 250 401-805
 * 
 * This program is meant to emulate a basic binary calculator
 * 
 *************************************************************************************************************************/

import java.util.Scanner;

public class Program05b 
{
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);

		//Variable declarations
		String bitString = "";
		int resultSoFar = 0;
		int input = 0;
		
		while (input != 2)
		{
			System.out.println("\n0 -> Shift Left, Add 0");
			System.out.println("1 -> Shift Left, Add 1");
			System.out.println("2 -> Exit, Evaluate\n");
			
			//User validation loop
			do
			{
				//Initial menu of input options
				System.out.print("Choose an operator from the menu above: ");
				input = stdIn.nextInt();

			} while (input <= -1 || input >= 3);

			//Statements 
			if (input == 0)
			{
				bitString += "0";
				resultSoFar = 2 * resultSoFar + 0;
				System.out.println(bitString);
			}
			else if (input == 1)
			{
				bitString += "1";
				resultSoFar = 2 * resultSoFar + 1;
				System.out.println(bitString);
			}
			else
			{
				System.out.println(bitString + ":" + "\t" + resultSoFar);
			}

			
		}
	stdIn.close();
	}
}
	
