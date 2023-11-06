package lotto.dto;

import lotto.domain.Ranking;
import lotto.domain.WinningResult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WinningResultDto {

    private List<RankingDto> rankingDtos;
    private double returnRate;

    public WinningResultDto(WinningResult winningResult) {
        Map<Ranking, Integer> rankingCount = winningResult.getWinningResult();
        this.rankingDtos = Arrays.stream(Ranking.values())
                .map(ranking -> new RankingDto(ranking, rankingCount.get(ranking)))
                .toList();
        this.returnRate = winningResult.getReturnRate();
    }

    public List<RankingDto> getRankingDtos() {
        return rankingDtos;
    }

    public double getReturnRate() {
        return returnRate;
    }
}
