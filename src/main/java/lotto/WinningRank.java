package lotto;

public enum WinningRank {

	FIRST(6, 2000000_000, "6개 일치 (2,000,000,000원) - "), // 1등
	SECOND(5, 30000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
	THIRD(5, 1500_000, "5개 일치 (1,500,000원) - "), // 3등
	FOURTH(4, 50000, "4개 일치 (50,000원) - "), // 4등
	FIFTH(3, 5000, "3개 일치 (5,000원) - "), // 5등
	NONE(0, 0, "");

	private int matchingNumbers;
	private int winningmoney;
	private String message;

	WinningRank(int matchingNumbers, int winningmoney, String message) {
		this.matchingNumbers = matchingNumbers;
		this.winningmoney = winningmoney;
		this.message = message;
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

	public int getMatchingNumbers() {
		return matchingNumbers;
	}

	public String getMessage() {
		return message;
	}

}
