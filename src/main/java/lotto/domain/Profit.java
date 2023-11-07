package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Profit {
    Map<WinningDetails, Integer> winningResult;
    int totalProfit;

    public Profit() {
        winningResult = new HashMap<>();
        for (WinningDetails winningDetails : WinningDetails.values()) {
            winningResult.put(winningDetails, 0);
        }
        totalProfit = 0;
    }

    public void addResult(WinningDetails winningDetails) {
        if (winningDetails == null) {
            return;
        }
        winningResult.compute(winningDetails, (key, value) -> value + 1);

    }

    public void setTotalProfit() {
        int totalProfit = 0;
        for (WinningDetails winningDetails : WinningDetails.values()) {
            totalProfit += (winningResult.get(winningDetails)) * winningDetails.getPrizeMoney();
        }
        this.totalProfit = totalProfit;
    }
}
