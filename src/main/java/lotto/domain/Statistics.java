package lotto.domain;

import java.util.Arrays;

public enum Statistics {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    RAIN_CHECK(0, 0);

    private final int reward;
    private final int numberMatchCount;

    Statistics(final int reward, final int numberMatchCount) {
        this.reward = reward;
        this.numberMatchCount = numberMatchCount;
    }

    public static Statistics of(final int numberMatchCount, final boolean isBonus) {
        if (numberMatchCount == 5 && isBonus) {
            return SECOND;
        }
        return Arrays.stream(Statistics.values())
                .filter(statistics -> statistics.isMatch(numberMatchCount))
                .findFirst()
                .orElse(RAIN_CHECK);
    }

    private boolean isMatch(final int numberMatchCount) {
        return this.numberMatchCount == numberMatchCount;
    }
}
