package lotto.constant;

public enum WinningMoney {
    FIFTH(5_000),
    FOURTH(50_000),
    THIRD(1_500_000),
    SECOND(30_000_000),
    FIRST(2_000_000_000);

    private int money;
    WinningMoney(int money) {
        this.money = money;
    }
    public int getMoney() {
        return money;
    }
}
