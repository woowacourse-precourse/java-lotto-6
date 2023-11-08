package lotto.util;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private Map<WinningCase, Integer> winningCount;
    private double earningRate;

    public WinningResult() {
        EnumSet<WinningCase> winningCases = EnumSet.allOf(WinningCase.class);
        winningCount = new HashMap<>();
        winningCases.forEach(winningCase -> winningCount.put(winningCase, 0));
    }

    public void addCount(WinningCase winningCase) {
        winningCount.put(winningCase, winningCount.get(winningCase) + 1);
    }

    public void setEarningRate(int amount) {
        int total = 0;
        for (Map.Entry<WinningCase, Integer> entry : winningCount.entrySet()) {
            total += entry.getValue() * entry.getKey().getPrize();
        }
        earningRate = (double) total / amount * 100;
    }
}
