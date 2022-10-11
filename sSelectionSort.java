package testReview;

public class sSelectionSort {

	public static void main(String[] args) 
	{
		int [] array = {9, 21, 17, 1, 15, 3};
		
		for (int i = 0; i < array.length; i++)
		{
			int lowestNumber = i;
			
			for (int j = (i + 1); j < array.length; j++)
			{
				if (array[j] < array[lowestNumber])
				{
					lowestNumber = j;
				}	
			}
			
			int temp = array [lowestNumber];
			array[lowestNumber] = array[i];
			array [i] = temp;
		}
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + "  ");
		}

	}	
}