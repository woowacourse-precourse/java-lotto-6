package lotto.service.dto;

import java.util.Map;
import lotto.domain.Rank;

public record Result(
    int countOfFirst,
    int countOfSecond,
    int countOfThird,
    int countOfForth,
    int countOfFifth,
    float earningRate
) {

    public static Result of(Map<Rank, Integer> totalRankWithCount, float earningRate) {
        int defaultValue = 0;
        return new Result(
                totalRankWithCount.getOrDefault(Rank.FIRST, defaultValue),
                totalRankWithCount.getOrDefault(Rank.SECOND, defaultValue),
                totalRankWithCount.getOrDefault(Rank.THIRD, defaultValue),
                totalRankWithCount.getOrDefault(Rank.FORTH, defaultValue),
                totalRankWithCount.getOrDefault(Rank.FIFTH, defaultValue),
                earningRate
        );
    }
}
