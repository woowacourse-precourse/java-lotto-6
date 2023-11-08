package lotto.controller.dto;

import java.util.Map;
import lotto.domain.ranking.LottoRanking;
import lotto.domain.statistic.Statistic;

public record StatisticDto(
    Map<LottoRanking, Integer> winningResult,
    double earningRate
) {

    public static StatisticDto of(Statistic statistic, double earningRate) {
        return new StatisticDto(statistic.getWinningResult(), earningRate);
    }
}
