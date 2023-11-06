package lotto.domain;

public class Profit {
    private final long amount;
    private final double rate;

    public Profit(long amount, double rate) {
        this.amount = amount;
        this.rate = rate;
    }

    public long getAmount() {
        return amount;
    }

    public double getRate() {
        return rate;
    }
}
