package lotto.domain;

import java.text.DecimalFormat;
import java.util.Map;

public class Profit {
    public static void showProfit(Map<LottoPrize, Integer> prizeCounts, int money) {
        int totalPrizes = calculateTotalPrize(prizeCounts);
        double profitRate = calculateProfitRate(totalPrizes, money);

        DecimalFormat decimalFormat = new DecimalFormat("#,###.#%");
        String formattedProfitRate = decimalFormat.format(profitRate / 100.0);
        System.out.printf("총 수익률은 %s입니다.", formattedProfitRate);
    }

    private static int calculateTotalPrize(Map<LottoPrize, Integer> prizeCounts) {
        int totalPrizes = 0 ;
        for (LottoPrize prize : prizeCounts.keySet()) {
            totalPrizes += prizeCounts.get(prize) * prize.getPrize();
        }
        return totalPrizes;
    }
    static double calculateProfitRate(int totalPrizes, int money) {
        if (money == 0) {
            return 0.0;
        }
        return (double) totalPrizes / money * 100.0;
    }
}
