package lotto;

public enum Rank {


    FIRST(2_000_000_000,false,6),
    SECOND(30_000_000,true,5),
    THIRD(1_500_000,false,5),
    FOURTH(50_000,false,4),
    FIFTH(5_000,false,3),
    NO_PRIZE(0,false,0);

    private final int money;
    private final boolean bonus;
    private final int matchCount;

    public boolean isMatchCountEqual(int matchCount) {
        return this.matchCount == matchCount;
    }

    public boolean isBonusEqual(boolean bonus) {
        return this.bonus == bonus;
    }

    Rank(int money, boolean bonus, int matchCount) {
        this.money = money;
        this.bonus = bonus;
        this.matchCount = matchCount;
    }

    public int getMoney() {
        return money;
    }
}
