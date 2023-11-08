package util;

public enum PrizeMoneyUtil {
    PRIZE_MONEY_3MATCH(5000),
    PRIZE_MONEY_4MATCH(50000),
    PRIZE_MONEY_5MATCH(1500000),
    PRIZE_MONEY_5MATCH_BONUS(30000000),
    PRIZE_MONEY_6MATCH(2000000000);
    private final int money;

    PrizeMoneyUtil(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
