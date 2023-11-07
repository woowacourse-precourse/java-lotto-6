package lotto;

public enum Ranking {
	FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "), // 1등
	SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
	THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
	FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
	FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등
	MISS(0, 0, "");

	private int matchCount;
	private int price;
	private String message;

	Ranking(int matchCount, int price, String message) {
		this.matchCount = matchCount;
		this.price = price;
		this.message = message;
	}

	public static Ranking valueOf(int matchCount, boolean matchBonus) {
		if (matchCount < 3) {
			return MISS;
		}
		if (SECOND.setMatchCount(matchCount) && matchBonus) {
			return SECOND;
		}
		for (Ranking rank : values()) {
			if (rank.setMatchCount(matchCount) && rank != SECOND) {
				return rank;
			}
		}
		throw new IllegalArgumentException();
	}

	private boolean setMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}

	public int getPrice() {
		return price;
	}

	public void printMessage(int count) {
		if (this != MISS) {
			LottoView.printMatchMessage(message, count);
		}
	}
}