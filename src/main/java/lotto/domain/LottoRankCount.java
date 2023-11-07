package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRankCount {

    private static final int FIRST_RANK = 1;
    private static final int LAST_RANK = 5;
    private Map<Integer, Integer> rankCounts;

    public LottoRankCount() {
        rankCounts = new HashMap<>();
    }

    public void incrementCount(int rank) {
        if (rank > LAST_RANK || rank < FIRST_RANK) {
            throw new IllegalStateException();
        }
        int currentCount = rankCounts.getOrDefault(rank, 0);
        rankCounts.put(rank, currentCount + 1);
    }

    public int getCount(int rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

}
