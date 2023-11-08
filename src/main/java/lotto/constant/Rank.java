package lotto.constant;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false);
    private final int sameCount;
    private final int money;
    private final boolean bonus;

    Rank(int sameCount, int money, boolean bonus) {
        this.sameCount = sameCount;
        this.money = money;
        this.bonus = bonus;
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getMoney() {
        return money;
    }

    public boolean isBonus() {
        return bonus;
    }
}
