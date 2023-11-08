package lotto;

public enum Prize {

    First(6, 2_000_000_000L, "2,000,000,000원"),
    Second(5, 30_000_000L, "30,000,000원"),
    Third(5, 1_500_000L, "1,500,000원"),
    Forth(4, 50_000L, "50,000원"),
    Fifth(3, 5_000L, "5,000원"),
    None(null, 0L, "");


    private final Long money;
    private final String moneyString;
    private final Integer count;

    Prize(Integer count, Long money, String moneyString) {
        this.count = count;
        this.money = money;
        this.moneyString = moneyString;
    }

    public Integer getCount() {
        return count;
    }

    public Long getMoney() {
        return money;
    }

    public String getMoneyString() {
        return moneyString;
    }
}
