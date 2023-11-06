package lotto;

public class ProfitRateDto {
    private final double profitRate;

    private ProfitRateDto(double profitRate) {
        this.profitRate = profitRate;
    }

    public ProfitRateDto from(double profitRate) {
        return new ProfitRateDto(profitRate);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
