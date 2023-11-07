package lotto.model.dto;

public class Yield {
    private int investmen;
    private long totalPrize;
    private double yieldValue;

    public int getInvestmen() {
        return investmen;
    }

    public void setInvestmen(int investmen) {
        this.investmen = investmen;
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public void setTotalPrize(long totalPrize) {
        this.totalPrize = totalPrize;
    }

    public double getYieldValue() {
        return yieldValue;
    }

    public void setYieldValue(double yieldValue) {
        this.yieldValue = yieldValue;
    }
}
