package lotto.domain.prize.statistics;

import java.util.Arrays;
import java.util.EnumMap;
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
        final EnumMap<PrizeRanking, Integer> mapRankingCount = new EnumMap<>(
                Arrays.stream(PrizeRanking.values()).collect(Collectors.toMap(
                        prizeRanking -> prizeRanking,
                        prizeRanking -> lottoGroup.getPrizeRankingCount(prize, prizeRanking),
                        (key1, key2) -> key1,
                        () -> new EnumMap<>(PrizeRanking.class)
                )));

        return new PrizeRankingCount(mapRankingCount);
    }
}
