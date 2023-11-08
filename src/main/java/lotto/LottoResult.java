package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int PERCENT = 100;

    public double calculateEarningRate(List<Rank> ranks2, int purchaseMoney) {
        Map<Rank, Integer> result = completeResult(ranks2);
        Rank[] ranks = Rank.values();
        double profit = 0;

        for (Rank rank : ranks) {
            profit += result.get(rank) * rank.getPrize();
        }

        return profit / purchaseMoney * PERCENT;
    }

    public Map<Rank, Integer> completeResult(List<Rank> ranks) {
        Map<Rank, Integer> result = initResult();

        for (Rank rank : ranks) {
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }

    private Map<Rank, Integer> initResult() {
        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.THREE_MATCH, 0);
        result.put(Rank.FOUR_MATCH, 0);
        result.put(Rank.FIVE_MATCH, 0);
        result.put(Rank.FIVE_MATCH_AND_BONUS, 0);
        result.put(Rank.SIX_MATCH, 0);

        return result;
    }
}