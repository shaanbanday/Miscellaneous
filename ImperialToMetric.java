/*
Project: ICS3U
Package: methods
Class: ImperialToMetric
Programmer: Shaan Banday.
Teacher: Mr. Elliott.
Date Created: 2nd October, 2020.
Program Description: A program in Java, used to convert lengths from the Imperial System to the Metric System (SI). The conversions included
are inches to centimeters, feet to centimeters, yards to meters, and miles to kilometers.
*/
package methods; //package name

import java.util.Scanner; //import in_out method
public class ImperialToMetric //start of class
{ 
	//declare conversion rate constants
    final static double INCH_CONV = 2.54, FEET_CONV = 30.48, YARD_CONV = 0.9144, MILE_CONV = 1.60934; //each conversion is different
    
    public static double inchToCent(double n) //create double method to convert inches to centimeters
    { 
    	return n * INCH_CONV; //return the multiplication of the inch input by conversion rate
    } //end of inch method
    
    public static double footToCent(double n) //create double method to convert feet to centimeters
    { 
        return n * FEET_CONV; //return the multiplication of the feet input by conversion rate
    } //end of feet method
    
    public static double yardToMeter(double n) //create double method to convert yards to meters
    { 
        return n * YARD_CONV; //return the multiplication of the yard input by conversion rate 
    } //end of yard method
    
    public static double mileToKilo(double n) //create double method to convert miles to kilometers 
    { 
        return n * MILE_CONV; //return the multiplication of the mile input by the conversion
    } //end of mile method
    
    public static void displayMenu() //create void method to display the options
    { 
    	//declare all variables for the message
        String inchMessage = "\n1.\tInches to Centimeters"; //inch to centimeter message
        String feetMessage = "\n2.\tFeet to Centimeters"; //feet to centimeter message
        String yardMessage = "\n3.\tYards to Meters"; //yards to meter message
        String mileMessage = "\n4.\tMiles to Kilometers"; //miles to kilometers message
        System.out.println("Thank you. Please select one of the options for what you want to convert." + 
        inchMessage + feetMessage + yardMessage + mileMessage); //display message
        System.out.println("Enter your choice:"); //prompt user for what conversion they want
    } //end of void method
    
    public static void main(String[] args)  //start of main method
    { 
    	Scanner userInput = new Scanner(System.in);
    	
    	//declare all variables
        double inputLength; //variable to hold whatever the user inputs
        int conversionType; //variable to hold the conversion type
        
        //Introductory statements
        System.out.println("Hello! Welcome to the Imperial to Metric Converter in Java."); //tell user about program
        System.out.println("Please input any length you desire (no fractions), then press ENTER: "); //prompt user for what length they want to convert
        inputLength = userInput.nextDouble(); //store whatever the user inputs into inputLength
        
        //Select the conversion type
        displayMenu(); //display the menu, with all the conversion options
        conversionType = userInput.nextInt(); //whatever the user inputs, store in conversionType
        
        userInput.close();
        
        //Decisions
        switch (conversionType) //switch statement based on what the user selects
        { 
            case 1:  //if 1 is selected
                System.out.println(inputLength + " inches equals " + inchToCent(inputLength) + " centimeters."); //print message 
                break; //break the case, the parameters above are only valid for this month
            case 2: //if 2 is selected
                System.out.println(inputLength + " feet equals " + footToCent(inputLength) + " centimeters."); //print message 
                break; //break the case, the parameters above are only valid for this month
            case 3: //if 3 is selected
                System.out.println(inputLength + " yards equals " + yardToMeter(inputLength) + " meters."); //print message 
                break; //break the case, the parameters above are only valid for this month
            case 4: //if 4 is selected
                System.out.println(inputLength + " miles equals " + mileToKilo(inputLength) + " kilometers."); //print message 
                break; //break the case, the parameters above are only valid for this month
            default:  //default case, if the number is not 1, 2, 3, or 4
                System.out.print("Invaid Conversion Type. Please make sure it is between 1 and 4."); //print message 
        } //end of switch statement
    } //end of main method
} //end of class