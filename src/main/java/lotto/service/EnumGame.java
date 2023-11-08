package lotto.service;

public enum EnumGame {
    RANK_1(2000000000 ,6, false),
    RANK_2(30000000, 5, true),
    RANK_3(1500000, 5, false),
    RANK_4(50000, 4, false),
    RANK_5(5000, 3, false);

    private final int MONEY;
    private final int RANK;
    private final boolean IS_BONUS;

    EnumGame(int money, int rank, boolean isBonus) {
        this.MONEY = money;
        this.RANK = rank;
        this.IS_BONUS = isBonus;
    }

    public int getMoney() {
        return MONEY;
    }

    public int getRank() {
        return RANK;
    }

    public boolean isBonus() {
        return IS_BONUS;
    }
}
