/* Michael Strand
 * CompSci 250-401 805
 * 
 * This program is meant to calculate the surface area of a rooms floor and its 
 * four walls.
 */
public class Program02 
{
	public static void main(String[] args)
	{
		
		//Initial measurements of a room in my house in ft^2
		int l = 8;
		int w = 10;
		int h = 10;
		String units= "feet squared";
		
		//y indicates the area of the floor
		int y= l*w;
		//x indicates the area of a wall times four walls
		int x= (l*h)*(2)+(h*w)*(2);
	
		System.out.println("The measurements of a room are:");
		System.out.println("\t8ft long\n\t10ft high\n\t10ft wide\n");
		System.out.print("The surface area of the floor is:");
		System.out.print(" ");
		System.out.print(y);
		System.out.print(" ");
		System.out.print(units);
		System.out.print("\n\n");
		System.out.print("The surface area of the four walls is:");
		System.out.print(" ");
		System.out.print(x);
		System.out.print(" ");
		System.out.print(units);
		
		
	}

}
