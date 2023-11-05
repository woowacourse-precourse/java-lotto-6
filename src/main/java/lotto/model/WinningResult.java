package lotto.model;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class WinningResult {
    private ConcurrentHashMap<List<String>, Integer> winngResult = new ConcurrentHashMap<List<String>, Integer>(){
        {
            winngResult.put(List.of("3"), 0);
            winngResult.put(List.of("4"), 0);
            winngResult.put(List.of("5"), 0);
            winngResult.put(List.of("5", "보너스 볼"), 0);
            winngResult.put(List.of("6"), 0);
        }
    };

    public WinningResult() {

    }

    public ConcurrentHashMap<List<String>, Integer> getWinngResult() {
        return new ConcurrentHashMap<>(winngResult);
    }
}
