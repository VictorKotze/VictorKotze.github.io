package leap;

public class LeapYears {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		int year=2001;
		if(year%400==0)
		{
			System.out.println( year + " is a leap year");
		}
		else if(year%4==0 && year%100!=0)
		{
			System.out.println("Leap year");	
		}
		else
		{
	      System.out.println("Not a Leap year");
} 

} }