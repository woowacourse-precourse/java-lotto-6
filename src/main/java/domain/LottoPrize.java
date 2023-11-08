package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoPrize {
	FIRST_PRIZE(6, 2_000_000_000),
	SECOND_PRIZE(5, 30_000_000),
	THIRD_PRIZE(5, 1_500_000),
	FOURTH_PRIZE(4, 50_000),
	FIFTH_PRIZE(3, 5_000),
	BLANK(2, 0);

	private final int matchCount;
	private final int prizeMoney;

	LottoPrize(int matchCount, int prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

	public static LottoPrize getLottoPrizeType(long matchCount, boolean matchBonusNumber) {
		if (isFirstPrize(matchCount)) {
			return FIRST_PRIZE;
		} else if (isSecondPrize(matchCount) && matchBonusNumber) {
			return SECOND_PRIZE;
		} else if (isThirdPrize(matchCount)) {
			return THIRD_PRIZE;
		} else if (isFourthPrize(matchCount)) {
			return FOURTH_PRIZE;
		} else if (isFifthPrize(matchCount)) {
			return FIFTH_PRIZE;
		}
		return BLANK;
	}

	private static boolean isFirstPrize(long matchCount) {
		return matchCount == FIRST_PRIZE.matchCount;
	}

	private static boolean isSecondPrize(long matchCount) {
		return matchCount == SECOND_PRIZE.matchCount;
	}

	private static boolean isThirdPrize(long matchCount) {
		return matchCount == THIRD_PRIZE.matchCount;
	}

	private static boolean isFourthPrize(long matchCount) {
		return matchCount == FOURTH_PRIZE.matchCount;
	}

	private static boolean isFifthPrize(long matchCount) {
		return matchCount == FIFTH_PRIZE.matchCount;
	}

	public static List<LottoPrize> getLottoPrizesInReverseOrderWithoutBlank() {
		List<LottoPrize> validPrizes = Arrays.stream(values())
				.filter(prize -> prize != BLANK)
				.collect(Collectors.toList());

		Collections.reverse(validPrizes);

		return validPrizes;
	}
}
