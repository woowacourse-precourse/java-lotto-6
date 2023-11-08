package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    NONE_PRIZE(0, 0),
    FIFTH_PRIZE(5_000, 3),
    FOURTH_PRIZE(50_000, 4),
    THIRD_PRIZE(1_500_000, 5),
    SECOND_PRIZE(30_000_000, 5),
    FIRST_PRIZE(2_000_000_000, 6);

    private static final int SECOND_MATCH_COUNT = 5;
    private final int prize;
    private final int matchCount;

    Rank(final int prize, final int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public static Rank createRank(final int matchCount, final boolean hasBonus) {
        if (matchCount == SECOND_MATCH_COUNT && hasBonus) {
            return SECOND_PRIZE;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.countMatch(matchCount))
                .findFirst()
                .orElse(NONE_PRIZE);
    }

    public static List<Rank> filterGetPrize() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(NONE_PRIZE))
                .toList();
    }

    private boolean countMatch(final int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
