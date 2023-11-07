package lotto.model;

public class RateOfReturn {
    private final double rate;

    private RateOfReturn(double rate) {
        this.rate = rate;
    }

    public static RateOfReturn calculate(double profit, double investmentAmount) {
        return new RateOfReturn(profit / investmentAmount);
    }
}