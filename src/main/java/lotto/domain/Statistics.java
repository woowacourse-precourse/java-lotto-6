package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Statistics {
    RAIN_CHECK(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

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

    public static List<Statistics> getWithoutDefault() {
        return Arrays.stream(Statistics.values())
                .filter(rank -> !rank.equals(RAIN_CHECK))
                .collect(Collectors.toList());
    }

    private boolean isMatch(final int numberMatchCount) {
        return this.numberMatchCount == numberMatchCount;
    }

    public int getNumberMatchCount() {
        return numberMatchCount;
    }

    public int getReward() {
        return reward;
    }
}
