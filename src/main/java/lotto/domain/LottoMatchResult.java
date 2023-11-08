package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.dto.LottoMatchResultDto;

public class LottoMatchResult {
    private final Map<Rank, Integer> lottoRankCount;
    private final double profitRate;

    public LottoMatchResult(Map<Rank, Integer> lottoRankCount, double profitRate) {
        this.lottoRankCount = lottoRankCount;
        this.profitRate = profitRate;
    }

    public static LottoMatchResult createLottoMatchResult(List<Rank> lottoRank, Amount spendAmount) {
        Map<Rank, Integer> lottoRankCount = getLottoRankCount(lottoRank);
        double profitRate = getProfitRate(spendAmount, lottoRankCount);
        return new LottoMatchResult(lottoRankCount, profitRate);
    }

    private static double getProfitRate(Amount spendAmount, Map<Rank, Integer> lottoRankCount) {
        Long prizeSum = 0L;
        for (Entry<Rank, Integer> lottoRankIntegerEntry : lottoRankCount.entrySet()) {
            prizeSum += lottoRankIntegerEntry.getKey().getPrize() * lottoRankIntegerEntry.getValue();
        }
        return spendAmount.calculateProfitRate(prizeSum);
    }

    private static Map<Rank, Integer> getLottoRankCount(List<Rank> lottoRanks) {
        Map<Rank, Integer> lottoRankCount = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(lottoRank -> lottoRank, count -> 0));
        for (Rank lottoRank : lottoRanks) {
            lottoRankCount.put(lottoRank, lottoRankCount.get(lottoRank) + 1);
        }
        return lottoRankCount;
    }


    public LottoMatchResultDto toDto() {
        return new LottoMatchResultDto(lottoRankCount, profitRate);
    }
}
