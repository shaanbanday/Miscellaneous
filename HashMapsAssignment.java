/*
Java™ Project: ICS4U
Package: fileIO
Class: HashMapsAssignment
Programmer: Shaan Banday.

Date Created: Tuesday, 8th February, 2021.
Date Completed: Thursday, 10th February, 2021. 

Description: The following program/class reads a .txt file in the ICS4U Project Folder called "marks.txt". The file has the name of a student,
followed by a list of their marks on 5 tests. This repeats in the file with a new name, followed by five new test marks. The number of students 
can be as large or as small as desired, so long as it follows the aforementioned format. After the class reads the file, it prompts the user for 
a name. If the name matches up with one of the students in the file, then it will display their five test marks, along with an average. After the 
user terminates the program, the entire average for all tests, across all students is displayed. 
*/

package fileIO; //Launch the class from this package named "fileIO"

//Import Requires Java Libraries
import java.io.*; //Import the input and output class, which is necessary for accessing the file
import java.util.HashMap; //Import the HashMap class, which will store the student names as keys and their marks as values
import java.util.Scanner; //Import the Scanner class, which is necessary for reading the contents of the file
import java.util.ArrayList; //Import the ArrayList class, which will hold the set of all HashMap keys

public class HashMapsAssignment //The name of the class
{
	public static void main(String[] args) //The main method is very small, and calls other methods to do all the work
	{
		//Declare all Objects
		HashMap<String, byte[]> studentInfo; //HashMap to store the name of the student as a string, and their marks as a byte array
		/*The string is the key and the byte array is the value. A byte array is used instead of a integer array to save space. 
		 Since HashMaps are all about linear time, it makes sense to further shorten the time complexity with arrays of a smaller 
		 primitive data type */
		
		
		//Read the file
		studentInfo = readFile(); //Execute the readFile method, and set the return to the HashMap studentInfo
		
		//Prompt the user for names and display everything
		promptUser(studentInfo); //Execute the promptUser method, and pass the HashMap as the parameter
	}
	
	private static HashMap<String, byte[]> readFile() throws NumberFormatException //Method throws a NumberFormatException error to handle parsing
	{
		//Declare all Objects
		HashMap<String, byte[]> nameAndMarks = new HashMap<String, byte[]>(); //The HashMap to temporarily store all the names and marks
		
		//Declare all variables
		String line = ""; //String to hold each inputed line from the file
		byte tempParse = 0; //Byte to hold the temporary parsed string (if successful)
		
		//Try and catch statement
		try //Try to open the file
		{
			//Declare all objects
			FileReader accessFile = new FileReader("marks.txt"); //The file reader to open the file called marks.txt
			Scanner fileInput = new Scanner (accessFile); //The scanner to read each line of the file and actually take the input
			
			//Loops
			while (fileInput.hasNext()) //While there is another line to read (i.e., Scanner has not reached the end of the file yet)
			{
				//Declare variables
				byte [] tempMarks = new byte [5]; //Declare and initialise the byte array of size 5 each time a new student's marks has to be read
				
				line = fileInput.next(); //Set the string line to the name the scanner reads
				
				//Loops
				for (int i = 0; i < tempMarks.length; i++) //Run the loop and iterate through each index of the byte array
				{
					tempParse = Byte.parseByte(fileInput.next()); //Try to parse the next read line to a byte
					tempMarks [i] = tempParse; //If the parsing was successful, add the byte to the array at whatever index
				}
				//When this point is reached, line is now still the name of the student and the byte array is now filled with their test marks
				
				nameAndMarks.put(line, tempMarks); //Put the name and the marks array into the HashMap. Both variables will reset afterwards.
			}
			
			//After the while loop is finished, and no more lines have to be read
			fileInput.close(); //Close the scanner, since the file reading is now done, and to prevent a resource leak
			accessFile.close(); //Close the scanner, since the file reading is now done, and to prevent a resource leak
		}
		
		catch (IOException e) //If the file cannot be opened, catch the exception
		{
			//Print the message
			System.out.println("There was an error in reading the file. The file may be missing, or it may have the wrong name. "
					+ "Ensure the file has the name \"marks.txt\""); //Tell user that the file cannot be opened
		}
		
		return nameAndMarks; //Return the filled HashMap to the main method
	}

	private static void promptUser(HashMap<String, byte[]> infoBank) //Method to handle all the logic of prompting the user for names to check marks
	{
		//Declare all Objects
		Scanner userInput = new Scanner (System.in); //Scanner to take the user input to determine which student's marks to look up
		ArrayList <String> nameBank = new ArrayList<String>(); //Re-sizable ArrayList to hold the all the names of the studnet's
		
		//Declare all variable
		boolean exitProgram = false; //Boolean to determine whether to terminate the while loop
		
		nameBank = addToList(infoBank); //Call the addToList method and pass it the parameter of the HashMap. Set the return to the ArrayList
		
		//Loops
		while (!exitProgram) //While the program is still running
		{	
			boolean exitPrompt = false; //Boolean to determine whether to terminate the "would you like to go again" prompt
			
			//Prompt the User for an input
			System.out.println("Type the name of a student below to find their test scores:"); //Print message to ask for name
			String userPrompt = userInput.nextLine(); //Set whatever the user inputs to the String userPrompt
			
			//Loops
			for (int k = 0; k < nameBank.size(); k++) //Run the loop and iterate through the string ArrayList
			{
				//Decisions
				if (userPrompt.equalsIgnoreCase(nameBank.get(k))) //If what the user inputs is one of the names
				{
					//Print the test marks
					System.out.print("\n" + userPrompt + "'s test scores are: "); //Print the students name
					printMarks(infoBank.get(nameBank.get(k))); //Call the printMarks method by passing it the parameter of the respective byte array
					
					//Print the test average
					System.out.println(userPrompt + "'s average on the tests is: " + findAvg(infoBank.get(nameBank.get(k))) + "%."); 
					//Call the method findAvg by passing it the same parameters as the printMarks method
					
					k = nameBank.size(); //Break the for loop
					
					//Loops
					while (!exitPrompt) //"Would you like to go again prompt.
					{
						String yesOrNo = ""; //Initialise string input
						System.out.println("\nWould you like to find the test scores of another student? (Y/N):"); //Prompt user for Y or N
						yesOrNo = userInput.nextLine(); //Take their input, and assign it to a string.
						
						if (yesOrNo.equalsIgnoreCase("Y")) //If the user types in Y
						{
							System.out.println("\nOk."); //Print Message
							exitPrompt = true; //Break loop
						}
						
						else if (yesOrNo.equalsIgnoreCase("N")) //If the user types in N
						{
							System.out.println("\nYou have decided to quit. The class average on all the tests is: " 
									+ classAvg(infoBank, nameBank) + "%."); //Print message for entire class average
							exitPrompt = true; //Break first loop
							exitProgram = true; //Break second loop
						}
						
						else //Otherwise if the user types something else 
						{
							System.out.println("\nSorry, you inputted something wrong. Let's try again."); //Keep them in the while loop
						}
						
					}
				}
				
				else if ((!(userPrompt.equalsIgnoreCase(nameBank.get(k)))) && (k == (nameBank.size() - 1))) //If the user does not input a valid name
				{
					System.out.println("Invalid name entered. Let's try again.\n"); //Inform user of the issue
					k = nameBank.size(); //Break the for loop to try again
				}
				
				else{} //Otherwise, if anything else happens, do nothing
			}
		}
		userInput.close(); //Close the Scanner, to prevent a resource leak
	}
	
	private static ArrayList<String> addToList(HashMap<String, byte[]> toBeIterated) //Method to add all keys of the HashMap to the ArrayList
	{
		//Declare Objects
		ArrayList<String> listOfNames = new ArrayList<String>(); //ArrayList to hold all names
		
		//Loops
		for (String j: toBeIterated.keySet()) //Run the loop and iterate through all the keys of the HashMap
		{
			listOfNames.add(j); //Add the String at whatever index to the ArrayList
		}
		
		return listOfNames; //After everything is added, return the ArrayList back to the promptUser method
	}
	
	private static void printMarks (byte [] markBank) //Method to print all of the marks of someone
	{
		//Loops
		for (int l = 0; l < markBank.length; l++) //Run for loop and iterate through all elements of the array
		{
			if (l < (markBank.length - 1)) //If the loop has not yet reached the last index
			{
				System.out.print(markBank[l] + "%, "); //Print marks horizontally
			}
			
			else //Otherwise, if last index has been reached
			{
				System.out.print("and " + markBank[l] +  "%."); //Print sightly different message
			}
		}
		System.out.println(); //Take care of new input by setting it to a new line
	}
	
	private static float findAvg(byte [] markBank) //Method to find the average of a given student. The parameter is the array of marks passed to it
	{
		//Initialise all variables
		float sum = 0; //Float to hold the sum, and then return back the average. It is a float since there may be decimals
		
		//Loops
		for (int m = 0; m < markBank.length; m++) //Run loop and iterate through all elements of the array
		{
			sum += markBank [m]; //Add the element of the array at the given index to the sum
		}
		
		return sum/markBank.length; //Return the sum, divided by the number of marks (i.e., the average) back to the promptUser method
	}
	
	private static double classAvg(HashMap<String, byte[]> namesAndMarks, ArrayList<String> justNames) //Method to find the entire class average
	{
		//Initialise all variables
		double sum = 0; //Same as before, but this time double to hold the sum, and then return back the average.
		
		for (int n = 0; n < namesAndMarks.size(); n++) //Run loop and iterate through all keys of the HashMaps
		{
			sum += findAvg(namesAndMarks.get(justNames.get(n))); //Find the average of each value, and add the average of those to a new sum
		}
		
		return Math.round((sum / namesAndMarks.size()) * 10) / 10.0; //Return back an average
	}
} //End of class