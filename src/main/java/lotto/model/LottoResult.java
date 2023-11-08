package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int ONE_COUNT = 1;
    private final Map<WinningInfo, Integer> resultCount;

    private LottoResult(Map<WinningInfo, Integer> resultCount) {
        this.resultCount = resultCount;
    }

    public static LottoResult of() {
        return new LottoResult(new HashMap<>());
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

    public int getCount(WinningInfo winningInfo) {
        return resultCount.getOrDefault(winningInfo, 0);
    }

    public int calculateWinningAmount(WinningInfo winningInfo) {
        return winningInfo.price * getCount(winningInfo);
    }

}
