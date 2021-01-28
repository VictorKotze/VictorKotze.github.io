/****************************************************************************
* Name:        ReadAbility
* Author:      Victor hugo
* Date:        December 1, 2020
* Purpose:     Receives the user's and says hello to them. The program also asks for an integer and a floating point value 
*              which it divides by 2 separately
*****************************************************************************/



import javax.swing.*;
import java.awt.Graphics;

public class ReadAbility {

public static void main(String[] args) {
String name;
String smallnumber;
int suzy=0;
double bigumber = 0;

// get string input
name = JOptionPane.showInputDialog( "What is your name?");
   System.out.println("Hello, " + name);   
   
   // display message dialog box
JOptionPane.showMessageDialog(null, "Hello, " + name); 

// get integer input
smallnumber = JOptionPane.showInputDialog( "Please enter an integer:");

// parse string to an integer
try {
suzy=Integer.parseInt(smallnumber);
} catch (Exception e) {
    System.out.println("Invalid integer");
            } // catch

System.out.println(suzy+" / "+2+" = "+suzy/2);   

// get double input
smallnumber=JOptionPane.showInputDialog( "Please enter a floating point number:");

// parse string to a double
try {
	bigumber = Double.parseDouble(smallnumber);
        } catch (Exception e) {
                System.out.println("Invalid double.");
                    } // catch

System.out.println(bigumber+" / "+2+" = "+bigumber/2);   // display on console

System.exit(0);
    } // main
}  // Greeting              
                      
              