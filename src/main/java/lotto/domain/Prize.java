package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prize {
    private Map<PrizeRankConstants, Integer> prizeRankingCountMap;

    public Prize() {
        prizeRankingCountMap = new HashMap<>();
    }

    public Integer getTotalPrizeAmount() {
        return Arrays.asList(PrizeRankConstants.values())
                .stream()
                .filter(rank -> prizeRankingCountMap.containsKey(rank))
                .mapToInt(rank -> prizeRankingCountMap.get(rank) * rank.getEarnings())
                .sum();
    }

    public void increaseCountOf(PrizeRankConstants rank) {

        if (prizeRankingCountMap.containsKey(rank)) {

            Integer count = prizeRankingCountMap.get(rank) + 1;
            prizeRankingCountMap.put(rank, count);

            return;
        }
        prizeRankingCountMap.put(rank, 1);
    }

    public boolean contains(PrizeRankConstants rank) {
        return prizeRankingCountMap.containsKey(rank);
    }

    public Integer getCount(PrizeRankConstants rank) {
        return prizeRankingCountMap.get(rank);
    }
}
