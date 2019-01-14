import java.lang.*;

class Die {
	int sides;
	int value;
	int rollCount = 1;
	double loadedChance = 50;

	Die(int sides) {
		this.sides = sides;
		this.value = (int)(Math.random() * (sides)) + 1;
		this.rollCount = rollCount;
	}

	public boolean compareDice(Die die2) {
		if (die2.getVal() == value) {
			return true;
		}
		return false;
	}

	public boolean isStrictlyLessThan(Die die2) {
		if (die2.getVal() > value) {
			return true;
		}
		return false;
	}

	public boolean isStrictlyGreaterThan(Die die2) {
		if (die2.getVal() < value) {
			return true;
		}
		return false;
	}

	public void roll() {
		value = (int)(Math.random() * (sides)) + 1;
		rollCount++;
	}

	public void rollLoaded(int loadedSide) {
		double x = (Math.random() * 100);
		if (x < loadedChance) {
			value = loadedSide;
		} else {
			value = (int)((Math.random() * sides) + 1);
		}
	}
	
	public int getVal() {
		return value;
	}

	public int getSides() {
		return sides;
	}

	public int[] cummulativeResults(int numberOfRolls, boolean loaded){
		System.out.println("");

		System.out.println(numberOfRolls + " times rolled");

		System.out.println("------------------");

		int[] timesEachRolled = new int[sides];

		int loadedSide = (int)(Math.random() * (sides)) + 1;
		System.out.println("loaded side = " + loadedSide);




		for (int i = 0; i < numberOfRolls; i++) {
			if (loaded) {
				rollLoaded(loadedSide);
			} else {
				roll();
			}

			timesEachRolled[value - 1] += 1;
		
		}

		for (int i = 0; i < timesEachRolled.length; i++) {
			double percentDec = (double)timesEachRolled[i] / (double)numberOfRolls;
			double percent = percentDec * 100;

			System.out.print(i + 1 + ": ");
			for (double j = 0.0; j < percent; j++) {
				System.out.print("-");
			}
			
			System.out.println("\n");
		}

		return timesEachRolled;
	}

	public boolean determineLoadedDie() {
		int numberOfRolls = 1000;
		int[] timesEachRolled = cummulativeResults(numberOfRolls, true);
		
		int sum = 0;
		for (int i = 0; i < timesEachRolled.length; i++) {
			if (timesEachRolled[i] > (numberOfRolls / sides) + (numberOfRolls * 0.2)) {
				return true;
			}
		}

		return false;

	}
}

class DieTester {

	public static void main(String[] args) {
		Die die1 = new Die(6);
		Die die2 = new Die(6);

		System.out.println(die1.compareDice(die2));
		System.out.println(die1.isStrictlyLessThan(die2));
		System.out.println(die1.isStrictlyGreaterThan(die2));

		die1.cummulativeResults(10, true);
		die1.cummulativeResults(100, true);
		//die1.cummulativeResults(10000);
		die1.cummulativeResults(1000000, true);
		//die1.cummulativeResults(1000000000);

		//die1.roll();
		//system.out.println(die1.getVal());

		boolean isLoaded = die1.determineLoadedDie();

		if (isLoaded) {
			System.out.println("Die is loaded.");
		} else {
			System.out.println("Die is not loaded.");
		}
	}

}