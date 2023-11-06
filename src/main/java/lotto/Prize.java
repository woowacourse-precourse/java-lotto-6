package lotto;

public enum Prize {

    First(2_000_000_000),
    Second(30_000_000),
    Third(30_000_000),
    Forth(1_500_000),
    Fifth(5_000);

    private final int money;

    Prize(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
