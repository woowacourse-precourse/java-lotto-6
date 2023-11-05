package lotto.Constants;

public enum PrizeMoney {
    FIFTH_RANK(5000),
    FOURTH_RANK(50000),
    THIRD_RANK(150000),
    SECOND_RANK(30000000),
    FIRST_RANK(2000000000);

    private final int money;

    PrizeMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
