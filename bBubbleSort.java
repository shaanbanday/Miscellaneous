package testReview;

public class bBubbleSort {

	public static void main(String[] args) 
	{
		int [] array = {9, 21, 17, 1, 15, 3};
		
		boolean swapped = true;
		
		while (swapped)
		{
			swapped = false;
			
			for (int i = 1; i < array.length; i++)
			{
				printArray(array);
				if (array[i] > array[i - 1])
				{
					int temp = array [i];
					array[i] = array [i - 1];
					array[i - 1] = temp;
					swapped = true;
				}
			}
		}
	}
	
	private static void printArray(int [] arr)
	{
		for (int l = 0; l < arr.length; l++)
		{
			System.out.print(arr[l] + ", ");
		}
		System.out.println();
	}
}