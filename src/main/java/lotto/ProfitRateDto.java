package lotto;

public class ProfitRateDto {
    private final double profitRate;

    private ProfitRateDto(double profitRate) {
        this.profitRate = profitRate;
    }

    public static ProfitRateDto from(double profitRate) {
        return new ProfitRateDto(profitRate);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
