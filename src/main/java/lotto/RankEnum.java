package lotto;

public enum RankEnum {

	NONE(0, 0),

	FIFTH(3, 5_000),

	FORTH(4, 50_000),

	THIRD(5, 1_500_000),

	SECOND(5, 30_000_000),
	FIRST(6, 2_000_000_000);

	private final int matchCount;
	private final int prize;

	RankEnum(int matchCount, int prize) {
		this.matchCount = matchCount;
		this.prize = prize;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrize() {
		return prize;
	}

	public String getFormattedPrize() {
		return String.format("%,d", prize);
	}

	public boolean hasBonus() {
		return this == RankEnum.SECOND;
	}
}
