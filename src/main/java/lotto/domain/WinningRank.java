package lotto.domain;

public enum WinningRank {
	FIRST(2000000000),
	SECOND(30000000),
	THIRD(1500000),
	FOURTH(50000),
	FIFTH(5000),
	FAIL(0);

	private final int profit;

	WinningRank(int profit) {
		this.profit = profit;
	}

	public int getProfit() {
		return profit;
	}

}
