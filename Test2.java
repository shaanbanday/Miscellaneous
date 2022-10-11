package testReview;

public class Test2 
{

	public static void main(String[] args) 
	{
		int [] myArray = {1, 2, 4, 5, 2, 9, 9, 3, 0};
		
		int max = getMax(myArray);
		
		System.out.println(max);
		System.out.println();
		for (int i = 0; i < myArray.length; i++)
		{
			System.out.print(myArray[i]);
		}
	}
	
	private static int getMax (int [] array)
	{
		int maxIndex = 0;
		int maxValue = 0;
		
		for (int i = 1; i < array.length; i++)
		{
			if (array[i] > array[maxIndex])
			{
				maxIndex = i;
			}
		}
		
		maxValue = array[maxIndex];
		
		array[maxIndex] = 0;
		
		return maxValue;
	}
}