package lotto;

import java.util.Locale;
import java.util.Map;
import java.text.NumberFormat;

public class LottoRateOfReturnCalculator {
    public static double calculateRateOfReturn(Map<Prize, Integer> results, int purchaseAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        return (double) totalPrize / purchaseAmount * 100;
    }

    public static void printResults(Map<Prize, Integer> results) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);

        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                String prizeName = prize.getFormattedPrizeName();
                String prizeMoneyFormatted = numberFormat.format(prize.getPrizeMoney());
                int count = results.getOrDefault(prize, 0);
                System.out.println(prizeName + " (" + prizeMoneyFormatted + "원) - " + count + "개");
            }
        }
    }

    private static String formatPrizeMoney(int prizeMoney) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        return numberFormat.format(prizeMoney);
    }

}