package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Profit {
    Map<WinningDetails, Integer> winningResult;

    public Profit() {
        winningResult = new HashMap<>();
        for (WinningDetails winningDetails : WinningDetails.values()) {
            winningResult.put(winningDetails, 0);
        }
    }

    public void addResult(WinningDetails winningDetails) {
        winningResult.compute(winningDetails, (key, value) -> value + 1);

    }
}
