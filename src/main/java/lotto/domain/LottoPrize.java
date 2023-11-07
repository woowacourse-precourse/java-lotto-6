package lotto.domain;

public enum LottoPrize {
	THREE_MATCH(3, 5000),
	FOUR_MATCH(4, 50000),
	FIVE_MATCH(5, 1500000),
	FIVE_MATCH_WITH_BONUS(5, 30000000),
	SIX_MATCH(6, 2000000000);

	private final int matches;
	private final int prize;

	LottoPrize(int matches, int prize) {
		this.matches = matches;
		this.prize = prize;
	}

	public int getMatches() {
		return matches;
	}

	public int getPrize() {
		return prize;
	}
}
