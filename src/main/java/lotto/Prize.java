package lotto;

public enum Prize {

    First(2_000_000_000, "2,000,000,000원"),
    Second(30_000_000, "30,000,000원"),
    Third(1_500_000, "1,500,000원"),
    Forth(50_000, "50,000원"),
    Fifth(5_000, "5,000원"),
    None(0, "");


    private final int money;
    private final String moneyString;

    Prize(int money, String moneyString) {
        this.money = money;
        this.moneyString = moneyString;
    }

    public int getMoney() {
        return money;
    }

    public String getMoneyString() {
        return moneyString;
    }
}
