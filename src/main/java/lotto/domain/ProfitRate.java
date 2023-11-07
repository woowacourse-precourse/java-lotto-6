package lotto.domain;

public class ProfitRate {

    private final double profitRate;

    public ProfitRate(long totalWinning, int deposit) {
        this.profitRate = profitRate(totalWinning, deposit);
    }

    private double profitRate(long totalWinning, int deposit) {
        if (totalWinning < deposit) {
            return ((double) totalWinning / deposit) * 100;
        }
        return ((double) totalWinning / deposit);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
