package lotto;

import lotto.exception.ErrorMessage;

public enum LottoResult {

	NONE("0개 일치", 0),
	THREE("3개 일치", 5000),
	FOUR("4개 일치", 50000),
	FIVE("5개 일치", 1500_000),
	FIVE_PLUS_BONUS("5개 일치, 보너스 볼 일치", 30000000),
	SIX("6개 일치", 2000000000);

	private String matchCondition;
	private Integer prize;

	LottoResult(String matchCondition, Integer prize) {
		this.matchCondition = matchCondition;
		this.prize = prize;
	}

	public static LottoResult of(Integer matchCount, Boolean hasBonusNumber) {
		if (matchCount < 3) {
			return NONE;
		}
		if (matchCount == 3) {
			return THREE;
		}
		if (matchCount == 4) {
			return FOUR;
		}
		if (matchCount == 5 && hasBonusNumber) {
			return FIVE_PLUS_BONUS;
		}
		if (matchCount == 5) {
			return FIVE;
		}
		if (matchCount == 6) {
			return SIX;
		}
		throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RESULT);
	}

	public String getMatchCondition() {
		return matchCondition;
	}

	public Integer getPrize() {
		return prize;
	}
}
