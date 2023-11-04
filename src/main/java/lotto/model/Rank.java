package lotto.model;

public enum Rank {
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int matchingNumbers;
    private final int prizeMoney;
    private final boolean bonus;

    Rank(int matchingNumbers, int prizeMoney, boolean bonus) {
        this.matchingNumbers = matchingNumbers;
        this.prizeMoney = prizeMoney;
        this.bonus = bonus;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonus() {
        return bonus;
    }
}
