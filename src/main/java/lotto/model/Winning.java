package lotto.model;

public enum Winning {

    FIFTH(5000),
    FORTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000);

    private final int money;

    Winning(int money) {
        this.money = money;
    }

    public int calculateMoney(int count) {
        return money * count;
    }
}
