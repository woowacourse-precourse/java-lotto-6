package lotto.model;

public enum Rank {
    SIX(6, 2000000000),
    FIVE_BONUS(5, 30000000),
    FIVE(5, 1500000),
    FOUR(4, 50000),
    THREE(3, 5000);

    private final int matchingNumbers;
    private final int money;

    Rank(int matchingNumbers, int money) {
        this.matchingNumbers = matchingNumbers;
        this.money = money;
    }

}
