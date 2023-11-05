package lotto;

public enum Ranking {
	FIRST(6, 2_000_000_000), // 1등
    SECOND(5, 30_000_000), // 2등
    THIRD(5, 1_500_000), // 3등
    FOURTH(4, 50_000), // 4등
    FIFTH(3, 5_000), // 5등
    NONE(0, 0);

	private int matchCount;
	private int price;
	
	Ranking(int matchCount, int price) {
		this.matchCount = matchCount;
		this.price = price;
	}
	
	
	public static Ranking valueOf(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return NONE;
        }
        if (SECOND.isMatchBonus(matchCount) && matchBonus) {
            return SECOND;
        }
        for (Ranking rank : values()) {
            if (rank.isMatchBonus(matchCount) && rank != SECOND) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }
	
	private boolean isMatchBonus(int matchCount) {
		return this.matchCount == matchCount;
	}
	
}