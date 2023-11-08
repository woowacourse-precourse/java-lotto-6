package lotto.utils;

import java.util.Map;
import lotto.domain.Ranking;

public class CalculateUtility {
    public static Long calculatePrizeSum(Map<Ranking, Integer> rankMap) {
        long sum = 0L;
        for (Ranking rank : Ranking.values()) {
            sum += (long) rank.getPrize() * rankMap.get(rank);
        }
        return sum;
    }

}
