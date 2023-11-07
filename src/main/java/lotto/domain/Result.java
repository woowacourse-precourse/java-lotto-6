package lotto.domain;

import static lotto.constants.Constants.NULL_POINTER_EXCEPTION;
import static lotto.constants.Constants.ZERO_PROFIT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.constants.Ranks;

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

    public List<String> fetchMatchResult() {
        List<Ranks> ranks = sortRanks();
        List<String> results = new ArrayList<>();
        ranks.forEach(rank -> results.add(rank.getPresentPrize() + " - " + rankResult.get(rank) + "개"));
        return results;
    }

    private List<Ranks> sortRanks() {
        Ranks[] ranks = Ranks.values();
        Arrays.sort(ranks, Comparator.comparingLong(Ranks::getPrize));
        return Arrays.stream(ranks).filter(rank -> rank.getPrize() != ZERO_PROFIT).toList();
    }

}
