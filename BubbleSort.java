package stringAndArrays;

public class BubbleSort {

	public static void main(String[] args) 
	{
		int [] array = {12, 19, 3, 18, 2, 1};
		
		for (int i = 0; i < array.length; i++)
		{
			int a = array [i];
			
			for (int j = i; j < array.length; j++)
			{
				if (array [j] < a)
				{
					a = array [j];
					array[j] = array [i];
					array [i] = a;
				}
			}
		}
		
		for (int k = 0; k < array.length; k++)
		{
			System.out.println(array[k]);
		}

	}
}