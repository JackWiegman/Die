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

	public void trackedPecentages(int numberToRoll){
		int[] rolls = new int[numberToRoll];
		int[] rollOccurences = new int[sides]; 
		int currentRollOccurence = 0;

		for(int i = 0; i < numberToRoll; i++){
			roll();
			rolls[i] = value;
		}
		for(int side = 1; side < sides; side++){
			for(int rollSpot = 0; rollSpot < rolls.length; rollSpot++){
				if(rolls[rollSpot] == side){
					currentRollOccurence += 1;
				} 
			}
			rollOccurences[side] = currentRollOccurence;
		}

		for (int i = 0; i < rolls.length; i++) {
			System.out.println(rolls[i]);
		}

		System.out.println("------------------------------------------------");

		for (int i = 0; i < rollOccurences.length; i++) {
			System.out.println(rollOccurences[i]);
		}
		
	}
}

class DieTester {

	public static void main(String[] args) {
		Die die1 = new Die(6);
		System.out.println(die1.getVal());
		Die die2 = new Die(6);
		System.out.println(die2.getVal());

		System.out.println(die1.compareDice(die2));
		System.out.println(die1.isStrictlyLessThan(die2));
		System.out.println(die1.isStrictlyGreaterThan(die2));

		die1.trackedPecentages(10);

		die1.roll();
		System.out.println(die1.getVal());
	}

}