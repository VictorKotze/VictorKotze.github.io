import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int favNumber=0;
		 
		
		
		Scanner input =new Scanner (System.in);
		
		System.out.println("What is your favourite number: ");
	     favNumber = input.nextInt ();
	     input.nextLine ();

		System.out.println("What is your favourite animal: ");
		String favAnimal = input.nextLine ();
		
		for (int i=0;i<favNumber;i++) {
            System.out.println(favAnimal);
	}

	}
}
