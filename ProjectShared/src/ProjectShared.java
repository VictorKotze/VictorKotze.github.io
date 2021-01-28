import javax.swing.*;

public class ProjectShared {
	
	//main
	
	public static void main (String args [])
	{
		
	double num;
	double p2;
	String input;
	String output;
	
	
	//create a pane that supports html
	JEditorPane outputScreen = new JEditorPane();
	outputScreen.setContentType("text/html");
	outputScreen.setEditable(false);
	
	
	//get user input
	output= "Enter a number";
    outputScreen.setText(output);
    input = JOptionPane.showInputDialog(null,outputScreen, "Powers");
    num = Double.parseDouble(input);
    
    //create the output string
    output = "<b>" + num + " <sup>2</sup> = " + Math.pow(num,2) + "<hr>";
    output += "<b>" + num + " <sup>3</sup> = " + Math.pow(num,3); 
    
    //prints output to screen
    outputScreen.setText(output);
    JOptionPane.showMessageDialog(null, outputScreen, "Powers", JOptionPane.INFORMATION_MESSAGE);

	System.exit(0);
	
		
	}
}
