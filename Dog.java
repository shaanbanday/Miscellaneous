package testReview;

public class Dog 
{
	private int age;
	private String name;
	private boolean friendly;
	@SuppressWarnings("unused")
	private Dog[] friends;
	
	public Dog(int a, String n)
	{
		this.age = a;
		
		this.name = n;
		
		this.friendly = true;
	}
	
	public void setFriendly (boolean input)
	{
		this.friendly = input;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public void increaseAge ()
	{
		this.age += 1;
	}
	
	public void setFriends(Dog [] array)
	{
		this.friends = array;
	}
	
	public void makeNoise()  
	{
		if (this.friendly)
		{
			System.out.println(name + " says WOOF");
		}
			
		else
		{
			System.out.println(name + " says GRRRR!!!");
		}
	}	
}