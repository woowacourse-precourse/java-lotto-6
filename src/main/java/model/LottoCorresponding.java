package model;

public enum LottoCorresponding {

	THREE(5000),
	FOUR(50000),
	FIVE(1500000),
	BONUS(30000000),
	ALL(2000000000);
	
	private final int winnings;

	LottoCorresponding(int winnings) {
		this.winnings=winnings;
	}

	public int getWinnings() {
		return winnings;
	}
}
