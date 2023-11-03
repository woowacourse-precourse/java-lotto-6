package lotto;

import java.util.Arrays;

public enum RANK {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    BLANK;

    private int matches;

    RANK() {}
    RANK(int matches) {
        this.matches = matches;
    }

    public static RANK from(int matches, boolean bonusMatched) {
        if (matches == 5) {
            return selectBy(bonusMatched);
        }
        return findRank(matches);
    }

    private static RANK selectBy(boolean bonusMatched) {
        if (bonusMatched) {
            return SECOND;
        }
        return THIRD;
    }

    private static RANK findRank(int matches) {
        return Arrays.stream(RANK.values())
                .filter(rank -> rank.matches == matches)
                .findFirst()
                .orElse(BLANK);
    }
}
