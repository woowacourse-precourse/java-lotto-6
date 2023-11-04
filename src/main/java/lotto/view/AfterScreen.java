package lotto.view;

import java.util.List;
import lotto.model.Ranking;
import lotto.model.Result;

public class AfterScreen {
    private static final String RESULT_OF_LOTTOS = "당첨 통계\n---";
    private static final String SEPARATOR = " - ";
    private static final String RESULT_OF_TOTAL_PROFIT_IS = "총 수익률은";
    private static final String END = "%입니다.";
    public static void printResult(Result result) {
        System.out.println(RESULT_OF_LOTTOS);
        printWinningStatistic(result.getNumOfRanks());
        printProfits(result.getTotalProfit());
    }

    private static void printWinningStatistic(String numOfRanks) {
        System.out.println(numOfRanks);
    }

    public static void printProfits(double totalProfit) {
        System.out.println(RESULT_OF_TOTAL_PROFIT_IS + String.format("%.1f", totalProfit) + END);
    }
}
