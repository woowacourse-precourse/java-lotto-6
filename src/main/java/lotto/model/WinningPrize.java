package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum WinningPrize {
    FIRST_PRIZE(2_000_000_000, 6, BonusStatus.NO_MATTER),
    SECOND_PRIZE(30_000_000, 5, BonusStatus.IS_IN_LOTTO),
    THIRD_PRIZE(1_500_000, 5, BonusStatus.IS_NOT_IN_LOTTO),
    FOURTH_PRIZE(50_000, 4, BonusStatus.NO_MATTER),
    FIFTH_PRIZE(5_000, 3, BonusStatus.NO_MATTER);

    private final long reward;
    private final int matchCount;
    private final BonusStatus bonusStatus;

    WinningPrize(long reward, int matchCount, BonusStatus bonusStatus) {
        this.reward = reward;
        this.matchCount = matchCount;
        this.bonusStatus = bonusStatus;
    }

    public long getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BonusStatus getBonusStatus() {
        return bonusStatus;
    }

    public static Optional<WinningPrize> getWinningPrize(int matchCount, BonusStatus bonusStatus) {
        return Arrays.stream(WinningPrize.values())
                .filter(winningPrize -> winningPrize.getMatchCount() == matchCount && winningPrize.getBonusStatus() == bonusStatus)
                .findAny();
    }
}
