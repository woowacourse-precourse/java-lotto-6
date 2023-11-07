package lotto;

import java.util.List;

public class RateOfReturn {
    public static void printRateOfReturn(List<Integer> rankNumber, int amount) {
        double rateOfReturn = calcRateOfReturn(rankNumber, amount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }

    public static double calcRateOfReturn(List<Integer> rankNumber, int amount) {
        List<Integer> allPrize = Statistic.getPrize();
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += allPrize.get(i) * rankNumber.get(i);
        }
        return (double) total / (double) amount * 100.0;
    }
}
