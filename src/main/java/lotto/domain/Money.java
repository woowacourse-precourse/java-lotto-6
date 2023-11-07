package lotto.domain;

public class Money {
    private static final String COMMA_EVERY_THREE_DIGITS_FORMAT = "%,d";
    private static final double PERCENTAGE_FORMAT = 100;
    private static final int LOTTO_PRICE = 1000;
    private final long money;

    public Money(long money) {
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public long getNumberOfPurchase() {
        return money / LOTTO_PRICE;
    }

    public String getMoneyPrintFormat() {
        return String.format(COMMA_EVERY_THREE_DIGITS_FORMAT, this.money);
    }

    public double getReturnRate(long totalPrize) {
        return PERCENTAGE_FORMAT * totalPrize / this.money;
    }
}