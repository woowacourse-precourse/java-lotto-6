package lotto;

public enum WinningRank {
	FIRST(6, 2000000000), SECOND(5, 30000000), THIRD(5, 1500000), FOURTH(4, 50000), FIFTH(3, 5000), NONE(0, 0);

	private int matchingNumbers;
	private int winningmoney;

	WinningRank(int matchingNumbers, int winningmoney) {
		this.matchingNumbers = matchingNumbers;
		this.winningmoney = winningmoney;
	}

	public static WinningRank findByMatchingNumbers(int matchingNumbers) {
		for (WinningRank rank : values()) {
			if (matchingNumbers >= rank.matchingNumbers) {
				return rank;
			}
		}
		return NONE;
	}

	public int getWinningmoney() {
		return winningmoney;
	}

}
