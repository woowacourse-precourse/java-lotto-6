package lotto.constant;

public enum Standard {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_AND_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private int winningCount;
    private int money;

    Standard(int winningCount, int money) {
        this.winningCount = winningCount;
        this.money = money;
    }
}
