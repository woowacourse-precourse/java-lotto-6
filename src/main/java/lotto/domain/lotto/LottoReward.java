package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoReward {

    FAIL(0, true, 0),
    FIFTH_WINNER(3, true, 5_000),
    FOURTH_WINNER(4, true, 50_000),
    THIRD_WINNER(5, true, 1_500_000),
    SECOND_WINNER(5, false, 30_000_000),
    FIRST_WINNER(6, true, 2_000_000_000);

    private final int winningCount;
    private final boolean isNotBonus;
    private final int reward;

    LottoReward(final int winningCount, final boolean isNotBonus, final int reward) {
        this.winningCount = winningCount;
        this.isNotBonus = isNotBonus;
        this.reward = reward;
    }

    public static LottoReward getCompareResult(final Lotto userLotto, final Lotto winningLotto,
                                               final int bonusNumber) {
        int winningCount = userLotto.calculateWinningCount(winningLotto);
        if (winningCount == SECOND_WINNER.winningCount) {
            return compareLottoWithBonus(userLotto, bonusNumber);
        }
        return findLottoReward(winningCount);
    }

    private static LottoReward compareLottoWithBonus(final Lotto userLotto, final int bonusNumber) {
        if (userLotto.contains(bonusNumber)) {
            return SECOND_WINNER;
        }
        return THIRD_WINNER;
    }

    private static LottoReward findLottoReward(final int winningCount) {
        return Arrays.stream(values())
                .filter(reward -> reward.isSameWinningCount(winningCount))
                .findAny()
                .orElse(FAIL);
    }

    private boolean isSameWinningCount(final int winningCount) {
        return winningCount == this.winningCount && isNotBonus;
    }

    public int getPrize() {
        return reward;
    }
}
