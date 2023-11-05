package lotto.model;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WinningResult {
    private final ConcurrentHashMap<List<Integer>, Winning> winngResult = new ConcurrentHashMap<List<Integer>, Winning>();

    public WinningResult(UserLotto userLotto, List<Long> equalCounts) {
        for (List<Integer> userNumbers : userLotto.getUserNumbers()) {
            winngResult.put(userNumbers, new Winning(equalCounts.get(userLotto.getUserNumbers().indexOf(userNumbers))));
        }
    }

    public ConcurrentHashMap<List<Integer>, Winning> getWinngResult() {
        return new ConcurrentHashMap<>(winngResult);
    }
}
