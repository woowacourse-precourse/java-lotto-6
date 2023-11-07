package lotto.domain;

public enum Prize {
	THREE(3, 5_000),
	FOUR(4, 50_000),
	FIVE(5, 1_500_000),
	FIVEANDBONUS(5, 30_000_000),
	SIX(6, 2_000_000_000);

	private final int matchAmount;
	private final int prize;

	Prize(int matchAmount, int prize) {
		this.matchAmount = matchAmount;
		this.prize = prize;
	}

	public int getMatchAmount() {
		return this.matchAmount;
	}

	public int getPrize() {
		return this.prize;
	}

	public static Prize createResult(int matchAmount, boolean bonus) {
		if (matchAmount == FIVEANDBONUS.matchAmount && bonus) {
			return FIVEANDBONUS;
		}
		for (Prize result : values()) {
			if (result.matchAmount == matchAmount) {
				return result;
			}
		}
		return null;
	}
}
