import javax.swing.*;

public class SuperDuper {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declare variables
		String day;
		String month;
		String year;
		Integer maxDays=0;
		String Valid;
		//LeapYear program
		
		//Asks user for their Birth date
		day = JOptionPane.showInputDialog("What day were you born");
		
		//converts day to an integer
		int day2 =Integer.parseInt(day);
		
		{
		    if ((day2 < 1) || (day2 > 31))
		    	 JOptionPane.showMessageDialog(null, "Please enter a valid day");
		    
		}
		//Asks what month they were born.
		month = JOptionPane.showInputDialog("What month were you born");
		//converts month t an integer
		int month2 =Integer.parseInt(month);
		{
			//sets the range of valid months and what happens if the user enters  wrong month
		    while (month2<1  || month2 >31) {
		    	month =  JOptionPane.showInputDialog(null, "Please enter a valid month");
		    	 month2 =Integer.parseInt(month);
		    
		    }
		}
		
		year = JOptionPane.showInputDialog("What year were you born");
		//converts year to an integer
		int year2 =Integer.parseInt(year);
		
		//sets the range of valid years and what happens if the user enters  wrong year
		while (year2 <= 1800) {
		 year = JOptionPane.showInputDialog(null, "Please enter a valid year");
		 year2 =Integer.parseInt(year);
		
		}

		
		if (month2 == 1) {
			month = "January";
			maxDays = 31;
		}else if (month2 == 2) {
			month = "February";
			maxDays = 30;
		}else if (month2 == 3) {
			month = "March";
			maxDays = 31;
		}else if (month2 == 4) {
			month = "April";
			maxDays = 30;
		}else if (month2 == 5) {
			month = "May";
			maxDays = 31;
		}else if (month2 == 6) {
			month = "June" ;
			maxDays = 30;
		}else if (month2 == 7) {
			month = "July";
			maxDays = 31;
		}else if (month2 == 8) {
			month = "August";
			maxDays = 31;
		}else if (month2 == 9) {
			month = "September";
			maxDays = 30;
		}else if (month2 == 10) {
			month = "October";
			maxDays = 31;
		}else if (month2 == 11) {
			month = "November";
			maxDays = 30;
		}else if (month2 == 12) {
			month = "December";
			maxDays = 31;
		}
			
		
		
		JOptionPane.showMessageDialog(null, "You were born " + month + " " + day + ",  " + year +"." );
		
		
	}

}

