package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class LottoMatchResult {
    private final Map<LottoRank, Integer> lottoRankCount;
    private final double profitRate;

    public LottoMatchResult(Map<LottoRank, Integer> lottoRankCount, double profitRate) {
        this.lottoRankCount = lottoRankCount;
        this.profitRate = profitRate;
    }

    public static LottoMatchResult createLottoMatchResult(List<LottoRank> lottoRanks, Money spendMoney) {
        Map<LottoRank, Integer> lottoRankCount = Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(lottoRank -> lottoRank, count -> 0));
        for (LottoRank lottoRank : lottoRanks) {
            lottoRankCount.put(lottoRank, lottoRankCount.get(lottoRank) + 1);
        }

        float profitRate = getProfitRate(spendMoney, lottoRankCount);
        return new LottoMatchResult(lottoRankCount, profitRate);
    }

}
