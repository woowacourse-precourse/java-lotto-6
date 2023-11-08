package lotto.domain.prize.statistics;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoGroup;
import lotto.domain.prize.Prize;
import lotto.domain.prize.ranking.PrizeRankingCount;
import lotto.domain.prize.ranking.rule.PrizeRanking;

public class PrizeStatistics {

    private final LottoGroup lottoGroup;
    private final Prize prize;

    public PrizeStatistics(
            final LottoGroup lottoGroup,
            final Prize prize
    ) {
        this.lottoGroup = lottoGroup;
        this.prize = prize;
    }

    public PrizeRankingCount getCountsByPrizeRanking() {
        Map<PrizeRanking, Integer> mapRankingCount = Arrays.stream(PrizeRanking.values())
                .collect(Collectors.toUnmodifiableMap(
                        prizeRanking -> prizeRanking,
                        prizeRanking -> lottoGroup.getPrizeRankingCount(prize, prizeRanking)
                ));

        return new PrizeRankingCount(mapRankingCount);
    }
}
