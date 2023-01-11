/*
 * ****************************************************************************************
 * Michael Strand
 * CompSci 250 401-805
 * Program 05
 * 
 * This program will ask a user for a string the consists of only numbers 0-9. The program
 * will check each character to make sure the user has abided by the guidelines 
 * 
 * ****************************************************************************************
 */

import java.util.Scanner;

public class Program05 
{
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);

		//String variable declaration
		String number;

		//Prompt user to input a series of number in certain format
		System.out.print("Please enter a series of numbers: (ddd)(ddd)...(ddd): ");
		number = stdIn.nextLine();
		int len = number.length();
		
		//Checking lenght of input
		if (len % 5 != 0)
		{
			System.out.println("Length is invalid.");
		}
		else
		{

			//While loop to check for invalid characters
			int i = 0;
			boolean valid = true;
			while (i < len && valid)
			{
				char ch = number.charAt(i);
				if (i % 5 == 0)
				{
					if (number.charAt(i) != '(')
						valid = false;
				}	
				else if (i % 5 == 4)
				{
					if (number.charAt(i) != ')')
						valid = false;
				}

				else 
				{
					if (!(ch >= '0' && ch <= '9'))
						valid = false;
				}
				
				++i;
			}
			
			//Final print calls depending on completion of proper format
			if (valid)
			{
				System.out.println("Thank you number: " + number + " is valid.");
			}
			else
			{
				System.out.println("Format is invalid");
			}
		}
		
		stdIn.close();			
	}
}	