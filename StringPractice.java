package introduction;

import java.util.Scanner;

public class StringPractice {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		// Part a
		System.out.println("type a word");
		String test = in.nextLine();

		String newS = expand(test);
		System.out.println(newS);

		// Part b
		System.out.println("type a word");
		test = in.nextLine();

		System.out.println(reverse(test));

		// Part c
		System.out.println("type a word");
		test = in.nextLine();

		System.out.println(compact(test));

		// Part d
		System.out.println("type a word");
		test = in.nextLine();

		

		System.out.println("what character do you want to look for");     
		char lookFor = in.nextLine().charAt(0); 

		in.close();
		System.out.println("That character appears " + count(test, lookFor) + " times");

	}

	// Place a hyphen between each letter example: "Buffy" returns "B-u-f-f-y"
	private static String expand(String test) 
	{
		String result = "";
		result += test.charAt(0);
		for (int i = 1; i < test.length(); i++)
		{
			result += "-" + test.charAt(i);
		}
		return result;
	}

	// Reverse the string   "Buffy" returns "yffuB"
	private static String reverse(String test) 
	{
		String result = "";
		
		for (int j = (test.length() - 1); j >= 0 ; j--)
		{
			result += test.charAt(j);
		}

		return result;
	}

	// Remove spaces  "Buffy the wonder dog" returns "Buffythewonderdog"
	private static String compact(String test) 
	{
		String result = "";
		
		for (int k = 0; k < test.length(); k++)
		{
			if (test.charAt(k) != ' ')
			{
				result += test.charAt(k);
			}
			else{
				//do nothing
			}
		}
		result.trim();
		return result;
	}

	// Count the number of occurrences of a letter in a string
	// "Buffy", 'f' --> returns 2
	private static int count(String test, char lookFor) 
	{
		int count = 0;
		for (int l = 0; l < test.length(); l++)
		{
			if (test.charAt(l) == lookFor)
			{
				count++;
			}
			else {
				//do nothing
			}
		}
		return count;
	}
}