package lotto.domain;

import java.util.Arrays;

public enum Prize {
    NONE(0, 0, false),
    FIFTH(5, 3, false),
    FOURTH(4, 4, false),
    THIRD(3, 5, false),
    SECOND(2, 5, true),
    FIRST(1, 6, false);

    private final int rank;
    private final int mainMatchCount;
    private final boolean isMatchBonus;

    Prize(int rank, int mainMatchCount, boolean isMatchBonus) {
        this.rank = rank;
        this.mainMatchCount = mainMatchCount;
        this.isMatchBonus = isMatchBonus;
    }

    public static Prize findFrom(int mainMatchCount, boolean isMatchBonus) {
        return Arrays.stream(Prize.values()).filter(prize -> prize.equals(mainMatchCount, isMatchBonus))
                .findAny().orElse(NONE);
    }

    private boolean equals(int mainMatchCount, boolean isMatchBonus) {
        return this.mainMatchCount == mainMatchCount && this.isMatchBonus == isMatchBonus;
    }

    public int rank() {
        return this.rank;
    }

    public int mainMatchCount() {
        return this.mainMatchCount;
    }

    public boolean isMatchBonus() {
        return this.isMatchBonus;
    }

}
