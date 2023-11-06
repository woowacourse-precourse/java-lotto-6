package lotto.dto.response;

import lotto.model.LottoResults;

public class LottoResultsDto {

    private final String resultsText;
    private final float profitRate;

    public LottoResultsDto(String resultsText, float profitRate) {
        this.resultsText = resultsText;
        this.profitRate = profitRate;
    }

    public String getResults() {
        return resultsText;
    }

    public float getProfitRate() {
        return profitRate;
    }
}
