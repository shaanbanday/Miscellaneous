package introduction;

import java.util.Scanner;
@SuppressWarnings("unused")
public class ScanningTings {

	public static void main(String[] args) 
	{
		//Initialise Variables
		String firstName;
		String middleName;
		char middleInitial;
		String surname;
		String message;
		String ageString;
		int ageNum;
		
		//Initialise Scanner takeName
		Scanner takeInput = new Scanner(System.in);
		
		//Take first name
		System.out.println("What is your first name?");
		firstName = takeInput.nextLine();
		
		//Take Middle name
		System.out.println("What is your middle name?");
		middleName = takeInput.nextLine();		
		
		//Take surname
		System.out.println("What is your surname?");
		surname = takeInput.nextLine();
		
		//Take Age
		System.out.println("Finally, how old are you");
		ageString = takeInput.nextLine();
		
		//Close scanner
		takeInput.close();
		
		if(checkIfNumeric(ageString) == true) //If the input is an integer
		{
			ageNum = Integer.parseInt(ageString);
			if (middleName.equals("")) //If they don't have a middle name
			{
				message = "Hello " + firstName + " " + surname + "!\nYou are " + ageNum + " years old. Welcome to ICS4U!";
			}
			else //If they do have a middle name
			{
				middleInitial = middleName.charAt(0);
				message = "Hello " + firstName + " " + middleInitial + ". " + surname + "!\nYou are " + ageNum + " years old. Welcome to ICS4U!";
			}
			System.out.println(message);
		}
		else // If the input is not an integer
		{
			message = "Uh oh! You did not input a valid age. Because of your mistake, this program is now terminated. Goodbye";
			System.out.println(message);
		}	
	}
	
	public static boolean checkIfNumeric(String ageString)
	{
		try
		{
			int checker = Integer.parseInt(ageString);
		}
		catch (NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}
}