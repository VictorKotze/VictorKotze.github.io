import java.util.Scanner;

public class Number {

	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		int x = 0;
		double y = 0;
		String s = "";
		
		System.out.print("Your number on the test: ");	
		y = in.nextDouble ();
		
		System.out.print("Total possible points on test: ");
		x = in.nextInt();
		
		in.nextLine();
		
		System.out.print("Your name:");
		s = in.nextLine ();
		
		System.out.println(s + " Your mark on the test is " + y/x*100);
		
		
		
		
	}

}
