package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Ranking;

import java.util.List;

public class OutputView {
    public static final String PURCHASE_RESULT_MESSAGE = "개를 구매했습니다.";
    public static final String STATISTIC_MESSAGE = "당첨 통계";
    public static final String LINE_MESSAGE = "---";

    public static void printPurchasedLottos(List<Lotto> boughtLotto, int count) {
        System.out.println(count + PURCHASE_RESULT_MESSAGE);
        for (Lotto lotto : boughtLotto) {
            System.out.println(lotto);
        }
    }

    public static void printLottoResult(int inputMoney, List<Ranking> results) {
        System.out.println(STATISTIC_MESSAGE);
        System.out.println(LINE_MESSAGE);

        for (Ranking ranking : Ranking.getValidRankings()) {
            System.out.println(ranking.getMessage() + ranking.calculateCount(results));
        }
        System.out.println("총 수익률은 " + String.format("%,.1f", getEarningRate(Ranking.calculateEarning(results), inputMoney)) + "%입니다.");
    }

    private static double getEarningRate(int profit, int inputMoney) {
        return (double) (profit * 100) / inputMoney;
    }
}
