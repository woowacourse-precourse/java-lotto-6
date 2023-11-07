package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class JudgeCounter {
    private final Map<Integer, Integer> counts;

    public JudgeCounter() {
        this.counts = new HashMap<>();
        for (int rank = 1; rank <= 5; rank++) {
            this.counts.put(rank, 0);
        }
    }

    public void addCount(int rank) {
        this.counts.put(rank, this.counts.get(rank) + 1);
    }

    public int getCount(int rank) {
        return this.counts.getOrDefault(rank, 0);
    }
}
