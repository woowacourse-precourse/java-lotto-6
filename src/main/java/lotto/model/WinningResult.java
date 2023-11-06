package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private final Map<WinningStandard, Integer> winningResult = new HashMap<>();
    ;

    public WinningResult() {
        initialized();
    }

    private void initialized() {
        for (WinningStandard standard : WinningStandard.values()) {
            winningResult.put(standard, 0);
        }
    }

    public void addResult(WinningStandard standard, int count) {
        winningResult.put(standard, winningResult.get(standard) + count);
    }

    public Map<WinningStandard, Integer> getWinningResult() {
        return winningResult;
    }
}
