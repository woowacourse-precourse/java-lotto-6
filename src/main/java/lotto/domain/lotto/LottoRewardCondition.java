package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoRewardCondition {

    FAIL(0, 0),
    FIFTH_WINNER(3, 5_000L),
    FOURTH_WINNER(4, 50_000L),
    THIRD_WINNER(5, 1_500_000L),
    SECOND_WINNER(5, 30_000_000L),
    FIRST_WINNER(6, 2_000_000_000L);

    private final int winningCount;
    private final long rewardMoney;

    LottoRewardCondition(final int winningCount, final long rewardMoney) {
        this.winningCount = winningCount;
        this.rewardMoney = rewardMoney;
    }

    public long getRewardMoney() {
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
