package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import lotto.message.LottoResult;

public class GameResult {

    private static final double TO_PERCENTAGE = 100.0;
    private static final int LOTTO_PRICE = 1000;

    private final Map<LottoResult, Integer> winningCount;

    public GameResult(Map<LottoResult, Integer> winningCount) {
        this.winningCount = Collections.unmodifiableMap(winningCount);
    }

    public double getYieldRate(int purchaseQuantity) {
        int purchasePrice = purchaseQuantity * LOTTO_PRICE;
        int totalYield = getTotalYield();

        return TO_PERCENTAGE * totalYield / purchasePrice;
    }

    private int getTotalYield() {
        int totalYield = 0;

        Set<LottoResult> keys = winningCount.keySet();
        for (LottoResult lottoResult : keys) {
            Integer count = winningCount.get(lottoResult);
            totalYield += lottoResult.yield(count);
        }
        return totalYield;
    }

    public Map<LottoResult, Integer> getWinningCount() {
        return winningCount;
    }
}
