import java.util.Scanner;

public class CalcAverage {

    
    public static void main (String args[]) {
        // four number entered by user
        double num1 = 0;
        double num2 = 0;
        double num3 = 0;
        double num4 = 0;
        
        // four user input values
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        
        String output = "";  // output to display
        double avg = 0;  // average

        // keyboard input
        Scanner in = new Scanner(System.in);

        // get the four numbers
        System.out.println("Enter 4 numbers, hit enter after each one: ");
        s1 = in.nextLine();
        s2 = in.nextLine();
        s3 = in.nextLine();
        s4 = in.nextLine();
        
        // convert strings to doubles
        num1 = Double.parseDouble(s1);
        num2 = Double.parseDouble(s2);
        num3 = Double.parseDouble(s3);
        num4 = Double.parseDouble(s4);
        
        // call method to calculate average
        avg = average(num1, num2, num3, num4);

        // create the output string
        output = ("The average of these four numbers are " + (num1 +num2 + num3 +num4)/4   );

        // print output to screen
        System.out.println(output);
     
    } // main


    // methods
    // -------

    public static double average(double x1, double x2, double x3, double x4) {      
       return 0; // replace 0 with the correct calculation
    } // average

} // CalcAverage
