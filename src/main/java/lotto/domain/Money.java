package lotto.domain;

public class Money {
    private static final String COMMA_EVERY_THREE_DIGITS_FORMAT = "%,d";
    private static final int PERCENTAGE_FORMAT = 100;
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getNumberOfPurchase() {
        return money / LOTTO_PRICE;
    }

    public String getMoneyPrintFormat() {
        return String.format(COMMA_EVERY_THREE_DIGITS_FORMAT, this.money);
    }

    public double getReturnRate(double totalPrize) {
        return totalPrize / this.money * PERCENTAGE_FORMAT;
    }
}