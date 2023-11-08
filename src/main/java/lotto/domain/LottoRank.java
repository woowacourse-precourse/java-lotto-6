package lotto.domain;

public enum LottoRank {

	FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "), // 1등
	SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
	THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
	FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
	FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등
	MISS(0, 0, "");

	LottoRank(int userRank, int winMoney, String message) {
		this.userRank = userRank;
		this.winMoney = winMoney;
		this.message = message;
	}

	private int userRank;
	private int winMoney;
	private String message;

	public static LottoRank value(int userRank, boolean hasBonusNumber) {
		if (userRank < 3) {
			return MISS;
		}

		if (SECOND.isSameCount(userRank) && hasBonusNumber) {
			return SECOND;
		}

		for (LottoRank lottoRank : LottoRank.values()) {
			if (lottoRank.isSameCount(userRank) && lottoRank != SECOND) {
				return lottoRank;
			}
		}
		throw new IllegalArgumentException("[Error] ");
	}

	public boolean isSameCount(int userRank) {
		return this.userRank == userRank;
	}

}
