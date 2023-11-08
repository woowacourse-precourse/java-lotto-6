package lotto.view;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ConsoleOutput {

    public static void printPurchaseAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printAllRandomsLottos(Lottos lottos) {
        Iterator iterator = lottos.createIterator();
        while (iterator.hasNext()) {
            Lotto lotto = (Lotto) iterator.next();
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printPrizeStatistics(List<Map.Entry<Integer, Boolean>> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + countMatchNumber(result, 3) + "개");
        System.out.println("4개 일치 (50,000원) - " + countMatchNumber(result, 4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countMatchNumber(result, 5, false) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countMatchNumber(result, 5, true) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countMatchNumber(result, 6) + "개");
    }

    public static void printReturnRate(double rate) {
        System.out.printf("총 수익률은 %.1f%입니다" + rate);
    }

    private static int countMatchNumber(List<Map.Entry<Integer, Boolean>> results, int number) {
        int count = 0;
        for (Map.Entry<Integer, Boolean> result : results) {
            if (number == result.getKey()) {
                count++;
            }
        }
        return count;
    }

    private static int countMatchNumber(List<Map.Entry<Integer, Boolean>> results, int number, boolean isBonus) {
        int count = 0;
        for (Map.Entry<Integer, Boolean> result : results) {
            if (number == result.getKey() && isBonus == result.getValue()) {
                count++;
            }
        }
        return count;
    }
}
