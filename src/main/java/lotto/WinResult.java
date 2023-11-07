package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinResult {
    public static List<Integer> getResult(List<Lotto> allLotto, Lotto winningLotto, int bonus) {
        List<Integer> result = new ArrayList<>();
        for (Lotto lotto : allLotto) {
            result.add(lotto.countMatchingNumbers(winningLotto, bonus));
        }
        return result;
    }

    public static void printStatistic(List<Integer> result, int amount) {
        System.out.println("\n당첨 통계\n---");
        List<Integer> rankNumber = countRank(result);
        System.out.printf("3개 일치 (5,000원) - %d개\n", rankNumber.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n", rankNumber.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", rankNumber.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", rankNumber.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", rankNumber.get(0));

        RateOfReturn.printRateOfReturn(rankNumber, amount);
    }

    public static List<Integer> countRank(List<Integer> result) {
        List<Integer> rankNumber = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            rankNumber.add(Collections.frequency(result, i));
        }
        return rankNumber;
    }
}
