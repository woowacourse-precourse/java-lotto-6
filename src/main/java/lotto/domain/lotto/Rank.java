package lotto.domain.lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIRST(2_000_000_000L, 6, false),
    SECOND(30_000_000L, 5, true),
    THIRD(1_500_000L, 5, false),
    FOURTH(50_000L, 4, false),
    FIFTH(5_000L, 3, false),
    MISS(0L, 0, false);

    private final long prize;
    private final int matchCount;
    private final boolean matchBonus;

    Rank(long prize, int matchCount, boolean matchBonus) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public static Rank of(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> isSameMatchPoint(matchCount, matchBonus, rank))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean isSameMatchPoint(int matchCount, boolean matchBonus, Rank rank) {
        return rank.matchCount == matchCount && rank.matchBonus == matchBonus;
    }


    public long getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }
}
