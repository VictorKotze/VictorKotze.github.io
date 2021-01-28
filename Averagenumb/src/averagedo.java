import java.util.Scanner;

public class averagedo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner (System.in);
double y = 0;
double x = 0;
double z = 0;

System.out.print("First number: ");	
y = in.nextDouble ();

System.out.print("Second number: ");	
x = in.nextDouble ();

in.nextLine();

System.out.print("Third number: ");	
z = in.nextDouble ();

System.out.println("The average of these numbers are" + (y+x+z)/3  );

	}//main

}
