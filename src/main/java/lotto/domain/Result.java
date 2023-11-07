package lotto.domain;

import static lotto.constants.constants.NULL_POINTER_EXCEPTION;

import java.util.Map;
import java.util.Set;

public class Result {
    private final Map<Ranks, Integer> rankResult;

    public Result(Map<Ranks, Integer> rankResult) {
        validate(rankResult);
        this.rankResult = rankResult;
    }

    private void validate(Map<Ranks, Integer> rankResult) {
        if (rankResult == null) {
            throw new NullPointerException(NULL_POINTER_EXCEPTION);
        }
    }

    private long sumProfit() {
        long profit = 0L;
        Set<Ranks> ranks = rankResult.keySet();
        for (Ranks rank : ranks) {
            profit += (rank.getPrize() * rankResult.get(rank));
        }
        return profit;
    }

    public float calculateProfitPercent(Cost cost) {
        long profit = sumProfit();
        int costNumber = cost.getCost();
        return (float) profit / costNumber * 100;
    }

}
