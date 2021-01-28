import java.io.*;

public class FileInputOutput {

    public static void main(String[] args) {
       
    	// fileContents will contain all the numbers in 
        // the file nums.txt as **strings**. 
    	String [] fileContents = getFileContents("nums.txt");
    	
    	// print the contents of fileContents to the console
        for (int i = 0; i < fileContents.length; i++) {
           System.out.println("Line " + i + ": " + fileContents[i]);
        }
        
        // write fileContents to an output file
        writeArrayToFile("output.txt", fileContents);
               
        // print the sum of the values
        // uncomment the line below to complete the assignment
        System.out.println("The sum of the values is " + sumIntegers(fileContents));
        
        

     } // main
    
     // Convert each value in array to an int, 
     // add all values together
     // and return the integer sum
     public static int sumIntegers(String [] array) {
         int sum = 0;
         //turns the strings into integers and calculates the sum of the integers.
         for (String element : array) {
        	    sum += Integer.parseInt(element);
        	}
    	 
    	 return sum;
     } // sumIntegers
    

     //  reads fileName and returns the contents as String array
     //  with each line of the file as an element of the array
     public static String [] getFileContents(String fileName){

         String [] contents = null;
         int length = 0;
         try {

            // input
            String folderName = "/subFolder/"; // if the file is contained in the same folder as the .class file, make this equal to the empty string
            String resource = fileName;

			// this is the path within the jar file
			InputStream input = FileInputOutput.class.getResourceAsStream(folderName + resource);
			if (input == null) {
				// this is how we load file within editor (eg eclipse)
				input = FileInputOutput.class.getClassLoader().getResourceAsStream(resource);
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

     // writes the array a to fileName, one array element per line in the file
     public static void writeArrayToFile(String fileName, String [] a) {
         try {

            // output file pointer
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

            // write array to file
            for (int i = 0; i < a.length; i++) {
                out.write(a[i] + "");
                out.newLine(); // adds new line to file
            } // for

            out.close();

        } catch (Exception e) {
            System.out.println("File Output Error");
        }

     } // writeArrayToFile


}  // FileInputOutput
