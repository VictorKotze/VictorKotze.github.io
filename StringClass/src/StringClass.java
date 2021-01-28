import java.util.Scanner;
public class StringClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		
		System.out.println("Enter your favourite quote: ");
		String quote= input.nextLine();
		
		 char ch =quote.charAt(10);
		 System.out.print("The letter at Index 10 of your quote is: " +ch );
	
		 int index= quote.indexOf("t");
		 System.out.println("\n The index of the first occurence of the letter t is: " +index);
		 
		 System.out.println("The number of characters in your quote is: " +quote.length());
		 
	     String quote2=quote;
	     
		 quote2 = quote2.replace("the", "foobar");
		 System.out.println(quote2);
		 
		 System.out.println(quote.toUpperCase());

		 if(quote2.contains("horse")) {
			System.out.println("I like your taste.");
		 }
		 
}
}
