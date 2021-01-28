import javax.swing.JOptionPane;

public class InputUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String input = ""; //user entered input
String error = ""; //error message
int num = 0; //Integer value of user input

//repeat if invalid data enterd
do {
	input =JOptionPane.showInputDialog(error + "Enter a number: ");
	
	//exit if cancel clicked
	if (input ==null) {
	System.exit(0);
	} //if
	try {
		num = Integer.parseInt(input);
	} catch (Exception e) {
		error = input + " was not a number. ";
		JOptionPane.showMessageDialog(null, "That was not a whole number.");
		System.out.println("error with input, running catch");
		num = 0;
		continue;
	}//catch
	
	//chunk of code to check for negative values
	if (num <0) {
	error = input + " is not a positive number. ";
	}//if
	
	//other error checking would go here
	
	break;
} while(true);


JOptionPane.showMessageDialog(null, "2 *  number is " + (2*num));
	}

}
