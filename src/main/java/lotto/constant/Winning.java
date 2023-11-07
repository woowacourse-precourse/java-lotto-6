package lotto.constant;

public enum Winning {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private int money;

    Winning(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
