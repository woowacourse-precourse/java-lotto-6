package lotto.config;

import java.util.EnumSet;

public enum LottoRank {
	FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개"),
	FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개"),
	THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
	SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
	FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개");

	private final int countOfMatch;
	private final long winningMoney;
	private final String winningMessage;

	LottoRank(int countOfMatch, int winningMoney, String winningMessage) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
		this.winningMessage = winningMessage;
	}

	public long getWinningMoney() {
		return winningMoney;
	}

	public String getWinningMessage() {
		return winningMessage;
	}

	public static LottoRank findRank(int matchCount, boolean matchBonusNumber) {
		if (matchCount == 5) {
			if (matchBonusNumber) {
				return SECOND;
			}

			return THIRD;
		}

		return EnumSet.allOf(LottoRank.class).stream()
			.filter(rank -> rank.countOfMatch == matchCount)
			.findFirst()
			.orElse(null);
	}
}