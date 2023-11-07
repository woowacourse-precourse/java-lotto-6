package lotto.domain;

public enum Rank {
	ZERO_LOSE(0, 0L, "0"),
	ONE_LOSE(1, 0L, "0"),
	TWO_LOSE(2, 0L, "0"),
	FIFTH(3, 5_000L, "5,000"),
	FOURTH(4, 50_000L, "50,000"),
	THIRD(5, 1_500_000L, "1,500,000"),
	SECOND(5, 30_000_000L, "30,000,000"),
	FIRST(6, 2_000_000_000L, "2,000,000,000");
	
	private final int correctCount;
	private final Long prize;
	private final String prizeText;

	Rank(int correctCount, long prize, String prizeText) {
		this.correctCount = correctCount;
		this.prize = prize;
		this.prizeText = prizeText;
	}
	
	
}
