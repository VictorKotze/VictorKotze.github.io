
import java.util.Scanner;

public class Test2Method {

   public static void main(String args[])
   {
     System.out.println(isOdd(12));
     System.out.println(isOdd(9));
   }
   public static boolean isOdd(int number)
   { 
    if(number % 2 == 0)
   {
        return false;
    }
    return true;

}
}  // 60%