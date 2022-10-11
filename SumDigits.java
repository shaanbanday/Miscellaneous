package testReview;

public class SumDigits {

	public static void main(String[] args) {
		System.out.println(sumOfDigits(3451));
		System.out.println(recur(1));
		System.out.println(recur(4));
		printFun(3);
		System.out.println();
		for (int i = 0; i < 21; i++)
		{
			System.out.println(checkPrime(i, 2));
		}
	}
	
	private static int sumOfDigits(int i)
	{
		if (i < 10)
		{
			return i;
		}
		
		else 
		{
			return (i % 10) + sumOfDigits((i/10));
		}
	}
	
	private static double recur(double term)
	{
		double result = 0;
		
		if (term > 1)
		{
			result = (recur(term - 1)*term*2 + 3);
		}
		
		else
		{
			result = 1;
		}
		return result;
	}
	
	private static void printFun(int test)
    {
        if (test < 1)
        {
            return;
        }
        
        else 
        {
            System.out.print(test + " ");
            printFun(test - 1); 
            System.out.print(test + " ");
            return;
        }
    }
	
	private static boolean checkPrime (int num, int divisor)
	{
		if (num == 0)
		{
			return false;
		}
		
		else if(num == 1)
		{
			return false;
		}
		
		else if (divisor == num)
		{
			return true;
		}
		
		else if ((num % divisor) == 0)
		{
			return false;
		}
		
		else
		{
			return checkPrime(num, divisor + 1);
		}
	}
}