package lotto.domain.constant;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, false, 0),
    FIFTH_RANK(3, false, 5000),
    FOURTH_RANK(4, false, 50000),
    THIRD_RANK(5, false, 1500000),
    SECOND_RANK(5, true, 30000000),
    FIRST_RANK(6, false, 2000000000);


    private final int matchCount;
    private final boolean hasBonus;
    private final int price;

    Rank(int matchCount, boolean hasBonus, int price) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.price = price;
    }

    public static Rank of(int matchCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.sameMatchCount(matchCount))
                .filter(rank -> rank.sameHasBonus(hasBonus))
                .findAny()
                .orElse(NOTHING);
    }

    private boolean sameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    private boolean sameHasBonus(boolean hasBonus) {
        return this.hasBonus == hasBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

    public int getPrice() {
        return price;
    }
}
