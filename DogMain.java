package testReview;

public class DogMain {

	public static void main(String[] args) 
	{
		Dog sparky = new Dog (2, "Sparky");
		Dog spot = new Dog (4, "Spot");
		Dog digger = new Dog (9, "Digger");
		
		digger.setFriendly(false);
		
		sparky.makeNoise();
		spot.makeNoise();
		digger.makeNoise();
		
		Dog [] sparkyFriends = new Dog [2];
		sparkyFriends [0] = spot;
		sparkyFriends [1] = digger;
		
		sparky.setFriends(sparkyFriends);
	}

}
