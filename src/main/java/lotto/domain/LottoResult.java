package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {
    private Map<Integer, Integer> winningCount = new LinkedHashMap<>();
    private long totalWinningMoney;

    public LottoResult() {
        addPrizeCount();
        this.totalWinningMoney = 0l;
    }

    private void addPrizeCount() {
        this.winningCount.put(3, 0);
        this.winningCount.put(4, 0);
        this.winningCount.put(5, 0);
        this.winningCount.put(50, 0);
        this.winningCount.put(6, 0);
    }

    public Map<Integer, Integer> getWinningCount() {
        return winningCount;
    }

    public long getTotalWinningMoney() {
        return totalWinningMoney;
    }
}
