import java.lang.*;

class Die {
	int sides;
	int value;
	boolean isLoaded;
	int rollCount = 1;
	double loadedChance;
	int loadedSide;

	Die(int sides) {
		this.sides = sides;
		this.value = (int)(Math.random() * (sides)) + 1;
		this.rollCount = rollCount;
		this.isLoaded = false;
		this.loadedChance = loadedChance;
		this.loadedSide = loadedSide;
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

	public void roll(boolean isLoaded) {
		if (this.isLoaded) {
			value = (int)(Math.random() * (sides)) + 1;
			rollCount++;
		} else {
			double x = (Math.random() * 100);
			if (x < loadedChance) {
				value = loadedSide;
			} else {
				value = (int)((Math.random() * sides) + 1);
			}
		}
	}
	
	public int getVal() {
		return value;
	}

	public int getSides() {
		return sides;
	}

	public void load(int loadedSide, double loadedChance) {
		isLoaded = true;
		loadedSide = this.loadedSide;
		loadedChance = this.loadedChance;
	}

	public int[] rollDiceTimesEachRolled(int numberOfRolls) {
		int[] timesEachRolled = new int[sides];

		for (int i = 0; i < numberOfRolls; i++) {
			if (isLoaded) {
				roll(true);

			} else {
				roll(false);
			}

			timesEachRolled[value - 1] += 1;
		
		}

		return timesEachRolled;
	}

	public void cummulativeResults(int numberOfRolls){
		System.out.println("");

		System.out.println(numberOfRolls + " times rolled");

		System.out.println("------------------");


		int[] timesEachRolled = rollDiceTimesEachRolled(numberOfRolls);


		for (int i = 0; i < timesEachRolled.length; i++) {
			double percentDec = (double)timesEachRolled[i] / (double)numberOfRolls;
			double percent = percentDec * 100;

			System.out.print(i + 1 + ": ");
			for (double j = 0.0; j < percent; j++) {
				System.out.print("-");
			}
			
			System.out.println("\n");
		}
	}

	public boolean determineLoadedDie() {
		int numberOfRolls = 100000;
		cummulativeResults(numberOfRolls);
		int[] timesEachRolled = rollDiceTimesEachRolled(numberOfRolls);
		
		int sum = 0;
		for (int i = 0; i < timesEachRolled.length; i++) {
			if (timesEachRolled[i] > (numberOfRolls / sides) + (numberOfRolls * 0.2)) {
				return true;
			}
		}

		return false;

	}
}