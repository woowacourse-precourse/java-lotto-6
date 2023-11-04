package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoRewardCondition {

    FAIL(0, 0),
    FIFTH_WINNER(3, 5_000),
    FOURTH_WINNER(4, 50_000),
    THIRD_WINNER(5, 1_500_000),
    SECOND_WINNER(5, 30_000_000),
    FIRST_WINNER(6, 2_000_000_000);

    private final int winningCount;
    private final int rewardMoney;

    LottoRewardCondition(final int winningCount, final int rewardMoney) {
        this.winningCount = winningCount;
        this.rewardMoney = rewardMoney;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public boolean isNotFail() {
        return this != FAIL;
    }

    public static LottoRewardCondition findLottoReward(final int winningCount, final boolean hasBonusNumber) {
        if (isSecondWinning(winningCount, hasBonusNumber)) {
            return SECOND_WINNER;
        }
        return compareWithoutBonus(winningCount);
    }

    private static boolean isSecondWinning(final int winningCount, final boolean hasBonusNumber) {
        return hasBonusNumber && winningCount == SECOND_WINNER.winningCount;
    }

    private static LottoRewardCondition compareWithoutBonus(final int winningCount) {
        return Arrays.stream(values())
                .filter(reward -> reward.isSameWinningCount(winningCount) && reward != SECOND_WINNER)
                .findAny()
                .orElse(FAIL);
    }

    private boolean isSameWinningCount(final int winningCount) {
        return winningCount == this.winningCount;
    }
}
