package lotto.model;

import java.util.*;
import lotto.config.WinningResultConfig;

public class WinningResult {
    private Map<WinningResultConfig, List<Result>> winningResults = new LinkedHashMap<>();

    public WinningResult() {
        winningResults.put(WinningResultConfig.THREE, new ArrayList<>(10));
        winningResults.put(WinningResultConfig.FOUR, new ArrayList<>(10));
        winningResults.put(WinningResultConfig.FIVE, new ArrayList<>(10));
        winningResults.put(WinningResultConfig.FIVE_AND_BONUS, new ArrayList<>(10));
        winningResults.put(WinningResultConfig.SIX, new ArrayList<>(10));

    }

    public void addResult(List<Result> results) {
        for (Result result : results) {
            winningResults.get(WinningResultConfig.compareResult(result.getEqualCount(), result.getBonus())).add(result);
        }
    }

    public  Map<WinningResultConfig, List<Result>> getWinningResults() {
        return new LinkedHashMap<>(winningResults);
    }
}
