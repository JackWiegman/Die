class DieTester {

	public static void main(String[] args) {
		Die die1 = new Die(6);
		Die die2 = new Die(6);

		//System.out.println(die1.compareDice(die2));
		//System.out.println(die1.isStrictlyLessThan(die2));
		//System.out.println(die1.isStrictlyGreaterThan(die2));

		//die1.cummulativeResults(10);
		//die1.cummulativeResults(100);
		//die1.cummulativeResults(10000);
		//die1.cummulativeResults(1000000);
		//die1.cummulativeResults(1000000000);

		//die1.roll();
		//system.out.println(die1.getVal());

		//System.out.println("STUPID BITCH");
		//die1.cummulativeResults(10000);

		die1.determineLoadedDie();

		int loadedSide = (int)(Math.random() * die1.getSides()) + 1;
		double loadedChance = Math.random() * 100.0;

		die1.load(loadedSide, loadedChance);

		System.out.println("\n");
		die1.determineLoadedDie();
	}

	

}