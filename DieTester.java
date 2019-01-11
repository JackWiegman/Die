import java.lang.*;

class Die {
	int sides;
	int value;
	int rollCount = 1;

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
	
	public int getVal() {
		return value;
	}

	public int getSides() {
		return sides;
	}

	public void cummulativeResults(int numberOfRolls){
		System.out.println("");

		System.out.println(numberOfRolls + " times rolled");

		System.out.println("------------------");

		int[] timesEachRolled = new int[sides];


		for (int i = 0; i < numberOfRolls; i++) {
			roll();

			timesEachRolled[value - 1] += 1;
		
		}

		for (int i = 0; i < timesEachRolled.length; i++) {
			double percentDec = (double)timesEachRolled[i] / (double)numberOfRolls;
			double percent = percentDec * 500;

			System.out.print(i + 1 + ": ");
			for (double j = 0.0; j < percent; j++) {
				System.out.print("-");
			}
			
			System.out.println("\n");
		}

		
	}
}

class DieTester {

	public static void main(String[] args) {
		Die die1 = new Die(6);
		Die die2 = new Die(6);
		
		System.out.println(die1.compareDice(die2));
		System.out.println(die1.isStrictlyLessThan(die2));
		System.out.println(die1.isStrictlyGreaterThan(die2));

		die1.cummulativeResults(10);
		die1.cummulativeResults(100);
		die1.cummulativeResults(10000);
		die1.cummulativeResults(1000000);

		//die1.roll();
		//ystem.out.println(die1.getVal());
	}

}