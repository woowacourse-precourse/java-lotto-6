package lotto.domain.prize;

import java.util.HashMap;
import java.util.Map;

public class PrizeResult {
    private final Map<Prize, Integer> result;

    public PrizeResult() {
        result = new HashMap<>();
    }

    public void addResultCount(Prize prize) {
        result.merge(prize, 1, Integer::sum);
    }

    public int getResultCount(Prize prize) {
        return result.getOrDefault(prize, 0);
    }
}
