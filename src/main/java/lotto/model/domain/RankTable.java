package lotto.model.domain;

public enum RankTable {
    THREE( 3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false,  1_500_000),
    BONUS(5, true,  30_000_000),
    SIX(6, false, 2_000_000_000);

    private final int matchNumber;
    private final boolean bonus;
    private final int money;

    RankTable(int matchNumber, boolean bonus, int money) {
        this.matchNumber = matchNumber;
        this.bonus = bonus;
        this.money = money;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getMoney() {
        return money;
    }
}
