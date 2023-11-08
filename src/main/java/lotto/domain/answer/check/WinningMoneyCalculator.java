package lotto.domain.answer.check;

import java.util.Map;
import java.util.Set;

public class WinningMoneyCalculator {
    public static Integer calculateWinnigPrice(Map<Integer, Integer> rankToCount) {
        Set<Integer> keys = rankToCount.keySet();
        int winnigPriceSum = 0;
        for (Integer key : keys) {
            winnigPriceSum += getPrice(key, rankToCount.get(key));
        }
        return winnigPriceSum;
    }

    private static Integer getPrice(Integer rank, Integer count) {
        return 0;
    }
}
