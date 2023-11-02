package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
	NOTHING(0, 0, false, (matchedNumCount, isBonusNumber) -> matchedNumCount < 3),
	FIFTH(5000, 3, false, (matchedNumCount, isBonusNumber) -> matchedNumCount == 3),
	FOURTH(50000, 4, false, (matchedNumCount, isBonusNumber) -> matchedNumCount == 4),
	THIRD(1500000, 5, false, (matchedNumCount, isBonusNumber) -> matchedNumCount == 5 && isBonusNumber == false),
	SECOND(30000000, 5, true, (matchedNumCount, isBonusNumber) -> matchedNumCount == 5 && isBonusNumber == true),
	FIRST(2000000000, 6, false, (matchedNumCount, isBonusNumber) -> matchedNumCount == 6);

	private final int price;
	private final int matchedNumCount;
	private final boolean isBonusNumber;
	private final BiPredicate<Integer, Boolean> matcher;

	LottoRank(int price, int matchedNumCount, boolean isBonusNumber, BiPredicate<Integer, Boolean> matcher) {
		this.price = price;
		this.matchedNumCount = matchedNumCount;
		this.isBonusNumber = isBonusNumber;
		this.matcher = matcher;
	}

	public static LottoRank getLottoRank(final int matchedNumCount, final boolean isBonusNumber) {
		return Arrays.stream(LottoRank.values())
				.filter(lottoRank -> lottoRank.matcher.test(matchedNumCount, isBonusNumber)).findAny().orElse(NOTHING);
	}

	public int getPrice() {
		return price;
	}
}
