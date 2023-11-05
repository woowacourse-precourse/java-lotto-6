package lotto.enums;

import java.text.NumberFormat;
import java.util.Locale;

public enum LottoRank {
	RANK5(3, 5000, false),
	RANK4(4, 50000, false),
	RANK3(5, 1500000, false),
	RANK2(5, 30000000, true),
	RANK1(6, 2000000000, false);

	private int matchingCount;
	private double prizeMoney;
	private boolean bonus;

	LottoRank(int matchingCount, int prizeMoney, boolean bonus) {
		this.matchingCount = matchingCount;
		this.prizeMoney = prizeMoney;
		this.bonus = bonus;
	}

	public static LottoRank getRank(int matchingCount, boolean bonus) {
		for (LottoRank rank : LottoRank.values()) {
			if (rank.getMatchingCount() == matchingCount && rank.isBonus() == bonus) {
				return rank;
			}
		}
		return null;
	}

	public int getMatchingCount() {
		return this.matchingCount;
	}

	public boolean isBonus() {
		return this.bonus;
	}

	public double getPrizeMoney() {
		return this.prizeMoney;
	}

	private String formatPrizeMoney(double prizeMoney) {
		return NumberFormat.getNumberInstance(Locale.KOREA).format(prizeMoney);
	}

	@Override
	public String toString() {
		String prizeMoneyFormatted = formatPrizeMoney(this.prizeMoney);
		if (this.bonus) {
			return this.matchingCount + "개 일치, 보너스 볼 일치 (" + prizeMoneyFormatted + "원)";
		} else {
			return this.matchingCount + "개 일치 (" + prizeMoneyFormatted + "원)";
		}
	}
}
