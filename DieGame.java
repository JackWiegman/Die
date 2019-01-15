class DieGame {

	public int rollGetSum (int timesToRoll, Die die) {
		int sum = 0;
		for (int i = 0; i < timesToRoll; i++) {
			die.roll();
			int value = die.getVal();
			sum += value;
		}
		return sum;
	}

}