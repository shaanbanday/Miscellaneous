package testReview;

public class RectangleMain {

	public static void main(String[] args) 
	{
		Rectangle [] recArray = new Rectangle [5];
		
		for (int i = 0; i < recArray.length; i++)
		{
			Rectangle temp = new Rectangle((int)((Math.random()*10) + 1), (int)((Math.random()*10) + 1));
			recArray[i] = temp;
			
			System.out.println("Length is: " + temp.getLength());
			System.out.println("Width is: " + temp.getWidth());
		}
		
		int maxIndex = 0;
		double maxArea = recArray[0].getArea();
		
		for (int i = 1; i < recArray.length; i++)
		{
			if (recArray[i].getArea() > maxArea)
			{
				maxArea = recArray[i].getArea();
				maxIndex = i;
			}
		}
		
		System.out.println("Length is: " + recArray[maxIndex].getLength());
		System.out.println("Width is: " + recArray[maxIndex].getWidth());
	}

}
