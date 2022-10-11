/*
Project: ICS3U
Package: methods
Class: CoinAdder
Programmer: Shaan Banday.
Teacher: Mr. Elliott.
Date Created: 3rd October, 2020.
Program Description: A program in Java, used to calculate the total amount of money the user has, based on what the user inputs. The program
asks for the number of quarters, dimes, nickels, and pennies they have. The program then totals it, and return the amount.
*/
package methods; //launch package

import java.util.Scanner; //import scanner 

public class CoinAdder //start of class
{ 
	//declare constants
	final static double QUARTER = 0.25, DIME = 0.10, NICKEL = 0.05, PENNY = 0.01;
    
	public static double getDollarAmount(String q, String d, String n, String p) //double method used to calculate the total amount of money
    { 
		//convert strings to doubles
		double convertedQ = Double.parseDouble(q); //variable to hold the numerical value of the number of quarters
		double convertedD = Double.parseDouble(d); //variable to hold the numerical value of the number of dimes
		double convertedN = Double.parseDouble(n); //variable to hold the numerical value of the number of nickels
		double convertedP = Double.parseDouble(p); //variable to hold the numerical value of the number of pennies
		
        return (convertedQ * QUARTER) + (convertedD * DIME) + (convertedN * NICKEL) + (convertedP * PENNY); //return the sum of all the coins, each multiplied by their value in relation to $1
    } //end of double method
    
	public static void main(String[] args) //start of main method 
    { 
        Scanner enter = new Scanner(System.in); //create a new scanner called enter
        
        //declare all variables
        String quarters, dimes, nickels, pennies; //integer variables to store the amount of each coin that the user enters
        
        //Tell user about program
        System.out.println("Hello! Welcome to the Coin Calculator in Java.\nPress ENTER to continue."); //prompt user to press enter  
        enter.nextLine(); //execute next line of code
        System.out.println("Input your total coins (make sure it is a positive integer), then press ENTER each time to display the dollar amount: "); //prompt user to enter the amount of coins 
        System.out.println("MAKE SURE IT IS A POSITIVE INTEGER!");
        System.out.println("\nQuarters (25¢): "); //prompt user for quarters first
        quarters = enter.next(); //store whatever the user inputs in the quarters variable
        System.out.println("Dimes (10¢): "); //prompt user for dimes second
        dimes = enter.next(); //store whatever the user inputs in the dimes variable
        System.out.println("Nickels (5¢): "); //prompt user for nickels third
        nickels = enter.next(); //store whatever the user inputs in the nickels variable
        System.out.println("Pennies (1¢): "); //lastly, prompt user for pennies
        pennies = enter.next(); //store whatever the user inputs in the pennies variable
        
        //convert strings to doubles
        double convertedQ = Double.parseDouble(quarters);
		double convertedD = Double.parseDouble(dimes);
		double convertedN = Double.parseDouble(nickels);
		double convertedP = Double.parseDouble(pennies);
        
		//decisions
        if ((convertedQ >= 0) && (convertedD >= 0) && (convertedN >= 0) && (convertedP >= 0)) //if all inputs are greater than, or equal to 0
        {
        	if ((quarters.contains(".")) || (dimes.contains(".")) || (nickels.contains(".")) || (pennies.contains("."))) //if any input contains a decimal
        	{
        		System.out.println("Invalid number of coins. The number of coins cannot contain a decimal"); //print invalid
        	}
        	else //if the input is greater than 0, and contains no decimal
        	{
        		System.out.println("Your total is $" + Math.round(getDollarAmount(quarters, dimes, nickels, pennies)*100.0)/100.0); //print rounded dollar amount
        	}
        }
        else //if any input is any number, less than 0
        {
        	System.out.println("Invalid number of coins. The number of each coin cannot be a negative number."); //print invalid
        }
        enter.close(); //close scanner
    } //end of main method
} //end of class