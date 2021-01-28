import java.util.Scanner;

public class MathClassSampler {

    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);  // keyboard input

        String output = "";           // output string

        double degrees = 0;          // angle in degrees
        double radians = 0;          // angle in radians

        double num1 = 0;
        double num2 = 0;

        // Demonstrate use of tan
        // ----------------------

        // get user input
        System.out.println("Enter an angle in degrees (between 0 and 90): ");
        degrees = in.nextDouble();

        // converts degrees to radians
        // NOTE: trig functions require input in radians
        radians = Math.toRadians(degrees);
 
        // calculate the tan of the angle and add to output
        output = "tan(" + degrees + ") = " + Math.tan(radians) + "\n";
        
        double sinValue = Math.sin(radians); 
        System.out.println("sin(" + degrees + ") = " + sinValue); //Calculates sin 
        
        double cosValue = Math.cos(radians); 
        System.out.println("cos(" + degrees + ") = " + cosValue); //Calculates cos 
        
        // print output 
        System.out.println(output);


        // Demonstrate use of max
        // ----------------------

        // get user input
        System.out.println("Enter a number: ");
        num1 = in.nextDouble();
        System.out.println("Enter another number: ");
        num2 = in.nextDouble();

        // send max of the two numbers to output
        output = "Max of " + num1 + " and " + num2 + " = " + Math.max(num1, num2) + "\n";
        System.out.println(output);
        
        output = "Minium of " +num1 + " and " + num2 + " = " + Math.min(num1, num2) + "\n";
        // print output to screen
        System.out.println(output);

        // Demonstrate use of sqrt
        // -----------------------

        // get user input
        System.out.println("Enter a number: ");
        num1 = in.nextDouble();

        // send square root of the number to output
        output = "Square root of " + num1 + " = " + Math.sqrt(num1);
        
        System.out.println(output);
        // print output to screen
        output = "Round of " + num1 + " = " + Math.round(num1);
        
        System.out.println(output);
       
        // Self Discovery:  Add code to demonstrate the use of sin, cos, min and round.
        // Don't forget to look up these functions at the Java API first!!!!

        System.exit(0);
    } // main
    
} // MathClassSampler
