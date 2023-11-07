package lotto.domain.wrapper;

public class ProfitRate {

    private final double profitRate;

    private ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public static ProfitRate create(double profitRate) {
        return new ProfitRate(profitRate);
    }
}
