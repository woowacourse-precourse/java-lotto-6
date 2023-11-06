package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    NOTHING(0, 0, false);

    private final int count;
    private final long prize;
    private final boolean hasBonus;

    Rank(int count, long prize, boolean hasBonus) {
        this.count = count;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    public static Rank of(int count, boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matches(count, hasBonus))
                .findFirst()
                .orElse(Rank.NOTHING);
    }

    public boolean matches(int count, boolean hasBonus) {
        return this.count == count && this.hasBonus == hasBonus;
    }
}