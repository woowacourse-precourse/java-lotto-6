package lotto.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<String> winningCountToString() {
        List<String> result = winningCount.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getMatchingCount()))
                .map(entry -> String.format("%s - %d개", entry.getKey().getScript(), entry.getValue()))
                .collect(Collectors.toList());
        return result;
    }

    public String earningRateToString() {
        return String.format("총 수익률 %.1f%%입니다.", earningRate);
    }
}
