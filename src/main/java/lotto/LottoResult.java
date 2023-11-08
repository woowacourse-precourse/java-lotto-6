package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int PERCENT = 100;

    public double calculateEarningRate(int purchaseMoney) {
        Map<Rank, Integer> result = getFinalResult();
        Rank[] ranks = Rank.values();
        double profit = 0;

        for (Rank rank : ranks) {
            profit += result.get(rank) * rank.getPrize();
        }

        return profit / purchaseMoney * PERCENT;
    }

    public Map<Rank, Integer> getFinalResult(List<Rank> ranks) {
        Map<Rank, Integer> finalResult = initFinalResult();

        for (Rank rank : ranks) {
            finalResult.put(rank, finalResult.getOrDefault(rank, 0) + 1);
        }

        return finalResult;
    }

    private Map<Rank, Integer> initFinalResult() {
        Map<Rank, Integer> finalResult = new HashMap<>();
        finalResult.put(Rank.THREE_MATCH, 0);
        finalResult.put(Rank.FOUR_MATCH, 0);
        finalResult.put(Rank.FIVE_MATCH, 0);
        finalResult.put(Rank.FIVE_MATCH_AND_BONUS, 0);
        finalResult.put(Rank.SIX_MATCH, 0);

        return finalResult;
    }
}
