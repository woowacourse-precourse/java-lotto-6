package lotto.domain;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int numberOfMatches;
    private final boolean bonusIncluded;
    private final long prizeMoney;

    Prize(int numberOfMatches, boolean bonusIncluded, long prizeMoney) {
        this.numberOfMatches = numberOfMatches;
        this.bonusIncluded = bonusIncluded;
        this.prizeMoney = prizeMoney;
    }
}
