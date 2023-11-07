package lotto.view;

import java.util.Map;
import lotto.domain.Prize;

public class ResultView {
    public void printResult(Map<Prize, Integer> countPrices) {
        System.out.println("\n당첨통계\n---");
        System.out.println("3개 일치 (5,000원) - " + countPrices.getOrDefault(Prize.THREE, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + countPrices.getOrDefault(Prize.FOUR, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countPrices.getOrDefault(Prize.FIVE, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countPrices.getOrDefault(Prize.BONUS, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countPrices.getOrDefault(Prize.SIX, 0) + "개");
    }
}
