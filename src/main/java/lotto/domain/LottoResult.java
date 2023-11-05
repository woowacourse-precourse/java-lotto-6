package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<LottoRank, Integer> map;


    //TODO 이름수정
    public int getLottoCountByRank(LottoRank Rank) {
        return map.getOrDefault(Rank, 0);
    }

    public Map<LottoRank, Integer> calculateRankCounts(List<LottoRank> lottoRankList) {
        map = new HashMap<>();
        for (LottoRank lottoRank : lottoRankList) {
            map.put(lottoRank, map.getOrDefault(lottoRank, 0) + 1);
        }
        return map;
    }

    public double calculateProfit(List<LottoRank> lottoRankList, int money) {
        int sum = lottoRankList.stream()
                .mapToInt(LottoRank::getPrize)
                .sum();
        return (double) (sum * 100) / money;
    }


}
