package lotto.domain.lotto;

import java.util.Arrays;

// TODO 단위테스트 작성
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

    public static LottoRewardCondition getCompareResult(final Lotto userLotto, final Lotto winningLotto,
                                                        final int bonusNumber) {
        int winningCount = userLotto.extractSameCount(winningLotto);
        if (winningCount == SECOND_WINNER.winningCount) {
            return compareLottoWithBonus(userLotto, bonusNumber);
        }
        return findLottoReward(winningCount);
    }

    private static LottoRewardCondition compareLottoWithBonus(final Lotto userLotto, final int bonusNumber) {
        if (userLotto.contains(bonusNumber)) {
            return SECOND_WINNER;
        }
        return THIRD_WINNER;
    }

    private static LottoRewardCondition findLottoReward(final int winningCount) {
        return Arrays.stream(values())
                .filter(reward -> reward.isSameWinningCount(winningCount) && reward != SECOND_WINNER)
                .findAny()
                .orElse(FAIL);
    }

    private boolean isSameWinningCount(final int winningCount) {
        return winningCount == this.winningCount;
    }
}
