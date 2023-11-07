package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<Integer> counted;
    private final List<Boolean> checked;

    public LottoResult(List<Integer> counted, List<Boolean> checked) {
        this.counted = counted;
        this.checked = checked;
    }

    public double calculateEarningRate(int purchaseMoney) {
        Map<Rank, Integer> result = getFinalResult();
        double profit = result.get(Rank.THREE_MATCH) * Rank.THREE_MATCH.getPrize()
                + result.get(Rank.FOUR_MATCH) * Rank.FOUR_MATCH.getPrize()
                + result.get(Rank.FIVE_MATCH) * Rank.FIVE_MATCH.getPrize()
                + result.get(Rank.FIVE_MATCH_AND_BONUS) * Rank.FIVE_MATCH_AND_BONUS.getPrize()
                + result.get(Rank.SIX_MATCH) * Rank.SIX_MATCH.getPrize();

        return profit / purchaseMoney * 100;
    }

    public Map<Rank, Integer> getFinalResult() {
        Map<Rank, Integer> finalResult = initFinalResult();
        List<Rank> ranks = getRanks();

        for (Rank rank : ranks) {
            finalResult.put(rank, finalResult.getOrDefault(rank, 0) + 1);
        }

        return finalResult;
    }

    public Map<Rank, Integer> initFinalResult() {
        Map<Rank, Integer> finalResult = new HashMap<>();
        finalResult.put(Rank.THREE_MATCH, 0);
        finalResult.put(Rank.FOUR_MATCH, 0);
        finalResult.put(Rank.FIVE_MATCH, 0);
        finalResult.put(Rank.FIVE_MATCH_AND_BONUS, 0);
        finalResult.put(Rank.SIX_MATCH, 0);

        return finalResult;
    }

    public List<Rank> getRanks() {
        List<Rank> ranks = new ArrayList<>();
        for (int i = 0; i < counted.size(); i++) {
            ranks.add(Rank.getRank(counted.get(i), checked.get(i)));
        }
        return ranks;
    }
}