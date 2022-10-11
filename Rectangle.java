package testReview;

public class Rectangle 
{
	private int length;
	private int width;
	
	public Rectangle(int l, int w)
	{
		this.length = l;
		this.width = w;
	}
	
	public double getWidth()
	{
		return (double)this.width;
	}
	
	public double getLength()
	{
		return (double)this.length;
	}
	
	public double getArea()
	{
		return (double)(this.length*this.width);
	}
	
	public double getPerimeter()
	{
		return (double)((2*this.length) + (2*this.width));
	}
	
	public boolean equals (Rectangle r)
	{
		boolean equality;
		
		if ((this.length == r.length) && (this.width == r.width))
		{
			equality = true;
		}
		else 
		{
			equality = false;
		}
		
		return equality;
	}	
}