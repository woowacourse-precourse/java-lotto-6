package lotto.dto.response;


public class LottoResultsDto {

    private final String resultsText;
    private final float profitRate;

    private LottoResultsDto(String resultsText, float profitRate) {
        this.resultsText = resultsText;
        this.profitRate = profitRate;
    }

    public static LottoResultsDto of(String resultsText, float profitRate) {
        return new LottoResultsDto(resultsText, profitRate);
    }

    public String getResults() {
        return resultsText;
    }

    public float getProfitRate() {
        return profitRate;
    }
}
