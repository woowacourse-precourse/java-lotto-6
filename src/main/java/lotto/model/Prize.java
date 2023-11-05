package lotto.model;

public enum Prize {
    PRIZE_FIRST("2,000,000,000"),
    PRIZE_SECOND("30,000,000"),
    PRIZE_THIRD("1,500,000"),
    PRIZE_FOURTH("50,000"),
    PRIZE_FIFTH("5,000");

    private final String money;

    Prize(final String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }
}
