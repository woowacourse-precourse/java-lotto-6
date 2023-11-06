package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Integer, Integer> ranks;

    public LottoResult() {
        ranks = new HashMap<>();
        init();
    }

    public int get(int value) {
        return ranks.get(value);
    }

    public void add(int rank) {
        if (rank != 0) {
            ranks.put(rank, ranks.get(rank) + 1);
        }
    }

    public boolean contains(int rank) {
        return ranks.containsKey(rank);
    }

    private void init() {
        for (int rank = 1; rank <= 5; rank++) {
            ranks.put(rank, 0);
        }
    }
}
