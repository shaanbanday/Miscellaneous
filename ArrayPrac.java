package stringAndArrays; 

public class ArrayPrac 
{

	public static void main(String[] args) 
	{
				
        int [] oneToTenArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int [] randomArray = {5, 8, 5, 5, 1, 3, 0, 4, 5, 10, 11, 14, 22};     
       
        //test the swap feature a couple times
        System.out.println("Testing swap...");
        System.out.print("Our inital array: ");
        printArray(oneToTenArray);     
        swap(oneToTenArray, 0, 9);
        System.out.println("Swap first and last to get: ");
        printArray(oneToTenArray);
        swap(oneToTenArray, 1, 2);
        System.out.println("Swap second and third to get: ");
        printArray(oneToTenArray);
        
        //swap them back to put the numbers in order
        swap(oneToTenArray, 9, 0);
        swap(oneToTenArray, 2, 1);
        System.out.println("Swap them back to get: ");
        printArray(oneToTenArray);
        
        //check the countOf method a few times
        System.out.println();
        System.out.println("testing countOf...");
        System.out.println("How many 9s are in our 1-10 array?");
        System.out.println("Answer: " + countOf(oneToTenArray, 9));
        System.out.println("How many 12s are in our 1-10 array?");
        System.out.println("Answer: " + countOf(oneToTenArray, 12));
        System.out.println("How many 5s are in our random array?");
        printArray(randomArray);     
        System.out.println("Answer: " + countOf(randomArray, 5));
        System.out.println();
        
        //check the isInOrder method
        System.out.println("checking isInOrder...");
        System.out.println("Is the oneToTen array in order?");
        System.out.println("Answer: " + isInOrder(oneToTenArray));
        System.out.println("Is the random array in order?");
        System.out.println("Answer: " + isInOrder(randomArray));
        System.out.println();
        
        //check the first reverse method
        System.out.println("testing first reverse method...");
        System.out.println("We can reverse the one to ten array:");
        oneToTenArray = reverse(oneToTenArray);
        printArray(oneToTenArray);
        System.out.println("Reverse it back!");
        oneToTenArray = reverse(oneToTenArray);
        printArray(oneToTenArray);
        System.out.println();
        
        //check the second reverse method
        System.out.println("Checking second reverse method");
        System.out.println("I'm making a new array that is reverse of one to ten");
        int [] newArray = getReverseArray(oneToTenArray);
        printArray(newArray);
        
        System.out.print("Here is the random array: ");
        printArray(randomArray);
        System.out.println("Here it is reversed: ");
        int[] anotherArray = getReverseArray(randomArray);
        printArray(anotherArray);
        System.out.println();
        
        System.out.println("Here are our original arrays: ");
        printArray(oneToTenArray);
        printArray(randomArray);
        
        System.out.println(ArraysAssignment.arraySize(oneToTenArray));
	}

	private static void printArray(int[] anIntArray) 
	{
		//this method simply prints the elements of an integer array (horizontally), with one space
		//between each element
		for (int k = 0; k < anIntArray.length; k++)
		{
			System.out.print(anIntArray[k] + " ");
		}
		System.out.println("\n");
	}
	
	private static void swap(int[] anIntArray, int i, int j) 
	{
		int temp = anIntArray[i];
		anIntArray [i] = anIntArray [j];
		anIntArray [j] = temp;
	}
	
	private static int countOf(int[] anIntArray, int n) {
		//this method returns the number of occurrences of the integer n in an array
		int count = 0;
		
		for (int l = 0; l < anIntArray.length; l++)
		{
			if (anIntArray[l] == n)
			{
				count ++;
			}
			else {
				//do nothing
			}
		}
	
		return count;
	}
	
	private static boolean isInOrder(int[] anIntArray) 
	{
		//this method returns true if anIntArray is in order, false otherwise
		
		boolean checkOrder = false;
		int m = 0;
		
		
		while (m < (anIntArray.length - 1)) 
		{
			if (anIntArray[m] < anIntArray[m + 1])
			{
				checkOrder = true;
				m++;
			}
			else
			{
				checkOrder = false;
				m = anIntArray.length;
			}
		}
		return checkOrder;
	}
	
	private static int [] reverse(int[] anIntArray) 
	{
		//this method reverses the order of an anIntArray
		int [] tempArray = new int[anIntArray.length];
		
		int count = 0;
		
		for (int n = (tempArray.length - 1); n>= 0; n--)
		{
			tempArray [count] = anIntArray[n];
			count++;
		}
		return tempArray;
	}
	
	private static int[] getReverseArray(int[] anIntArray) {
		//this method returns an array that has the elements of anIntArray, but does
		//not change anIntArray
		
		//this method reverses the order of an anIntArray
				int [] tempArray = new int[anIntArray.length];
				
				int count = 0;
				
				for (int n = (tempArray.length - 1); n>= 0; n--)
				{
					tempArray [count] = anIntArray[n];
					count++;
				}
				return tempArray;
	}
}