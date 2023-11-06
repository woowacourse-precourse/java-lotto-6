package lotto.condition;

import java.util.Arrays;

public enum Reward {
    SIX(2_000_000_000),
    FIVE_AND_BONUS(30_000_000),
    FIVE(1_500_000),
    FOUR(50_000),
    THREE(5_000);

    private final int numberOfMatches;

    Reward(final int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public static Reward getRewardByNumberOfMatches(int numberOfMatches) {
        return Arrays.stream(values())
                .filter(reward -> reward.numberOfMatches == numberOfMatches)
                .findFirst()
                .orElse(null);
    }
}
