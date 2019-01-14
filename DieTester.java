class DieTester {

	public static void main(String[] args) {
		Die die1 = new Die(6);
		Die die2 = new Die(6);

		System.out.println(die1.compareDice(die2));
		System.out.println(die1.isStrictlyLessThan(die2));
		System.out.println(die1.isStrictlyGreaterThan(die2));

		die1.cummulativeResults(10);
		die1.cummulativeResults(100);
		//die1.cummulativeResults(10000);
		die1.cummulativeResults(1000000);
		//die1.cummulativeResults(1000000000);

		//die1.roll();
		//system.out.println(die1.getVal());

		die1.load(3, 50.0);

		boolean isLoaded = die1.determineLoadedDie();

		if (isLoaded) {
			System.out.println("Die is loaded.");
		} else {
			System.out.println("Die is not loaded.");
		}
	}

}