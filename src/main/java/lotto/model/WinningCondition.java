package lotto.model;

public enum WinningCondition {
    RANK_1(6, false, 2000000000),
    RANK_2(5, true, 30000000),
    RANK_3(5, false, 1500000),
    RANK_4(4, false, 50000),
    RANK_5(3, false, 5000);

    private final int winningNumberCount;
    private final boolean containBonusNumber;
    private final int winningAmount;

    WinningCondition(int winningNumberCount, boolean containBonusNumber, int winningAmount) {
        this.winningNumberCount = winningNumberCount;
        this.containBonusNumber = containBonusNumber;
        this.winningAmount = winningAmount;
    }
}
