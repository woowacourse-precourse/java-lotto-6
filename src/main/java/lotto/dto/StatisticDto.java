package lotto.dto;

import static lotto.model.LottoRank.FIFTH_RANK;
import static lotto.model.LottoRank.FIRST_RANK;
import static lotto.model.LottoRank.FOURTH_RANK;
import static lotto.model.LottoRank.SECOND_RANK;
import static lotto.model.LottoRank.THIRD_RANK;

import java.util.Collections;
import java.util.Map;
import lotto.model.LottoRank;
import lotto.model.Statistic;

public class StatisticDto {

    private static final Integer DEFAULT_COUNT = 0;

    private final Map<LottoRank, Integer> rank;

    private StatisticDto(final Map<LottoRank, Integer> rank) {
        this.rank = rank;
    }

    public static StatisticDto from(final Statistic statistic) {
        Map<LottoRank, Integer> rank = statistic.getRank();
        return new StatisticDto(Collections.unmodifiableMap(rank));
    }

    public Integer getFifthRankCount() {
        return getRank().getOrDefault(FIFTH_RANK, DEFAULT_COUNT);
    }

    public Integer getFourthRankCount() {
        return getRank().getOrDefault(FOURTH_RANK, DEFAULT_COUNT);
    }

    public Integer getThirdRankCount() {
        return getRank().getOrDefault(THIRD_RANK, DEFAULT_COUNT);
    }

    public Integer getSecondRankCount() {
        return getRank().getOrDefault(SECOND_RANK, DEFAULT_COUNT);
    }

    public Integer getFirstRankCount() {
        return getRank().getOrDefault(FIRST_RANK, DEFAULT_COUNT);
    }

    public Map<LottoRank, Integer> getRank() {
        return Collections.unmodifiableMap(rank);
    }
}
