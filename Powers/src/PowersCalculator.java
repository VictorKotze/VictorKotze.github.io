import java.util.Scanner;

public class PowersCalculator {

    // main
    public static void main (String args[]) {
        
        double num;      // number entered by user
        double p2;       // power of 2
        double p3;
        double p4;
        double p5;
        String input;    // user input
        String output;   // output to display
        Scanner in = new Scanner(System.in); // console input

        

        // get user input as a string
        System.out.print("Enter a number: ");
        input = in.nextLine();

        // then convert string to double
        num = Double.parseDouble(input);

        // call method to calculate power of two
        p2 = powerOfTwo(num);
       
        // create the output string
        output = num + " ^2 = " + p2;

        // print output to screen
        System.out.println(output);

        p3 = powerOfThree(num);
        output = num + " ^3 = " + p3;
        
        System.out.println(output);
        
        p4 = powerOfFour(num);
        output = num + " ^4 = " + p4;
        
        System.out.println(output);
        
        p5 = powerOfFive(num);
        output = num + " ^5 = " + p5;
        
        System.out.println(output);
    } // main


    // methods
    // -------

    // return x to the power of two
    public static double powerOfTwo(double x) {
        return Math.pow(x,2); }
        public static double powerOfThree(double x) {
            return Math.pow(x,3); }
            public static double powerOfFour(double x) {
                return Math.pow(x,4); }
            public static double powerOfFive(double x) {
                return Math.pow(x,5); }
    } // powerOfTwo

 // Powers