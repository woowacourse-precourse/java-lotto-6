package lotto.domain;

public enum Prize {
	FIFTH(3, 5_000),
	FOURTH(4, 50_000),
	THIRD(5, 1_500_000),
	SECOND(5, 30_000_000),
	FIRST(6, 2_000_000_000);

	private final int matchAmount;
	private final int prize;

	Prize(int matchAmount, int prize) {
		this.matchAmount = matchAmount;
		this.prize = prize;
	}

	public static int getMinMatchAmount() {
		return FIFTH.matchAmount;
	}

	public static Prize createResult(int matchAmount, boolean bonus) {
		if (matchBonus(matchAmount, bonus)) {
			return SECOND;
		}

		for (Prize prize : values()) {
			if (prize.matchAmount == matchAmount) {
				return prize;
			}
		}
		return null;
	}

	public int getMatchAmount() {
		return this.matchAmount;
	}

	public int getPrize() {
		return this.prize;
	}

	private static boolean matchBonus(int matchAmount, boolean bonus) {
		return matchAmount == SECOND.matchAmount && bonus;
	}
}
