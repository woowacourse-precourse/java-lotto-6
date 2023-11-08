package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0),
    ;

    private final long matchCount;
    private final int price;

    Rank(final long matchCount, final int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static Rank findBy(final long matchCount, final boolean isBonus) {
        if (matchCount == SECOND.matchCount && isBonus) {
            return SECOND;
        }
        if (matchCount == THIRD.matchCount && !isBonus) {
            return THIRD;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrice() {
        return price;
    }
}
