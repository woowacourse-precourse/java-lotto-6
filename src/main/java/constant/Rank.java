package constant;

import java.util.Arrays;

public enum Rank {
    FIRST(1, 6, false, 2000000000),
    SECOND(2, 5, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000),
    NONE(0, 0, false, 0);

    private final int rankCode;
    private final int countOfMatch;
    private final boolean hasBonus;
    private final int price;

    Rank(int rankCode, int countOfMatch, boolean hasBonus, int price) {
        this.rankCode = rankCode;
        this.countOfMatch = countOfMatch;
        this.hasBonus = hasBonus;
        this.price = price;
    }


    public static Rank valueOf(int countOfMatch, boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.equal(countOfMatch, hasBonus))
                .findAny()
                .orElse(NONE);
    }

    private boolean equal(int countOfMatch, boolean hasBonus) {
        if (this.countOfMatch == countOfMatch) {
            return this.hasBonus == hasBonus;
        }
        return false;
    }

    @Override
    public String toString() {
        return countOfMatch + "개 일치 " +
                "(" + price + "원) - ";
    }

}

