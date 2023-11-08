package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoCalculator {
    private List<Integer> matchCounts;
    private List<Integer> ranks;

    private HashMap<Integer, Integer> correctCount = new HashMap<Integer, Integer>() {{
        put(6, 1); // 1등
        put(15, 2); // 2등
        put(5, 3); // 3등
        put(4, 4); // 4등
        put(3, 5); // 5등
    }};
    private HashMap<Integer, Integer> reward = new HashMap<Integer, Integer>() {{
        put(1, 2000000000); // 1등
        put(2, 30000000); // 2등
        put(3, 1500000); // 3등
        put(4, 50000); // 4등
        put(5, 5000); // 5등
    }};

    public LottoCalculator(List<Integer> matchCounts) {
        ranks = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        this.matchCounts = matchCounts;
    }

    public List<Integer> calculateRank() {
        for (int i = 0; i < matchCounts.size(); i++) {
            if (correctCount.get(matchCounts.get((i))) != null) {
                int rank = correctCount.get(matchCounts.get((i))) - 1;
                ranks.set(rank, ranks.get(rank) + 1);
            }
        }
        return ranks;
    }

    public double calculateReturnRate(int inputCost) {
        int returnCost = 0;
        for (int i = 0; i < ranks.size(); i++) {
            returnCost += reward.get(i + 1) * ranks.get(i);
        }
        return ((double) returnCost / inputCost) * 100;

    }
}


