package lotto.dto;

import lotto.domain.Ranking;

import java.util.Map;

public class WinningResultDto {

    private Map<Ranking, Integer> rankingCount;
    private double returnRate;

    public WinningResultDto(Map<Ranking, Integer> rankingCount, double returnRate) {
        this.rankingCount = rankingCount;
        this.returnRate = returnRate;
    }

    public int getRankingCount(Ranking ranking) {
        return rankingCount.get(ranking);
    }

    public double getReturnRate() {
        return returnRate;
    }
}
