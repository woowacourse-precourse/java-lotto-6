package lotto.domain;


public enum LottoRank {
    ZERO(0, false, 0),
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 150000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private final int count;
    private final boolean checkBonus;
    private final int winningAmount;

    LottoRank(int count, boolean checkBonus, int winningAmount) {
        this.count = count;
        this.checkBonus = checkBonus;
        this.winningAmount = winningAmount;
    }
}
