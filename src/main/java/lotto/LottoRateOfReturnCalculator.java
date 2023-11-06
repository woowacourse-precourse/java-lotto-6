package lotto;

import lotto.LottoResultCalculator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.text.NumberFormat;

import static lotto.LottoResultCalculator.getPrizeAmount;

public class LottoRateOfReturnCalculator {

    private static final Map<Integer, Integer> prizeMap = new HashMap<>();
    private static final int BOUNUS_MATCH = 7;
    static {
        prizeMap.put(3, 5_000);
        prizeMap.put(4, 50_000);
        prizeMap.put(5, 1_500_000);
        prizeMap.put(BOUNUS_MATCH, 30_000_000);
        prizeMap.put(6, 2_000_000_000);
    }

    public static double calculateRateOfReturn(Map<Integer, Integer> results, int purchaseAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * prizeMap.getOrDefault(entry.getKey(),0))
                .sum();

        return (double) totalPrize / purchaseAmount * 100;
    }

    public static void printResults(Map<Integer, Integer> results) {
        for (Integer prizeCategory : prizeMap.keySet()) {
            printCategoryResult(prizeCategory, results.getOrDefault(prizeCategory, 0));
        }
    }

    private static void printCategoryResult(Integer prizeCategory, Integer count) {
        String prizeAmountFormatted = getPrizeAmount(prizeCategory);
        if (prizeCategory.equals(BOUNUS_MATCH)) {
            System.out.println("5개 일치, 보너스 볼 일치 (" + prizeAmountFormatted + "원) - " + count + "개");
            return;
        }
        if (prizeCategory >= 3) {
            System.out.println(prizeCategory + "개 일치 (" + prizeAmountFormatted + "원) - " + count + "개");
        }
    }
}