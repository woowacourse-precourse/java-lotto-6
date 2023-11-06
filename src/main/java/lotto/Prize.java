package lotto;

public enum Prize {

    First(2_000_000_000),
    Second(30_000_000),
    Third(1_500_000),
    Forth(50_000),
    Fifth(5_000),
    None(0);


    private final int money;

    Prize(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
