/*
Java™ Project: ICS4U
Package: stringsAndArrays
Class: ArraysAssignment
Programmer: Shaan Banday.

Date Created: Thursday, 20th February, 2022.
Date Completed: Friday, 21st February, 2022.

Description: The following program/class is one that has no main method. However, it acts as a hub for various public array methods to
be called by another class in the same package. The first method, printArray (int [] array), is a command which takes the parameter of 
a one-dimensional integer array, and prints each element to the console horizontally, with spaces between each element. The second method, 
int arraySize (int [] array), is a query which takes the parameter of a of a one-dimensional integer array, and finds the size of the 
array (number of elements). Note that if an array of size 10 is passed, the last index is 9, but the size of the array is still 10, which 
the method takes care of. The third method, int [] swap(int [], int i, int j), is a query which takes the parameter of a one-dimensional 
integer array, and two indices that the user wishes to swap. It then returns a new array with the elements at both indices swapped. If 
the user inputs a index that is negative or outside the bounds of the original parametric array, then the method catches the error and 
outputs a message to the console. The fourth method, int [] makeRandomArray(int size), is one that takes the parameter of an integer and 
constructs an integer array of that size with random numbers from 0 to 10. If the user tries to construct an array with a negative size, 
then the method catches the error and prints a message to the console. The fifth method, int [] makeBigger(int[] array), is a query that 
takes the parameter of a one-dimensional integer array and returns the same array, but with an added empty space at the end. The sixth 
method, int [] makeBigger (int [] array, int increase), is similar to the last method and is an example of overloading. It is a query that
takes the parameters of a one-dimensional integer array and an user integer. It returns the same array, but with how ever many spaces the
user wants, at the end. If the user inputs a negative number, then the method catches the error and prints a message to the console. The
seventh method, int [] mergeArrays (int [] first, int [] second), is a query that takes the parameters of two separate one-dimensional 
arrays, and returns the concatenation of those arrays. The eight method, int sumArray (int [] array), is a query that takes the parameter 
of a one-dimensional integer array and returns the sum of all elements in the array. The ninth method, boolean isBigger (int [] first, 
int [] second), is a query that takes the parameters of two separate one-dimensional arrays and returns whether the sum of the first array
is larger than the sum of the second. The tenth method, int [] insertAt (int [] array, int index, int element) is a query that takes the 
parameters of a one-dimmensional array, a user prompted integer index, and a user prompted integer element. It returns the same array, but
with the element inserted at the index. If the user requests negative element or an element outside of the bounds of the array, then the 
method catches the error and prints a message to the console.
*/
package stringAndArrays; //Launch the class from this package named "stringsAndArrays


public class ArraysAssignment //The name of the class. This is important to be exact since another class will call this classes methods
{	
	//First Method
	public static void printArray (int [] toBePrinted) throws InterruptedException //The printing method throws an Interrupted Exception for a delay
	{
		//Declare and initialise delay constant
		final short DELAY = 300; //Delay after each element of a given array is printed. Constant is a short and not an int to make program run faster
		
		//Loop
		for (int k = 0; k < toBePrinted.length; k++) //Start the loop at 0, and run until it has gone through every element of the array
		{
			//Print elements of the parametric array 	
			System.out.print(toBePrinted[k] + " "); //Print given element at k to the console, with a space after it
			Thread.sleep(DELAY); //Delay before next element is printed
		}
		System.out.println(); //Take care of anything else to be printed to the console, so it goes onto the next line
	}
	
	//Second Method
	public static int arraySize (int [] toBeSized) //This methods finds the size (the number of elements) of an array passed to it
	{
		return toBeSized.length; //Return the length of the given array as an Integer 
	}
	
	//Third Method
	public static int [] swap (int[] toBeSwapped, int i, int j) //This method swaps the elements at indices i and j
	{
		//Try and catch statement
		try //Try to switch the elements 
		{
			int tempIndex = toBeSwapped[i]; //Store the first element at index i in a temporary integer variable
			toBeSwapped [i] = toBeSwapped [j]; //Store the element at index j into index i
			toBeSwapped [j] = tempIndex; //Store the temporary integer value, which is just the element at index i, into index j
		}
		
		catch (ArrayIndexOutOfBoundsException e) //Catch the exception if either one of the indices is out of the array's bounds 
		{
			//Print error message to the console
			System.out.println("An error occured. You either tried swapping with a negative index,"
					+ " or an index outside of the bounds of the array."); //Inform user of wrong input
		}
		
		return toBeSwapped; //Return the array. New array will be returned if swap did occur; original if error was thrown
	}
	
	//Fourth Method
	public static int [] makeRandomArray (int size) //This method creates an integer array with a custom size, filled with random numbers
	{
		//Try and catch statement
		try //Try to create the array
		{
			//Declare and initialise the array 
			int [] randomArray = new int [size]; //Set the array to the size the user inputs
		
			//Loop
			for (int i = 0; i < size; i++) //Start the loop at 0, and run until it has gone through every element of the array
			{
				randomArray [i] = (int) (Math.random()*11); //At whatever index i is, generate a random casted integer between 0-11, but not including 11.
			}
			
			return randomArray; //Return the new array of random numbers 
		}
		
		catch (NegativeArraySizeException e) //Catch the exception if either the user tries to construct an array with a negative size  
		{
			//Print Message
			System.out.println("An error occured. An array with a negative size cannot be constructed."); //Inform user of error
			return new int [0]; //Return an empty integer array instead of the new array
		}
	}
	
	//Fifth Method
	public static int [] makeBigger (int [] toBeGrown) //This method adds an empty space element at the last index of the array
	{
		//Declare and initialise the array
		int [] biggerArray = new int [toBeGrown.length + 1]; //Make the array one size bigger than the original, to account for the space
		
		//Loop
		for (int j = 0; j < toBeGrown.length; j++) //Start the loop at 0, and run until it has gone through every element of the array
		{
			biggerArray [j] = toBeGrown [j]; //Fill the element at whatever index with the element of the original array at the same index
			//Last element of the array (j+1) is never filled, which is the space
		}
		
		return biggerArray; //Return the new array with the added space at the end
	}
	
	//Sixth Method
	public static int [] makeBigger (int [] toBeGrown, int increase) //This method adds many spaces at the end of an integer array
	{
		//Declare and initialise the array
		int [] customArray = new int [toBeGrown.length + increase]; //Make the array how ever many indices bigger to account for the spaces
		
		//Try and catch statement
		try //Try to fill the new array with the elements of the original and the added spaces
		{
			//Loop
			for (int l = 0; l < toBeGrown.length; l++) //Start the loop at 0, and run until it has gone through every element of the array
			{
				customArray [l] = toBeGrown [l]; //Fill the element at whatever index with the element of the original array at the same index
				//Last elements of the array are never filled, which are the spaces
			}
		}
		
		catch (ArrayIndexOutOfBoundsException e) //Catch the exception if the user tries to increase the number of spaces by a negative number
		{
			//Print message
			System.out.println("An error occured. The number of spaces to make the array bigger cannot be negative."); //Inform user of error
		}
		
		return customArray; //Return the array. New array will be returned if empty spaces were added; original if error was thrown
	}
	
	//Seventh Method
	public static int [] mergeArrays (int [] firstArray, int [] secondArray) //This method concatenates the elements of two arrays into a bigger one.
	{
		//Declare and initialise the array
		int [] mergedArray = new int [firstArray.length + secondArray.length]; //Make the array the size of the sums of both arrays
		
		//Declare and initialise any other variables
		int fulcrumPoint = firstArray.length; //Set a fulcrum point, which is the length of the first array
		
		//Loops
		for (int m = 0; m < firstArray.length; m++) //Start the loop at 0, and run until it has gone through every element of the array
		{
			mergedArray [m] = firstArray [m]; //Add the element at index m of the first array into the same index of the merged array
		}
		
		for (int n = 0; n < secondArray.length; n++) //Start the loop at 0, and run until it has gone through every element of the array
		{
			mergedArray [fulcrumPoint] = secondArray [n]; //Add the element at index n of the second array to a new index.
			//This is shifted to account for the size of the original array
			
			fulcrumPoint++; //Increase the fulcrum by 1, so it is in line with n
		}
		
		return mergedArray; //Return the concatenation of both arrays
	}
	
	//Eight method
	public static int sumArray(int [] toBeSummed) //This method finds the sum of all the element in the parametric integer array
	{
		//Declare and initialise all variables
		int sum = 0; //For now, set the sum of the elements of array to 0;
		
		//Loop
		for (int p = 0; p < toBeSummed.length; p++) //Start the loop at 0, and run until it has gone through every element of the array
		{
			sum += toBeSummed[p]; //Add the element at index p to the sum
		}
		
		return sum; //Return the the sum of all elements in the array
	}
	
	//Ninth Method
	public static boolean isBigger (int [] firstArray, int [] secondArray) //This method checks if the sum of the first array is bigger than the second
	{
		//Declare and initialise all variables
		int sum1 = sumArray(firstArray); //Call the previous method, with the parameter of the first array and set its return to sum1
		int sum2 = sumArray(secondArray); //Call the previous method, with the parameter of the second array and set its return to sum2
		
		return sum1 > sum2; //Return true or false if sum1 is greater than sum2
	}
	
	//Tenth Method
	public static int[] insertAt(int [] array, int index, int element) //This method inserts a user-prompted integer at a user-prompted element
	{
		//Declare and initialise the array
		int [] insertedArray = new int [array.length + 1]; //Set the new array to one more than size of the original array to account for the insertion
		
		//Try and catch statement 
		try //Try to fill the new array with the elements of the original, plus the user-prompted integer
		{
			//Loop
			for (int q = 0; q < insertedArray.length; q++) //Start the loop at 0, and run until it has gone through every element of the array
			{
				//Decisions
				if (q < index) //If q has not yet reached the index where the user wants to insert their integer
				{
					insertedArray [q] = array [q]; //Fill the array as normal, with a 1-1 mapping
				}
				
				else if (q == index) //If q is at the index where the user wants to insert their integer
				{
					insertedArray [q] = element; //Fill the array at this index with the user-prompted integer
				}
				
				else //Otherwise, if the user-prompted index has already been filled at its desired spot
				{
					insertedArray [q] = array [q-1]; //Fill the array at one before the same index in the original array, to account for the new index
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) //Catch the exception if the user-prompted index is out of the array's bounds 
		{
			//Print message
			System.out.println("An error occured. You either tried adding a value to a negative index,"
					+ " or an index outside of the bounds of the array."); //Inform user of the error
		}
		
		return insertedArray; //Return the array. New array will be returned if insertion did occur; original if error was thrown
	}
}