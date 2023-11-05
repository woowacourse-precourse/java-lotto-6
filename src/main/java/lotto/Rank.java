package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    BLANK;

    private int matches;
    private int amount;

    Rank() {}
    Rank(int matches, int amount) {
        this.matches = matches;
        this.amount = amount;
    }

    public static Rank from(int matches, boolean bonusMatched) {
        if (matches == 5) {
            return selectBy(bonusMatched);
        }
        return findRank(matches);
    }

    private static Rank selectBy(boolean bonusMatched) {
        if (bonusMatched) {
            return SECOND;
        }
        return THIRD;
    }

    private static Rank findRank(int matches) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matches == matches)
                .findFirst()
                .orElse(BLANK);
    }

    public int amountOf(int times) {
        return amount * times;
    }
}
