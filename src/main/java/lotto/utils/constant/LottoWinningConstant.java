package lotto.utils.constant;

public enum LottoWinningConstant {

    FIRST_PLACE(6, 2000000000, false),
    SECOND_PLACE(5, 30000000, true),
    THIRD_PLACE(5, 1500000, false),
    FOURTH_PLACE(4, 50000, false),
    FIFTH_PLACE(3, 5000, false);

    private final int winningCount;
    private final int winningMoney;
    private final boolean isBonusNeeded;

    LottoWinningConstant(int winningCount, int winningMoney, boolean isBonusNeeded) {
        this.winningCount = winningCount;
        this.winningMoney = winningMoney;
        this.isBonusNeeded = isBonusNeeded;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isBonusNeeded() {
        return isBonusNeeded;
    }
}
