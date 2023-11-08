package lotto.domain;

import static lotto.utils.ConstantValues.LOTTO_NUMBERS_LENGTH;
import static lotto.utils.ErrorMessages.SAME_COUNT_OUT_OF_RANGE;

public enum Prize {
    NO_PRIZE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int sameCount;
    private final int prizeProfit;

    Prize(int sameCount, int prizeProfit) {
        this.sameCount = sameCount;
        this.prizeProfit = prizeProfit;
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getPrizeProfit() {
        return prizeProfit;
    }

    public static boolean canGetPrize(int sameCount) {
        validateSameCount(sameCount);
        return sameCount >= FIFTH.getSameCount();
    }

    public static Prize getPrize(int sameCount, boolean hasBonusNumber) {
        validateSameCount(sameCount);
        if (SECOND.getSameCount() == sameCount) {
            return distinguishSecondOrThird(hasBonusNumber);
        }
        for (Prize prize : values()) {
            if (prize == SECOND || prize == THIRD) {
                continue;
            }
            if (prize.getSameCount() == sameCount) {
                return prize;
            }
        }
        return NO_PRIZE;
    }

    private static void validateSameCount(int sameCount) {
        if (sameCount < NO_PRIZE.getSameCount() || sameCount > FIRST.getSameCount()) {
            throw new IllegalArgumentException(String.format(SAME_COUNT_OUT_OF_RANGE, LOTTO_NUMBERS_LENGTH));
        }
    }

    private static Prize distinguishSecondOrThird(boolean hasBonusNumber) {
        if (hasBonusNumber) {
            return SECOND;
        }
        return THIRD;
    }
}