package lotto.model;

public enum Ranking {
	ZERO(0),
	ONE(0),
	TWO(0),
	THREE(5_000),
	FOUR(50_000),
	FIVE(1_500_000),
	FIVE_BONUS(30_000_000),
	SIX(2_000_000_000);

	private final int rank;

	Ranking(int rank) {
		this.rank = rank;
	}

	public long getRank() {
		return this.rank;
	}

	public static Ranking getByOrdinal(int ordinal) {
		return Ranking.values()[ordinal];
	}
}
