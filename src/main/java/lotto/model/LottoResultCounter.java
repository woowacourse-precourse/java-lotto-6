package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResultCounter {
    private static final int ONE_COUNT = 1;
    private final Map<WinningInfo, Integer> resultCount;

    public LottoResultCounter() {
        this.resultCount = new HashMap<>();
    }


    public void addResult(WinningInfo winningInfo) {
        if (resultCount.containsKey(winningInfo)) {
            plusOneCount(winningInfo);
            return;
        }
        resultCount.put(winningInfo, ONE_COUNT);
    }

    private void plusOneCount(WinningInfo winningInfo) {
        Integer count = resultCount.get(winningInfo);
        resultCount.put(winningInfo, count + ONE_COUNT);
    }

}
