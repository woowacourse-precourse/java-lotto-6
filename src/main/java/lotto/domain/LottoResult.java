package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<LottoRank, Integer> map;


    public int getLottoCountByRank(LottoRank Rank) {
        return map.getOrDefault(Rank, 0);
    }

    public void updateRankCounts(List<LottoRank> lottoRankList) {
        map = new HashMap<>();
        for (LottoRank lottoRank : lottoRankList) {
            map.put(lottoRank, map.getOrDefault(lottoRank, 0) + 1);
        }
    }

    public double calculateProfit(List<LottoRank> lottoRankList, int money) {
        long sum = lottoRankList.stream()
                .mapToLong(LottoRank::getPrize)
                .sum();
        return (double) (sum * 100) / money;
    }


}
