package lotto.domian;

public enum WinningTable {
    FIRST_PRIZE(2_000_000_000),
    SECOND_PRIZE(30_000_000),
    THIRD_PRIZE(1_500_000),
    FOURTH_PRIZE(50_000),
    FIFTH_PRIZE(5_000),
    NOT_WINNING(0);

    private int winningAmount;

    WinningTable(int winningAmount) {
        this.winningAmount = winningAmount;
    }
}
