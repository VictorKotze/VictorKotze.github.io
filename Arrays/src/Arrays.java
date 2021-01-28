public class Arrays {

    public static void main(String[] args) {
        int[] numberArray = {3, -2, -1020, -3, -10, 200, 12, 14, 16, -20};

        // display array
        System.out.print("{");
        for (int i = 0; i < numberArray.length; i++) {
            System.out.print(numberArray[i] + ", ");
        } // for
        System.out.print("}");
        System.out.println();

        // display index of minimum value
        System.out.println("The minimum value is stored at index: " + indexOfMin(numberArray));

        // change to absolute values
        absoluteValues(numberArray);

        // display array
        System.out.print("{");
        for (int i = 0; i < numberArray.length; i++) {
            System.out.print(numberArray[i] + ", ");
        } // for
        System.out.print("}");
        System.out.println();

        // display index of minimum value
        System.out.println("The minimum value is stored at index: " + indexOfMin(numberArray));


    } // main

    //----------------------------------------------------
    // absoluteValues()
    // accepts an array reference
    // replaces all negative values with absolute value
    // ---------------------------------------------------
    public static void absoluteValues(int[] a){
    	
    	for (int i = 0; i < a.length; i++) {
    	   a[i]	= Math.abs(a[i]);
    	
    	}
    	
    	
    	
    	
    	
        /* Fill in missing code */
        
    } // absoluteValues


    //Find the Index of the minimum
    public static int indexOfMin(int[] a) {
    
	    int min = a[0];
	    int index=0;
	
	    for(int i = 0; i < a.length; i++) {
	         if(min >a[i])
	         {
	             min = a[i];
	             index=i;
	         }
	     }
	    
	    
	    return index;
      

    } // indexOfMin
	

} // ArrayMethods

