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

    private final Map<LottoRank, Integer> result;

    private StatisticDto(final Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public static StatisticDto from(final Statistic statistic) {
        Map<LottoRank, Integer> result = statistic.getResult();
        return new StatisticDto(Collections.unmodifiableMap(result));
    }

    public Integer getFifthRankCount() {
        return getResult().getOrDefault(FIFTH_RANK, DEFAULT_COUNT);
    }

    public Integer getFourthRankCount() {
        return getResult().getOrDefault(FOURTH_RANK, DEFAULT_COUNT);
    }

    public Integer getThirdRankCount() {
        return getResult().getOrDefault(THIRD_RANK, DEFAULT_COUNT);
    }

    public Integer getSecondRankCount() {
        return getResult().getOrDefault(SECOND_RANK, DEFAULT_COUNT);
    }

    public Integer getFirstRankCount() {
        return getResult().getOrDefault(FIRST_RANK, DEFAULT_COUNT);
    }

    public Map<LottoRank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
