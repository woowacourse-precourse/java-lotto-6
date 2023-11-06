package lotto.model;

public class ProfitRate {
    private final double rate;

    public ProfitRate(double rate) {
        validate(rate);
        this.rate = rate;
    }

    private void validate(double rate){

    }

    public double getRate() {
        return rate;
    }
}
