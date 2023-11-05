package lotto.dto;

import java.util.List;

public class LottoResultDto {
    private final List<Integer> winResults;
    private final float profitPercentage;

    public LottoResultDto(List<Integer> winResults, float profitPercentage) {
        this.winResults = winResults;
        this.profitPercentage = profitPercentage;
    }

    public List<Integer> getWinResults() {
        return winResults;
    }
    public float getProfitPercentage() {
        return profitPercentage;
    }
}
