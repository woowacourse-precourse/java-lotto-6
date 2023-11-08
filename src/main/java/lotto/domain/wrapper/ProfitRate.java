package lotto.domain.wrapper;

public class ProfitRate {

    private double profitRate;

    private ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public static ProfitRate create(double profitRate) {
        return new ProfitRate(profitRate);
    }

    public void updateProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
