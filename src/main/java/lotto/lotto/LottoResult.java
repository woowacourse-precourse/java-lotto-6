package lotto.lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final Map<Integer, Long> PRIZE_MAP = new HashMap<>();
    static {
        PRIZE_MAP.put(1, 2000000000L);
        PRIZE_MAP.put(2, 30000000L);
        PRIZE_MAP.put(3, 1500000L);
        PRIZE_MAP.put(4, 50000L);
        PRIZE_MAP.put(5, 5000L);
        PRIZE_MAP.put(0, 0L);
    }

    private final int rank;
    private final long prize;

    public LottoResult(int rank) {
        validate(rank);
        this.rank = rank;
        this.prize = PRIZE_MAP.get(rank);
    }

    public int getRank() {
        return rank;
    }

    public long getPrize() {
        return prize;
    }

    private void validate(int rank) {
        if (rank < 0 || rank > 5) {
            throw new IllegalStateException();
        }
    }
}
