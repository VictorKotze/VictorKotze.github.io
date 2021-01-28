import javax.swing.*;

public class MontyHall {
  public static void main(String args[])
  {

    // declare variables
    int car = 0;            // door behind which car is stored
    int choice = 0;         // user guess
    int open = 0;           // open door number
    int option = 0;         // option to open new door
    String answer;        // user response
    String input;
    String output;

    // display introduction
    output = "This is the Monty Hall Game.\nYou see three doors " +
             "before you. One of them has a new car behind it.\n" +
             "You will choose one of the doors. Then, before you " +
             "get to see which\ndoor has the  car behind it, Monty " +
             "will give you the chance to change\nyour choice after " +
             "showing you that one of the other doors has\nnothing " +
             "behind it.\n";
    JOptionPane.showMessageDialog(null, output);
    
    

    car = (int)(Math.random()*3) + 1;                // random integer from 1 to 3

    // user chooses a door
    input = JOptionPane.showInputDialog ("Which door do you choose (1|2|3): ");
    choice = Integer.parseInt(input);

    // set door values
    if (car == 1 && choice == 1) {
        open = 3; option = 2;
    } // if
    if (car == 1 && choice == 2) {
        open = 3; option = 1;
    } // if
    if (car == 1 && choice == 3) {
         open = 2; option = 1;
    } // if
    if (car == 2 && choice == 1) {
        open = 3; option = 2;
    } // if
    if (car == 2 && choice == 2) {
        open = 1; option = 3;
    } // if
    if (car == 2 && choice == 3) {
        open = 1; option = 2;
    } // if
    if (car == 3 && choice == 1) {
        open = 2; option = 3;
    } // if
    if (car == 3 && choice == 2) {
        open = 1; option = 3;
    } // if
    if (car == 3 && choice == 3) {
        open = 2; option = 1;
    } // if

    // provide user option to change doors
    answer = JOptionPane.showInputDialog ( "Monty shows that there is no car behind door number " +
                                         open  + ".\nDo you want to change your choice to door number "  +
                                         + option + "? (y|n): ");
    // process the user's answer
    answer = answer.toLowerCase();
    if (answer.equals("y")) {
        choice = option;
    } // if

    // determine if won
    output =  "Door number " + car + " has the car behind it.\nSince your final choice was door number " + choice;
    if (choice == car) {
        output += ", you won the car!\n";
    } else {
        output += ", you did not win.\n";
    }
    // display results
    JOptionPane.showMessageDialog(null, output);
    //asks the user if they want to play again
    String again = JOptionPane.showInputDialog("Do you want to play again (y|n) ?");
    //restarts the program or not
  
    
    
    
    	
    	
      
  } // main
} // MontyHall
