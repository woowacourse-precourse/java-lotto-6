package lotto.dto;

public record ProfitResponse(
        double lottoProfit
) {
    public double getResponse() {
        return lottoProfit;
    }
}
