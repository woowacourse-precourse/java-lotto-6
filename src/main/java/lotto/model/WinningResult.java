package lotto.model;

import lotto.config.WinningResultConfig;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

public class WinningResult {
    private final Map<WinningResultConfig, List<Result>> winningResults = new LinkedHashMap<>();

    public WinningResult() {
        winningResults.put(WinningResultConfig.THREE, new ArrayList<>(10));
        winningResults.put(WinningResultConfig.FOUR, new ArrayList<>(10));
        winningResults.put(WinningResultConfig.FIVE, new ArrayList<>(10));
        winningResults.put(WinningResultConfig.FIVE_AND_BONUS, new ArrayList<>(10));
        winningResults.put(WinningResultConfig.SIX, new ArrayList<>(10));
    }

    public void addResult(List<Result> results) {
        for (Result result : results) {
            winningResults.get(WinningResultConfig.findWinningResultConfig(result.getEqualCount(), result.getBonus())).add(result);
        }
    }

    public  Map<WinningResultConfig, List<Result>> getWinningResults() {
        return new LinkedHashMap<>(winningResults);
    }
}
