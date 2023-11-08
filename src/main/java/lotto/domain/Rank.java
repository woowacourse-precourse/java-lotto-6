package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int countOfMatch;
    private final boolean isBonusNumberRequired;
    private final int prizeMoney;

    Rank(int countOfMatch, boolean isBonusNumberRequired, int prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.isBonusNumberRequired = isBonusNumberRequired;
        this.prizeMoney = prizeMoney;
    }

    public static Rank getRank(int countOfMatch, boolean hasBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .filter(rank -> rank.isBonusNumberRequired == hasBonusNumber)
                .findFirst()
                .orElse(null);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
