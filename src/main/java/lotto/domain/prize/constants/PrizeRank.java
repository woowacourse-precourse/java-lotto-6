package lotto.domain.prize.constants;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

import java.util.Arrays;

public enum PrizeRank {
    HIT_SIX(6, 200_000_000),
    HIT_FIVE_AND_BONUS(5, 30_000_000),
    HIT_FIVE(5, 1_500_000),
    HIT_FOUR(4, 50_000),
    HIT_THREE(3, 5_000),
    HIT_TWO(2, 0),
    HIT_ONE(1, 0),
    HIT_ZERO(0, 0);

    private final int matchingCount;
    private final int prizeAmount;

    PrizeRank(
            int matchingCount,
            int prizeAmount
    ) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
    }

    public static PrizeRank findRank(final int matchingCount) {
        return Arrays.stream(PrizeRank.values())
                .filter(rank -> rank.getMatchingCount() == matchingCount)
                .findFirst()
                .orElseThrow(() -> LottoException.from(ErrorMessage.SYSTEM_CRASHED));
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
