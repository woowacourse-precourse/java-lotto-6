package lotto.domain;

public class ProfitRate {

    private final double profitRate;

    public ProfitRate(long totalWinning, int deposit) {
        this.profitRate = profitRate(totalWinning, deposit);
    }

    private double profitRate(long totalWinning, int deposit) {
        double rate = (double) totalWinning / deposit * 100;
        return Math.round(rate * 100) / 100.0;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
