package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    NONE_PRIZE(0, 0, false),
    FIFTH_PRIZE(5_000, 3, false),
    FOURTH_PRIZE(50_000, 4, false),
    THIRD_PRIZE(1_500_000, 5, false),
    SECOND_PRIZE(30_000_000, 5, true),
    FIRST_PRIZE(2_000_000_000, 6, false);

    private final int prize;
    private final int matchCount;
    private final boolean hasBonus;

    Rank(final int prize, final int matchCount, boolean hasBonus) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
    }

    public static Rank createRank(final int matchCount, final boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.countMatch(matchCount) && rank.hasBonus(hasBonus))
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

    private boolean hasBonus(final boolean hasBonus) {
        return this.hasBonus == hasBonus;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
