package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    BLANK;

    private int matches;

    Rank() {}
    Rank(int matches) {
        this.matches = matches;
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
}
