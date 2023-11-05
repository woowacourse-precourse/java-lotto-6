package lotto.constant;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(2, false, 0);

    private final int sameNumberCount;
    private final boolean needBonus;
    private final int reward;

    Rank(int sameNumberCount, boolean needBonus, int reward) {
        this.sameNumberCount = sameNumberCount;
        this.needBonus = needBonus;
        this.reward = reward;
    }

    public static Rank of(final int sameNumberCount, final boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.sameNumberCount == sameNumberCount)
                .filter(rank -> !rank.needBonus || hasBonus)
                .findFirst()
                .orElse(NONE);

    }

    public boolean isNeedBonus() {
        return needBonus;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getReward() {
        return reward;
    }
}
