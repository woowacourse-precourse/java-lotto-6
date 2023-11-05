package lotto.domain;

public class MoneyRate {
    private static final double PERCENTAGE_SCALE_FACTOR = 100.0;

    private final double rate;

    public MoneyRate(TotalAmount totalAmount, Money money) {
        this.rate = PERCENTAGE_SCALE_FACTOR * totalAmount.getTotalAmount() / money.getMoney();
    }

    public double getRate() {
        return rate;
    }
}
