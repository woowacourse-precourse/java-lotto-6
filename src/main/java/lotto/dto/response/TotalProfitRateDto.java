package lotto.dto.response;

import lotto.model.TotalProfitRate;

public class TotalProfitRateDto {
    private final double totalProfitRate;

    private TotalProfitRateDto(double totalProfitRate) {
        this.totalProfitRate = totalProfitRate;
    }

    public static TotalProfitRateDto from(TotalProfitRate totalProfitRate) {
        double profitRate = totalProfitRate.getProfitRate();

        return new TotalProfitRateDto(profitRate);
    }

    public double getTotalProfitRate() {
        return totalProfitRate;
    }
}
