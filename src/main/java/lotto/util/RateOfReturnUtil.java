package lotto.util;

import static lotto.constant.GeneralConstant.PRIZE_RANK_INDEXES;
import static lotto.constant.GeneralConstant.PRIZE_RANK_MAX;
import static lotto.constant.GeneralConstant.PRIZE_RANK_MONEY;
import static lotto.constant.GeneralConstant.ZERO;

import java.util.List;

public class RateOfReturnUtil {
    public static double calcRateOfReturn(int cost, List<Integer> prizeCounts) {
        long revenue = calcRevenue(prizeCounts);
        return ((double) revenue / cost) * 100;
    }

    private static long calcRevenue(List<Integer> prizeCounts) {
        long revenue = ZERO;
        for(int i = ZERO; i < PRIZE_RANK_MAX; i++) {
            String rank = PRIZE_RANK_INDEXES.get(i);
            revenue += (long) prizeCounts.get(i) * PRIZE_RANK_MONEY.get(rank);
        }
        return revenue;
    }
}
