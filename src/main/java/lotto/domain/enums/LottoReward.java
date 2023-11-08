package lotto.domain.enums;

import java.util.Arrays;

public enum LottoReward {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchingCount;
    private final long prizeAmount;

    LottoReward(final int matchingCount, final long prizeAmount) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isNotFail() {
        return this != NONE;
    }

    public static LottoReward findLottoReward(final int correctNumCount, final boolean hasBonusNumber) {
        if (isSecondWinner(correctNumCount, hasBonusNumber)) {
            return SECOND;
        }
        return compareWithoutBonus(correctNumCount);
    }

    private static boolean isSecondWinner(final int winningCount, final boolean hasBonusNumber) {
        return hasBonusNumber && winningCount == SECOND.matchingCount;
    }

    private static LottoReward compareWithoutBonus(final int count) {
        return Arrays.stream(values())
                .filter(reward -> reward.isSameCorrectNumCount(count) && reward != SECOND)
                .findAny()
                .orElse(NONE);
    }

    private boolean isSameCorrectNumCount(final int count) {
        return count == this.matchingCount;
    }
}