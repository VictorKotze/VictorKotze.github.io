import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.*;
import java.lang.Math;
import java.util.Random;

public class GamePartnerProject {
	
	static String [] fileContents;
	
	  public static void main(String args[]){
		  
		  // assign variables
		  String MainWord = ""; // Starting word
		  String LastWord = ""; // Current word
		  String EndWord = ""; // Goal word
		  String output = ""; // Computer output 
		  String error = ""; // error message 
		  String LastWord2= ""; //the random generated word from the computer
		  String alphabet="";//list of random alphabet letters
		  String number=""; //Generates a random number between 0 and 3
		  String currentPlayer = ""; // output for current player
		  int steps = 0; // counter to check which player's turn it is
		  int playerTurn = 0; // check which player's turn it is
		  
		  char random;  //random char integer
		  int rand = 0;
		  int num2=0;   //integer num2
		  int x = 0;    // integer x
		  int y = 0;    // integer y
		  int win =0;   //integer win
		 String [] player = new String [2]; // Array for current player
		  
		  String[]Instruction = {"Multiplayer Rules", "Return to Menu"};
		  String[]Instructions = {"Return to Menu"};
		  
		  fileContents = getFileContents("dictionary.txt"); // Call out dictionary file
		  
		  // Main menu for game
		  // make different options for different game modes
		  // Instructions / Single Player / Multiplayer / Exit Game
		  do {
		  String[] options = {"Instructions", "Single Player", "Multiplayer", "Exit game"};
	     
	         x = JOptionPane.showOptionDialog(null, "Welcome to the Change One Letter Game!",
	                "Main Menu",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	        
	        // Switch statement for different options of game
	        switch (x) { 
	        
	        // Send user to Instructions 
	        // display Instructions and give option to show multiplayer rules
	        case 0: 
			   y = JOptionPane.showOptionDialog(null, "Singleplayer"
					+ " \n -Player will enter preffered name"
			  		+ " \n -Player will then choose the starting word"
			  		+ " \n -Computer will then generate a goal word"
			  		+ " \n -Player will try to reach goal word while"
			  		+ " \nchanging only 1 letter of current word"
			  		+ " \n -Player and computer will take turns changing words"
			  		+ " \n -First to reach the goal word wins"
					  ,"Instructions",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Instruction, Instruction[0]);
			  
			  		// Allow user return to the main menu from Instructions
			  		switch (y) {
			  			
			  		// display multiplayer Instructions
			  		case 0: 
			  		int a = JOptionPane.showOptionDialog(null, "Multiplayer"
			  				+ " \n -Player 1 will enter preffered name"
			  				+ " \n -Player 2 will enter preffered name"
	 				  		+ " \n -Player 1 will then choose the starting word"
			  				+ " \n -Player 2 will then choose the goal word"
			  		  		+ " \n -Players will try to reach goal word while"
			  		  		+ " \nchanging only 1 letter of current word"
					  		+ " \n -Players will take turns changing words"
			  		  		+ " \n -First to reach the goal word wins"
			  				  ,"Instructions",
			  	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Instructions, Instructions[0]);
			  			switch (a) {
			  			
			  			// go back to menu			  			
			  			default: continue;
			  			} // switch
			  		
			  		// go back to menu
			  		default: continue;

			  		} // switch

			  		
			// Start single player game
	        case 1: 
	        	
	        		// Ask user for their name
	        		player[0] = JOptionPane.showInputDialog("Enter your name player 1: ");
	        		
	        		// exit if cancel clicked
	    			if (player[0] == null) {
	    				break;
	    			} // if
	        		
	    			// Create loop for error checking
	        		do {
	        			
	        			// Ask player to enter the starting word
		        		MainWord = JOptionPane.showInputDialog(error + player[0] + " please enter the starting word ");
		   	
		        		// exit if cancel clicked
		    			if (MainWord == null) {
		    				break;
		    			} // if
		    			
		    			// make the starting word into current word
		        		LastWord = MainWord.toLowerCase();
		        		
		        		// error checking
		        		// check if word is 4 letters long
		        		if( !checkLength(LastWord) ) {
							error = LastWord.toUpperCase() + " must be 4 letters long, \n"; 
							continue;
						} // if
		        		
		        		// check if the word entered is in dictionary
		        		if( !dictionaryCheck(LastWord) ) {
		        			error = LastWord.toUpperCase() + " is not a valid word, \n";
		        			continue;
		        		} // if
		        		
		        		break;
	        			} while (true);
	        		
		        		// Generate random word for Goal word
		        		EndWord = wordGen();
		        		
		        		// Display generated Goal word
		        		output ="The computer has chosen " + EndWord + " as the goalword";
		        		JOptionPane.showMessageDialog(null, output);
		        		 
		        		
		        		while(LastWord.compareTo(EndWord)!=0) {
		        		// Ask player for a new word with 1 letter changed
		        		LastWord =  JOptionPane.showInputDialog("Goalword: " + EndWord.toUpperCase() + "    Currentword: " + LastWord.toUpperCase() + "\n" + 
		        				error + player[0] + " Please enter a new word with one letter changed ");

		        		LastWord = LastWord.toLowerCase();

		        		//Makes sure that all words being entered are 4 characters long
		        		if( !checkLength(LastWord) ) {
							error = LastWord + " must be a  4 letters long word, \n"; 
							continue;
						} // if
		        		
		        		// check if the word entered is in dictionary
		        		if( !dictionaryCheck(LastWord) ) {
		        			error = LastWord + " is not a valid word, \n";
		        		}

// check if the word is a valid change
	        		if(isValidChange(MainWord, LastWord) != true) {
	        			error = MainWord + " is not a valid change, \n";
	        			MainWord = LastWord;
	        			continue;
	        		} // if

		        		//Notifies the person when they win
		        		if (LastWord.equals(EndWord)) {
		        			JOptionPane.showMessageDialog(null, "Congrats " + player[0] + " You have won the game,"
		        					+ "\n you can now return to the menu ");
		        			break;
		        		}
		        		//Tells the user the new currentword
		        		
		        		
		        		
		        		while ( true ) {
		        		 String tempWord = LastWord;
		        		/*int max = 3; 
		                int min = 0; 
		                int range = max - min + 1; */
		                
		               
		               // for (int i = 0; i < 1; i++) { 
		                     rand = (int)(Math.random() * 4);  // generate random number within 0 to 3 
		          
		                    
		                    System.out.println(rand); 
		             
		               // }
		                Random rnd = new Random();
	                	char c = (char) (rnd.nextInt(26) + 'a');
	                	System.out.println(c);
	                	
	                	// change random letter in lastword
		                char [] temp = tempWord.toCharArray();
		                temp[rand] = c;
		                tempWord = new String(temp);
		        		
		        		System.out.println("Testing lastword: " + tempWord);
		        		if (dictionaryCheck(LastWord))  { 
		        			LastWord = tempWord;
		        			break;
		        		}
		        		}
		        		LastWord2=LastWord;
		        		output ="The computer has changed the currentword word to: " + LastWord2 ;
		        		JOptionPane.showMessageDialog(null, output);
		        		
		        		
		        		
		        		
		        		
		        		}
		        		
		        		//Notifies the person when they lose
		        		if (LastWord2.equals(EndWord)) {
		        			JOptionPane.showMessageDialog(null, "Unfortuantely " + player[0] + " You have lost the game,"
		        					+ "\n feel free to try again! ");
		        			
		        			break;
		        		}
		        		
		        		
		        		
	        			continue;
		        		
	        // Start multiplayer game 
	        case 2: 
	        	
	        		// Ask player 1 for their name
	        		player[0] = JOptionPane.showInputDialog("Enter your name player 1: ");
	        			
	        		// exit if cancel clicked
	    			if (player[0] == null) {
	    				break;
	    			} // if
	    			
	        		// Ask player 2 for their name
	        		player[1] = JOptionPane.showInputDialog("Enter your name player 2: ");
	        		
	        		// exit if cancel clicked
	    			if (player[1] == null) {
	    				break;
	    			} // if
	        		
	    			// Create loop for error checking
	    			do {
	    			
		        		// Ask player 1 for the Starting word
		        		MainWord = JOptionPane.showInputDialog(error + player[0] + ", please enter the starting word: ");
		        		
		        		// Change word to lower case
		        		MainWord = MainWord.toLowerCase();
		        		
		        		// exit if cancel clicked
		    			if (MainWord == null) {
		    				break;
		    			} // if
		        		
		        		// make the starting word into current word
		        		LastWord = MainWord;
		        		
		        		// error checking
		        		// check if word is 4 letters long
		        		if( !checkLength(MainWord) ) {
							error = MainWord + " must be 4 letters long, \n"; 
							continue;
						} // if
		        		
		        		// check if the word entered is in dictionary
		        		if( !dictionaryCheck(MainWord) ) {
		        			error = MainWord + " is not a valid word, \n";
		        			continue;
		        		} // if
	        		
	        		break;
	        		} while (true);
	        			
	    			// clear error message
	    			error = "";
	    			
	    			// Create loop for error checking
	    			do {
	    				
	    				// Ask player 2 for the Goal word
	    				EndWord = JOptionPane.showInputDialog(error + player[1] + ", please enter the goal word: ");
	    				
	    				// Change word to lower case
	    				EndWord = EndWord.toLowerCase();
	    				
	    				// exit if cancel clicked
		    			if (EndWord == null) {
		    				break;
		    			} // if
	    				
	    				// error checking
		        		// check if word is 4 letters long
		        		if( !checkLength(EndWord) ) {
							error = EndWord + " must be 4 letters long, \n"; 
							continue;
						} // if
		        		
		        		// check if the word entered is in dictionary
		        		if( !dictionaryCheck(EndWord) ) {
		        			error = EndWord + " is not a valid word, \n";
		        			continue;
		        		} // if
	        		
	        		break;
	        		} while (true);
	        		
	    			// clear error message
    				error = "";
	        		
	                while (!MainWord.equals(EndWord) ){
	                	
	                		// do loop of player turns
		                	do {
		                		
		                		// check which player's turn it is
		                		if(playerTurn % 2 == 0) {
		                			currentPlayer = player[0];
		                		} else { // if
		                			currentPlayer = player[1];
		                		} // else
		                		
		                		// add to playerTurn
		                		playerTurn++; 
		                		
		                		// add to steps 
		                		steps++;
		                		
		                		// label last word
		                		LastWord = MainWord; 
		                		
		                		// Ask player to type new word with 1 letter changed
				                MainWord =  JOptionPane.showInputDialog(error + currentPlayer + ", enter the new word with one letter changed " 
				                		+ "\nThe current word is: " + MainWord.toUpperCase() + "\nThe goal word is: " + EndWord.toUpperCase());
				                
				                // clear error message
				                error = "";
				                
				                // Change word to lower case
			    				MainWord = MainWord.toLowerCase();
			    				
			    				// exit if cancel clicked
				    			if (MainWord == null) {
				    				break;
				    			} // if
			    				
			    				// error checking
				        		// check if word is 4 letters long
				        		if( !checkLength(MainWord) ) {
									error = MainWord + " must be 4 letters long, \n"; 
									continue;
								} // if
				        		
				        		// check if the word entered is in dictionary
				        		if( !dictionaryCheck(MainWord) ) {
				        			error = MainWord + " is not a valid word, \n";
				        			continue;
				        		} // if
				                
				        		// check if the word is a valid change
				        		if(isValidChange(MainWord, LastWord) != true) {
				        			error = MainWord + " is not a valid change, \n";
				        			MainWord = LastWord;
				        			continue;
				        		} // if
				        		
				        		// check if current word is equals to goal word 
				        		if (MainWord.toUpperCase().equals(EndWord.toUpperCase())){
						        		JOptionPane.showMessageDialog(null, "Congrats " + currentPlayer + " you won the game in " +
						        				steps + " steps! \nClick 'OK' to exit the game.");
							                	  
							            System.exit(0);
				        		} // if
		                	}while (true); // do
	                } // while
	                continue;



        case 3: System.exit(0);
        default: System.exit(0);
        } // switch

	  }while(true);
  } // main
  
  
  public static String [] getFileContents(String fileName){

	  String [] contents = null;
      int length = 0;
      try {

    	  // input
          String folderName = "/subFolder/"; // if the file is contained in the same folder as the .class file, make this equal to the empty string
          String resource = fileName;

          // this is the path within the jar file
          InputStream input = GamePartnerProject.class.getResourceAsStream(folderName + resource);
          if (input == null) {
        	  // this is how we load file within editor (eg eclipse)
        	  input = GamePartnerProject.class.getClassLoader().getResourceAsStream(resource);
          }
          BufferedReader in = new BufferedReader(new InputStreamReader(input));	

          in.mark(Short.MAX_VALUE);  // see api

          // count number of lines in file
          while (in.readLine() != null) {
        	  length++;
          }

          in.reset(); // rewind the reader to the start of file
          contents = new String[length]; // give size to contents array

          // read in contents of file and print to screen
          for (int i = 0; i < length; i++) {
        	  contents[i] = in.readLine();
          }
          in.close();
        } catch (Exception e) {
        	System.out.println("File Input Error");
        }

      return contents;

     } // getFileContents
  
  // check the length of entered word
  public static boolean checkLength(String MainWord) {
		int length = 0;
		length = MainWord.length();
		if(length !=4) {
			return false;
		}
		return true;
	} // checkLength
  
  // check if entered word is in dictionary
  public static boolean dictionaryCheck(String MainWord) {

	  for(int i = 0; i < fileContents.length;i++){
		    if(fileContents[i].contains(MainWord)) {
		    	return true;
		    	}
		    }
	  return false;
  } // dictionaryCheck
  
  // generate a random word off dictionary
  public static String wordGen() {
	  int rand = 0;
	  
	  // get a random line from the dictionary
	  String lineOfWords = fileContents[0];
	  
	  // create an array of word
	  String [] words = lineOfWords.split(" ");
	  
	  //System.out.println("The words you got are: ");
	  for(int j = 0; j < words.length; j++) {
		  //System.out.println(words[j]);
	  }

	  // generate a random number between 0 and the length of words
	  rand = (int)(Math.random()*words.length);
	  //System.out.println("rand number is " + rand);
	  String botWord = words[rand];
	  //System.out.println(botWord);
	  // and return that word
	  return botWord;
  } // wordGen
  
  // check if change is valid
  public static boolean isValidChange(String MainWord, String LastWord) {
	  
	  char [] MainArray;
	  char [] LastArray;
	  int counter = 0;
	  
	  MainArray = MainWord.toCharArray();
	  LastArray = LastWord.toCharArray();
	  
	  for(int i = 0; i < 4 ; i++) {
		  if (MainArray[i] == LastArray[i]){
              counter++;
          } // if
		 
	  } // for
	  
	  if (counter == 3) {
		  return true;
	  } // if
	  else {
		  return false;
	  } // else
	  
  } // isValidChange
 
} // GamePartnerProject
