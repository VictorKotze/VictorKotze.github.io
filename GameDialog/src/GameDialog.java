import javax.swing.*;

public class GameDialog {
public static void main(String args[])
	  {
		  
	
	//declare variables
	 String startingword;
	 String goalword;
	 String FinalWord;
	 String Player1;
	 String Player2;
	 String currentword;
	 String error;
	 String output;
	 int x = 0;
	 int y = 0;
	 fileContents = getFileContents("dictionary.txt");
	 
		  do {
		  String[] options = {"Instructions", "Single Player", "Two Player", "Exit game"};
	     
	         x = JOptionPane.showOptionDialog(null, "Change one letter dialog version",
	                "Click a button",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	        
	        
	        switch (x) {
	        case 0: String[]Instructions= {"Return to Menu"};
			  
			   y = JOptionPane.showOptionDialog(null, "Type in a starting word and your opponent wil type the goal word."
			  		+ " \n In the game you wil both have turns to change one letter aiming to get the goal word" 
					  +"\n The persn who enters the goal word on their turn wins the game."
					  
					  ,"Click a button",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Instructions, Instructions[0]);
				  if(y==0) {
					  continue;
				  }	
	        case 1:   Player1=  JOptionPane.showInputDialog("Enter your name player 1: ");
	       
	        do {
        		startingword = JOptionPane.showInputDialog(error + Player1 + " please enter the starting word ");
        		currentword = startingword;
        		
        		// error checking
        		// check if word is 4 letters long
        		if( !checkLength(currentword) ) {
					error = goalword + " must be 4 letters long, \n"; 
					continue;
				} // if
        		
        		// check if the word entered is in dictionary
        		if( !dictionaryCheck(currentword) ) {
        			error = currentword + " is not a valid word, \n";
        			continue;
        		} // if

        		goalword = wordGen();
        		output ="The computer has chosen " + goalword + " as the goalword";
        		JOptionPane.showMessageDialog(null, output);
        		startingword =  JOptionPane.showInputDialog("Goalword: " + goalword + "\n" + 
        					Player1 + " Please enter a new word with one letter changed ");
        		break;
        		} while (true);
    		
    			continue;

	         startingword= JOptionPane.showInputDialog("Enter the starting word " + Player1);
	         goalword="Bean";
	         FinalWord="The computer has chosen " + goalword + " as the goalword";
	        JOptionPane.showMessageDialog(null, FinalWord );
	         currentword =  JOptionPane.showInputDialog("Enter the new word with one letter changed " + Player1 
	        		+ "\n The current word is " + startingword + " and the goal word is " + goalword);
	        JOptionPane.showInputDialog("Enter the new word with one letter changed " + Player1 
	        		+ "\n The current word is " + currentword + " and the goal word is " + goalword);
	     
	        continue;
	        
	        //2 players
	       case 2:  Player1=  JOptionPane.showInputDialog("Enter your name player 1: ");
	                  Player2=  JOptionPane.showInputDialog("Enter your name player 2: ");
	                  startingword= JOptionPane.showInputDialog("Enter the starting word " + Player1);
	                  goalword= JOptionPane.showInputDialog("Enter the goal word " + Player2);
	                  
	                  currentword =  JOptionPane.showInputDialog("Enter the new word with one letter changed " + Player1 
	      	        		+ "\nThe current word is: " + startingword.toUpperCase() + "\nThe goal word is: " + goalword.toUpperCase());
	                 
	                  while (!currentword.equals(goalword) )    {
	                	  
	                	  
	                  currentword =  JOptionPane.showInputDialog("Enter the new word with one letter changed " + Player2
		      	        		+ "\nThe current word is: " + currentword.toUpperCase() + "\nThe goal word is: " + goalword.toUpperCase());
	          
	                  if (currentword.toUpperCase().equals(goalword.toUpperCase())){
	                	  
	                	  JOptionPane.showInputDialog("Congrats you won the game " +Player2 + " click ok to exit the game");
	                	  
	                	  System.exit(0);
		                      
		                  }
	                  
	                  currentword =  JOptionPane.showInputDialog("Enter the new word with one letter changed " + Player1 
		      	        		+ "\nThe current word is: " + currentword.toUpperCase() + "\nThe goal word is: " + goalword.toUpperCase());
	                      
	                  if (currentword.toUpperCase().equals(goalword.toUpperCase())) {
                	  
                	  JOptionPane.showInputDialog("Congrats you won the game " + Player1 + " click ok to exit the game");
                	  
                	  System.exit(0);
	                      
	                  }
	                   
	                  }
	      	        		
	                
	                 
	                  
	                	  continue;
	                 
	        case 3: System.exit(0);
	        	
	        }

		  }while(true);
	  }
public static String [] getFileContents(String fileName){

	  String [] contents = null;
    int length = 0;
    try {

  	  // input
        String folderName = "/subFolder/"; // if the file is contained in the same folder as the .class file, make this equal to the empty string
        String resource = fileName;

        // this is the path within the jar file
        InputStream input = GameDialog.class.getResourceAsStream(folderName + resource);
        if (input == null) {
      	  // this is how we load file within editor (eg eclipse)
      	  input = GameDialog.class.getClassLoader().getResourceAsStream(resource);
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

public static boolean checkLength(String LastWord) {
		int length = 0;
		length = LastWord.length();
		if(length !=4) {
			return false;
		}
		return true;
	} // checkLength

public static boolean dictionaryCheck(String LastWord) {

	  for(int i = 0; i < fileContents.length;i++){
	    if(fileContents[i].contains(LastWord)) {
	    	return true;
	    	}
	    }
	  return false;
} // dictionaryCheck

public static String wordGen() {
	  int rand = (int)(Math.random()*26);
	  
	  // get a random line from the dictionary
	  String lineOfWords = fileContents[rand];
	  
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
}

	  
}
