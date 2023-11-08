package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int PERCENT = 100;
    private final List<Integer> counted;
    private final List<Boolean> checked;

    public LottoResult(List<Integer> counted, List<Boolean> checked) {
        this.counted = counted;
        this.checked = checked;
    }

    public double calculateEarningRate(int purchaseMoney) {
        Map<Rank, Integer> result = getFinalResult();
        Rank[] ranks = Rank.values();

        double profit = 0;
        for (Rank rank : ranks) {
            profit += result.get(rank) * rank.getPrize();
        }

        return profit / purchaseMoney * PERCENT;
    }

    public Map<Rank, Integer> getFinalResult() {
        Map<Rank, Integer> finalResult = initFinalResult();
        List<Rank> ranks = makeRanks();

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

    private List<Rank> makeRanks() {
        List<Rank> ranks = new ArrayList<>();
        for (int i = 0; i < counted.size(); i++) {
            ranks.add(Rank.decideRank(counted.get(i), checked.get(i)));
        }
        return ranks;
    }
}