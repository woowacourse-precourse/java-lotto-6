package lotto;

import lotto.Results;
import lotto.Ranking;

public class OutputView {

    public static void printResults(Results lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("-----------");

        for (Ranking ranking : Ranking.values()) {
            if (ranking != Ranking.NONE) {
                int count = lottoResult.getCount(ranking);
                System.out.println(ranking.getMessage() + count + "개");
            }
        }

        System.out.printf("총 수익률은 %.2f%% 입니다.\n", lottoResult.calculateEarningsRate());
    }
}
