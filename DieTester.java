class DieTester {

	public static void main(String[] args) {
		Die die1 = new Die(6);
		Die die2 = new Die(6);

		System.out.println(checkSumNotExceedLimit());


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

		//die1.determineLoadedDie();

		int loadedSide = (int)(Math.random() * die1.getSides()) + 1;
		double loadedChance = Math.random() * 100.0;

		die1.load(loadedSide, 50.0);

		die1.printHistory();

		//System.out.println("\n");
		//die1.determineLoadedDie();

		
		

		
	}

	public static boolean checkSumNotExceedLimit() {
		Die die = new Die(6);
		DieGame dieGame = new DieGame();
		int timesToRun = 10000000;

		for (int i = 0; i < timesToRun; i++) {
			int sum = dieGame.rollGetSum(5, die);
			if (sum > 30) {
				return false;
			}
		}
		return true;
	}

	

}