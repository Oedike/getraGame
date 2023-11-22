package data;

public class Dice {

	public static int roll() {
		return roll(1,6);
	}
	
	public static int roll(int Min, int Max) {
		int nombreAleatoire = Min + (int)(Math.random() * ((Max - Min) + 1));
		return nombreAleatoire;
	}
}
