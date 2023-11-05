package lotto.model;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class WinningResult {
    private ConcurrentHashMap<Integer, Integer> winngResult = new ConcurrentHashMap<Integer, Integer>(){
        {
            winngResult.put(3, 0);
            winngResult.put(4, 0);
            winngResult.put(5, 0);
            winngResult.put(5, 0);
            winngResult.put(6, 0);
        }
    };

    public WinningResult() {

    }
}
