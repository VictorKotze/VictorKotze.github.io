import java.util.Scanner;

public class JavaMath {

	public static void main (String args []) {
                Scanner in = new Scanner(System.in);  // keyboard input

		int x = 0;  // first numerical value
		int y = 0;  //second numerical value

		String results = "";  // final output

		// get integers from user
		System.out.print("Please enter the first integer: ");
		x = in.nextInt();
		System.out.print("Please enter the second integer: ");
		y = in.nextInt();

		System.out.println(x + " + "   + y +  "=" + (x+y));

		// print the results of addition
	
		System.out.print ("The results of the subtractions is" + (x-y) + " and " + (y-x));
		// print the results of subtraction of both x-y and y-x
	
		System.out.println(x + "*" + y +  "=" + (x*y));

		
		// print the results of multiplication
		System.out.println(x + "/"  + y +  "=" + (x/y));
		System.out.println(y + "/" + x +  "=" + (y/x));


		// print the results of division of x/y and y/x without casting
		System.out.println(x + "/" + y + "="  + ((double)x/y));
		System.out.println(y + "/" + x + "="+ ((double)y/x));

		
		// print the results of division of x/y and y/x with casting
		System.out.println(x + "%" + y + "=" + (x%y));
		System.out.println(y + "%" + x + "=" + (y%x));
		// print the results of modulus of x%y and y%x
	

		// use the increment operator to add 1 to x, print x
		System.out.println("X +1 is" + (x+1));

		// use the increment operator to subtract 1 from y, print y
		System.out.println("X +1 is" + (x+1));
		// print the results of (x+y)%7-6*2+y/x*(x-4)
		
		System.out.println("Y + 1 is" + (y+1));
		
		System.out.println("(" + x + "+" + y + "%7-6*2+" + y + "/" + x + "*(" + x + "-4) = " + (x+y)%7-6*2+y/x*(x-4));

		
	} // main
} // JavaMath