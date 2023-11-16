package lotto.domain;

/**
 * 수익률 담고 있는 클래스
 */
public class RateOfReturn {
    private double rateOfReturn;
    private double rateOfReturnPercentage;

    public RateOfReturn() {
    }

    public RateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
        this.rateOfReturnPercentage = rateOfReturn * 100;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public double getRateOfReturnPercentage() {
        return rateOfReturnPercentage;
    }
}
