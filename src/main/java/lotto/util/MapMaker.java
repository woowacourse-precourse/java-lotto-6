package lotto.util;

import java.util.HashMap;
import java.util.Map;

public class MapMaker {

    static int PRINT_RESULT_COUNT = LottoRules.PRINT_RESULT_COUNT.getValue();
    public static Map<Integer, String> makeWinningAmount() {
        Map<Integer, String> winningAmount = new HashMap<>();
        winningAmount.put(3, " (5,000원)");
        winningAmount.put(4, " (50,000원)");
        winningAmount.put(5, " (1,500,000원)");
        winningAmount.put(6, ", 보너스 볼 일치 (30,000,000원)");
        winningAmount.put(7, " (2,000,000,000원)");
        return winningAmount;
    }

    public static Map<Integer, Integer> makeWinningAmountForCalculation() {
        Map<Integer, Integer> winningAmountForCalculation = new HashMap<>();
        winningAmountForCalculation.put(3, 5000);
        winningAmountForCalculation.put(4, 50000);
        winningAmountForCalculation.put(5, 1500000);
        winningAmountForCalculation.put(6, 30000000);
        winningAmountForCalculation.put(7, 2000000000);
        return winningAmountForCalculation;
    }

    public static Map<Integer, Integer> makeEmptyLottoResultCount() {
        Map<Integer, Integer> lottoResultCount = new HashMap<>();
        for (int i = 0; i < PRINT_RESULT_COUNT; i++) {
            lottoResultCount.put(i + 3, 0);
        }
        return lottoResultCount;
    }

}
