package lotto.utils.calculator;

import java.util.Map;
import lotto.domain.LottoResults;

public class Calculator {

    private Calculator() {
    }

    public static long calculateWinningAmount(Map<LottoResults, Integer> result) {
        long totalAmount = 0;
        for (LottoResults lottoResults : LottoResults.values()) {
            long winningAmount = lottoResults.getWinningAmount();
            int rankCount = result.getOrDefault(lottoResults, 0);
            totalAmount += winningAmount * rankCount;
        }
        return totalAmount;
    }
}
