package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_LUCK(0, 0);

    private final int matchCount;
    private final long prizeMoney;
    private final boolean matchBonus;

    Rank(int matchCount, long prizeMoney) {
        this(matchCount, prizeMoney, false);
    }

    Rank(int matchCount, long prizeMoney, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.matchBonus = matchBonus;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank checkWinningStatus(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> !rank.matchBonus || matchBonus)
                .findFirst()
                .orElse(NO_LUCK);
    }
}
