package lotto.domain.dto;

import java.util.Map;
import lotto.domain.entity.Ranking;

public class WinningResultDto {

    private final Map<Ranking, Integer> rankings;
    private final double rateOfReturn;

    public WinningResultDto(final Map<Ranking, Integer> rankings, final double rateOfReturn) {
        this.rankings = rankings;
        this.rateOfReturn = rateOfReturn;
    }

    public Map<Ranking, Integer> getRankings() {
        return rankings;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
