package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Output {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printResults(Map<PrizeTier, Long> results, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (PrizeTier prizeTier : PrizeTier.values()) {
            long count = 0;
            if (results.containsKey(prizeTier)) {
                count = results.get(prizeTier);
            }
            if (prizeTier != PrizeTier.NONE) { // NONE은 출력하지 않습니다.
                System.out.println(prizeTier + " - " + count + "개");
            }
        }
        double profitRate = calculateProfitRate(results, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private static double calculateProfitRate(Map<PrizeTier, Long> results, int purchaseAmount) {
        long totalPrize = 0;
        for (Map.Entry<PrizeTier, Long> entry : results.entrySet()) {
            totalPrize += entry.getKey().getPrizeMoney() * entry.getValue();
        }

        return (double) totalPrize / purchaseAmount * 100;
    }
}
