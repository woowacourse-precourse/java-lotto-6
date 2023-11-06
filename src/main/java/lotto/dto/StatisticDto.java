package lotto.dto;

import java.util.Collections;
import java.util.Map;
import lotto.model.LottoRank;
import lotto.model.Statistic;

public class StatisticDto {

    private Map<LottoRank, Integer> rank;

    private StatisticDto(Map<LottoRank, Integer> rank) {
        this.rank = rank;
    }

    public static StatisticDto from(final Statistic statistic) {
        Map<LottoRank, Integer> rank = statistic.getRank();
        return new StatisticDto(Collections.unmodifiableMap(rank));
    }

    public Map<LottoRank, Integer> getRank() {
        return rank;
    }
}
