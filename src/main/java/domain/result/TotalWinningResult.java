package domain.result;

import java.util.EnumMap;
import java.util.Map;

public class TotalWinningResult {
    private final Map<WinningResult, Integer> results = new EnumMap<>(WinningResult.class);

    public TotalWinningResult() {
        for (WinningResult result : WinningResult.values()) {
            results.put(result, 0);
        }
    }

    public void increase(WinningResult result) {
        results.merge(result, 1, Integer::sum);
    }

    public int get(WinningResult result) {
        return results.get(result);
    }
}
