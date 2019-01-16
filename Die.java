import java.lang.*;
import java.lang.ArrayList;

class Die {
	int sides;
	int value;
	int loadedSide;
	int rollCount = 1;
	double loadedChance;
	boolean isLoaded;
	ArrayList<Integer> history;

	Die(int sides) {
		this.value = (int)(Math.random() * (sides)) + 1;
		this.sides = sides;
		this.rollCount = rollCount;
		this.isLoaded = isLoaded;
		this.loadedChance = loadedChance;
		this.loadedSide = loadedSide;

		ArrayList history = new ArrayList<Integer>();

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
		
		if (!isLoaded) {
			value = (int)(Math.random() * (sides)) + 1;
			rollCount++;
		} else {
			double x = (Math.random() * 100);
			if (x < loadedChance) {
				value = loadedSide;
			} else {
				int tempValue = (int)(Math.random() * (sides)) + 1;
				if (tempValue == loadedSide) {
					while (tempValue == loadedSide) {
						tempValue = (int)(Math.random() * (sides)) + 1;
					}
				}
				if (tempValue != loadedSide) {
					value = tempValue;
				}

			}
		}

		history.add(new Integer(value));
	}

	public void printHistory() {
		for (int i = 0; i < history.size(); i++) {
			System.out.println(history.get(i).value());
		}

		for (Integer num : history) {
			println(num.value());
		}


	}
	
	public int getVal() {
		return value;
	}

	public int getSides() {
		return sides;
	}

	public void load(int whichSideLoaded, double chanceOfLoadedSide) {
		isLoaded = true;
		loadedSide = whichSideLoaded;
		loadedChance = chanceOfLoadedSide;
	}

	public int[] rollDiceTimesEachRolled(int numberOfRolls) {
		int[] timesEachRolled = new int[sides];

		for (int i = 0; i < numberOfRolls; i++) {
			roll();
			timesEachRolled[value - 1] += 1;
		}
		return timesEachRolled;
	}

	public void cummulativeResults(int numberOfRolls){
		System.out.println(numberOfRolls + " times rolled");
		System.out.println("------------------");

		int[] timesEachRolled = rollDiceTimesEachRolled(numberOfRolls);
		double dashesPerPercent = 1.0;

		for (int i = 0; i < timesEachRolled.length; i++) {
			double percentDec = (double)timesEachRolled[i] / (double)numberOfRolls;
			int percent = (int)(Math.round(percentDec * 100) * dashesPerPercent);

			System.out.println((int)(Math.round(percentDec * 100)) + "%");
			System.out.print(i + 1 + ": ");
			for (int j = 0; j < percent; j++) {
				System.out.print("=");
			}
			System.out.println("\n");
		}
	}

	public void determineLoadedDie() {
		boolean dieIsLoaded = false;
		int numberOfRolls = 10000000;
		cummulativeResults(numberOfRolls);
		int[] timesEachRolled = rollDiceTimesEachRolled(numberOfRolls);

		for (int i = 0; i < timesEachRolled.length; i++) {
			if (timesEachRolled[i] > (numberOfRolls / sides) + (numberOfRolls * 0.02)) {
				dieIsLoaded = true;
			}
		}

		if (dieIsLoaded) {
			System.out.println("Die is loaded.");
		} else {
			System.out.println("Die is not loaded.");
		}

	}
}
