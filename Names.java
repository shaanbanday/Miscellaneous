package intro;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class Names {

	public static void main(String[] args) throws Exception 
	{
		
		FileReader myFile = new FileReader("names.txt");
        BufferedReader myReader = new BufferedReader(myFile);    

        int i = -1;
        String inputName, firstName = myReader.readLine();  //get first line of text from file
        boolean isCommon = true;
        
        String [] nameBank = new String [100]; 

        while(firstName != null)
        {  
        	i++;
        	nameBank[i] = firstName;
        	firstName = myReader.readLine();  //get next name, returns null if end of file
        }
        
        myReader.close();
        myFile.close();
        
        Scanner takeUserInput = new Scanner(System.in);

        System.out.println("Enter a name to see if it is common or not (case does not matter): ");
        inputName = takeUserInput.next();
        for (int j = 0; j < nameBank.length; j++)
        {
        	if (inputName.equals(nameBank[j]))
        	{
        		isCommon = true;
        	}
        	else 
        	{
        		isCommon = false;
        	}
        }
        takeUserInput.close();
        
        if (isCommon)
        {
        	System.out.println("Yes that is a common name");
        }
        else 
        {
        	System.out.println("No, that is not a common name");
        }
	}
}