package lotto.domain;

public enum Rank {

    NOTHING(0, 0, false),
    FIFTH(5000, 3, false),
    FORTH(50000, 4, false),
    THIRD(1500000, 5, false),
    SECOND(30000000, 5, true),
    FIRST(2000000000, 6, false);

    private final int prizeMoney;
    private final int count;
    private final boolean bonus;

    Rank(int prizeMoney, int count, boolean bonus) {
        this.prizeMoney = prizeMoney;
        this.count = count;
        this.bonus = bonus;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getPrize() {
        return prizeMoney;
    }
}
