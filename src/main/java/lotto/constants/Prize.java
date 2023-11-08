package lotto.constants;

public enum Prize {
    FIFTH_PRIZE(3, 5000),
    FOURTH_PRIZE(4, 50000),
    THIRD_PRIZE(5, 1500000),
    FIRST_PRIZE(6, 2000000000),
    SECOND_PRIZE(7, 30000000);

    private final int number;
    private final int winningAmount;

    Prize(int number, int winningAmount) {
        this.number = number;
        this.winningAmount = winningAmount;
    }

    public int getNumber() {
        return number;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

}
