package lotto.domain;

public enum Prize {
	THREE(3, 5_000),
	FOUR(4, 50_000),
	FIVE(5, 1_500_000),
	FIVEANDBONUS(5, 30_000_000),
	SIX(6, 2_000_000_000);

	private final int matchNumber;
	private final int prize;

	Prize(int matchNumber, int prize) {
		this.matchNumber = matchNumber;
		this.prize = prize;
	}

	public static Prize createResult(int matchNumber, boolean bonus) {
		if (matchNumber == FIVEANDBONUS.matchNumber && bonus) {
			return FIVEANDBONUS;
		}
		for (Prize result : values()) {
			if (result.matchNumber == matchNumber) {
				return result;
			}
		}
		return null;
	}
}
