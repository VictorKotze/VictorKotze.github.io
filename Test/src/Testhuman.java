import java.util.Scanner;

public class Testhuman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner (System.in);
		int x = 0;
		String s = "";
		
		System.out.print("Your name:");
		s = in.nextLine ();
		
		System.out.print("Your favourite interger: ");
		x = in.nextInt();
		
		System.out.print("Your favourite interger times two is " + x*2);
		x = in.nextInt();
	}

}
