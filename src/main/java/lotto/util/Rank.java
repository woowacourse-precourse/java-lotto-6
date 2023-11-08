package lotto.util;

import java.util.Arrays;

public enum Rank {
	FIFTH(3, false, 5_000),
	FOURTH(4, false, 50_000),
	THIRD(5, false, 1_500_000),
	SECOND(5, true, 30_000_000),
	FIRST(6, false, 2_000_000_000),
	NO_RANK(0, false, 0);

	private final int matchCount;
	private final boolean matchBonusNumber;
	private final int reward;

	Rank(int matchCount, boolean matchBonusBall, int reward) {
		this.matchCount = matchCount;
		this.matchBonusNumber = matchBonusBall;
		this.reward = reward;
	}

	public static Rank getRank(int matchCount, boolean matchBonusNumber) {
		if (SECOND.matchCount == matchCount && SECOND.matchBonusNumber == matchBonusNumber) {
			return SECOND;
		}
		return Arrays.stream(Rank.values())
			.filter(rank -> rank.matchCount == matchCount)
			.filter(rank -> !rank.matchBonusNumber)
			.findFirst()
			.orElse(NO_RANK);
	}

	public int getPrice() {
		return reward;
	}

	public int matchCount() {
		return matchCount;
	}

	public boolean matchBonusNumber() {
		return matchBonusNumber;
	}
}
