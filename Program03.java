//Michael Strand
//CompSci 250 401-805
//Program 03

//This program is meant to calculate the ERA of
//a baseball pitcher using user input.

	import java.util.Scanner;//Scanner import

public class Program03 
{
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);//Scanner input for keyboard
		
		String firstName;//First name variable
		String lastName;//Last name variable
		int	runs;//runs variable
		int innings;//innings variable
		
		
		System.out.print("Enter pitcher's first name.");//promt to enter first name
		firstName = stdIn.next();
		System.out.print("Enter pitcher's last name.");//promt to enter last name
		lastName = stdIn.next();
		System.out.print("Enter number of earned runs.");//promt to enter earned runs
		runs = stdIn.nextInt();
		System.out.print("Enter number of innings pitched.");//promt to enter innings pitched
		innings = stdIn.nextInt();
		
		double era = (runs * 9) / innings;//calculation of ERA
		
		System.out.print(firstName + " " + lastName + " has an ERA of " + era);//final output 
		
		stdIn.close();
	}

}
