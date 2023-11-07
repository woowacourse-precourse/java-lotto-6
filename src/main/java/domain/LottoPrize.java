package domain;

public enum LottoPrize {
	FIRST_PRIZE(6, 2_000_000_000),
	SECOND_PRIZE(5, 30_000_000),
	THIRD_PRIZE(5, 1_500_000),
	FOURTH_PRIZE(4, 50_000),
	FIFTH_PRIZE(3, 5_000);

	private final int matchCount;
	private final int prizeMoney;

	LottoPrize(int matchCount, int prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

}
