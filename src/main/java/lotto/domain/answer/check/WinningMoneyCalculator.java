package lotto.domain.answer.check;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public final class WinningMoneyCalculator {
    // 총 상금액 계산
    public static Long calculateWinnigPrice(Map<Integer, Integer> rankToCount) {
        Set<Integer> keys = rankToCount.keySet();
        long winnigPriceSum = 0L;
        for (Integer key : keys) {
            winnigPriceSum += getPrice(key, rankToCount.get(key));
        }
        return winnigPriceSum;
    }

    // 각 등수에 해당하는 상금액 계산
    static Long getPrice(Integer rank, Integer count) {
        Long price = Arrays.stream(WinningPolicyCondition.values())
                .filter(winningPolicyCondition -> winningPolicyCondition.rank == rank)
                .map(winningPolicyCondition -> winningPolicyCondition.winningPrice)
                .findFirst().orElse(0L);
        return price * count;
    }
}
