package lotto.domain;

public enum Prize {
    First(2000000000),
    Second(30000000),
    Third(1500000),
    Fourth(50000),
    Fifth(5000);

    private final int money;

    Prize(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
