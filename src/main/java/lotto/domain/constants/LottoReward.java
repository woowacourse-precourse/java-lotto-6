package lotto.domain.constants;

import java.util.Arrays;

public enum LottoReward {
    FAIL(0, 0),
    FIFTH_WINNER(3, 5000),
    FOURTH_WINNER(4, 50000),
    THIRD_WINNER(5, 1500000),
    SECOND_WINNER(5, 30000000),
    FIRST_WINNER(6, 2000000000);

    private final int winningCount;
    private final long rewardMoney;

    LottoReward(final int winningCount, final long rewardMoney) {
        this.winningCount = winningCount;
        this.rewardMoney = rewardMoney;
    }

    public long getRewardMoney() {
        return rewardMoney;
    }

    public boolean isNotFail() {
        return this != FAIL;
    }

    public static LottoReward findLottoReward(final int correctNumCount, final boolean hasBonusNumber) {
        if (isSecondWinner(correctNumCount, hasBonusNumber)) {
            return SECOND_WINNER;
        }
        return compareWithoutBonus(correctNumCount);
    }

    private static boolean isSecondWinner(final int winningCount, final boolean hasBonusNumber) {
        return hasBonusNumber && winningCount == SECOND_WINNER.winningCount;
    }

    private static LottoReward compareWithoutBonus(final int count) {
        return Arrays.stream(values())
                .filter(reward -> reward.isSameCorrectNumCount(count) && reward != SECOND_WINNER)
                .findAny()
                .orElse(FAIL);
    }

    private boolean isSameCorrectNumCount(final int count) {
        return count == this.winningCount;
    }
}
