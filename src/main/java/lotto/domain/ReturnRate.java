package lotto.domain;

public class ReturnRate {
    private int returnRate;

    public ReturnRate(int returnRate) {
        int percentValue = convertToPercent(returnRate);
        int roundedValue = computeRound(percentValue);
        this.returnRate = roundedValue;
    }

    public int getReturnRate() {
        return returnRate;
    }

    private int convertToPercent(int returnRate) {
        return returnRate * 100;
    }

    private int computeRound(int percentValue) {
        return Math.round(percentValue * 10) / 10;
    }
}
