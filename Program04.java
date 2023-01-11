/***************************************************************************************
 * Michael Strand
 * CompSci 250 401-805
 * Program 04
 * 
 * This program is to have a user input 13 digits in a phone number format 
 * working with if statements 
 ***************************************************************************************
 */

import java.util.Scanner;

public class Program04 
{
	public static void main(String[] args)
	{
		//scanner input
		Scanner stdIn = new Scanner(System.in);
		
		//declaration of phone variable
		String phone;
		
		//inital message requesting user input
		System.out.print("Please eneter a phone number (xxx)xxx-xxxx : ");
		phone = stdIn.nextLine();
		int len = phone.length();
	
		
		//format restrictions for phone number w/ output
		if (len == 13 && phone.charAt(0) == '(' && 
			phone.charAt(4) == ')' && phone.charAt(8) == '-' &&
			phone.charAt(1) >= '0' && phone.charAt(1) <= '9' &&
			phone.charAt(2) >= '0' && phone.charAt(2) <= '9' && 
			phone.charAt(3) >= '0' && phone.charAt(3) <= '9' &&
			phone.charAt(5) >= '0' && phone.charAt(5) <= '9' &&
			phone.charAt(6) >= '0' && phone.charAt(6) <= '9' &&
			phone.charAt(7) >= '0' && phone.charAt(7) <= '9' &&
			phone.charAt(9) >= '0' && phone.charAt(9) <= '9' &&
			phone.charAt(10) >= '0' && phone.charAt(10) <= '9' &&
			phone.charAt(11) >= '0' && phone.charAt(11) <= '9' &&
			phone.charAt(12) >= '0' && phone.charAt(12) <= '9')
			{
				System.out.print(phone + " is a valid phone number!");
			}
		
		else//output for correct phone format
			System.out.print(phone + " is not a valid phone number!");
		
	stdIn.close();//scanner close
	}
}
