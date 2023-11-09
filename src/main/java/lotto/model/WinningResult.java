package lotto.model;

import lotto.config.WinningResultConfig;

import java.util.*;

public class WinningResult {
    private final Map<WinningResultConfig, List<Result>> winningResults = new LinkedHashMap<>();

    public WinningResult() {
        Arrays.asList(WinningResultConfig.values()).forEach(config -> winningResults.put(config, new ArrayList<>(10)));
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
