package intro;

import java.util.Scanner;

public class NumberedArrays {

	public static void main(String[] args) 
	{
		Scanner takeUserInput = new Scanner(System.in);
		
		System.out.println("How many numbers would you like to give me?");
		int index = takeUserInput.nextInt();
	
		int [] list = new int [index];
		for (int count = 0; count < index; count++)
		{
			if (count == 0)
			{
				System.out.println("Enter each number, press enter to continue");
				list [count] = takeUserInput.nextInt();
			}
			else 
			{
				System.out.print("");
				list [count] = takeUserInput.nextInt();
			}
		}
		
		takeUserInput.close();
		
		System.out.println("Here are the numbers:");
		
		for (int i = 0; i < index; i++)
		{
			System.out.print(list[i] + " ");
		}
		
		System.out.println("");
		
		for (int k = index - 1; k >= 0; k--)
		{
			System.out.print(list[k] + " ");
		}
	}
}