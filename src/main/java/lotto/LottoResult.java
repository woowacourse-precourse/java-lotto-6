package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final LinkedHashMap<LottoRanking, Integer> lottoRankingResult;

    private LottoResult(LinkedHashMap<LottoRanking, Integer> lottoRankingResult) {
        this.lottoRankingResult = lottoRankingResult;
    }

    public static LottoResult createByRankings(List<LottoRanking> rankings) {
        LinkedHashMap<LottoRanking, Integer> lottoRankingResult = new LinkedHashMap<>();

        for (LottoRanking ranking : rankings) {
            Integer prevCount = lottoRankingResult.getOrDefault(ranking, 0);
            lottoRankingResult.put(ranking, prevCount + 1);
        }

        return new LottoResult(lottoRankingResult);
    }

    public double calculateProfit(int purchasedAmount) {
        long totalPrize = LottoRanking.calculateTotalPrize(lottoRankingResult);
        return Math.round(((double) totalPrize / purchasedAmount) * 100 * 100) / 100.0;
    }

    public Map<LottoRanking, Integer> getResult() {
        return Map.copyOf(lottoRankingResult);
    }
}
