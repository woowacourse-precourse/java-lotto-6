package lotto.model;

import java.util.*;
import lotto.config.WinningResultConfig;

public class WinningResult {
    private final Map<WinningResultConfig, List<Result>> winningResults = new LinkedHashMap<WinningResultConfig, List<Result>>(){
        {
            winningResults.put(WinningResultConfig.THREE, List.of());
            winningResults.put(WinningResultConfig.FOUR, List.of());
            winningResults.put(WinningResultConfig.FIVE, List.of());
            winningResults.put(WinningResultConfig.FIVE_AND_BONUS, List.of());
            winningResults.put(WinningResultConfig.SIX, List.of());
        }
    };

    public void addResult(List<Result> results) {
        for (Result result : results) {
            winningResults.get(WinningResultConfig.compareResult(result.getEqualCount(), result.getBonus())).add(result);
        }
    }

    public  Map<WinningResultConfig, List<Result>> getWinningResults() {
        return new LinkedHashMap<>(winningResults);
    }
}
