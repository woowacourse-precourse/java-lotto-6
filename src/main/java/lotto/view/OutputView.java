package lotto.view;

import static lotto.domain.Ranking.*;
import static lotto.view.OutputMessage.PURCHASE_X_COUNT;
import static lotto.view.OutputMessage.WINNING_STATISTICS;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printResult(String result) {
        System.out.println("\n" + result);
    }

    public static void printPurchaseResult(List<Lotto> lottoList) {
        String result = makePurchaseResultOutputStatement(lottoList);
        System.out.println("\n" + result);
    }

    private static String makePurchaseResultOutputStatement(List<Lotto> lottoList) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottoList.size()).append(PURCHASE_X_COUNT.getOutputMessage() + "\n");

        for (Lotto lotto : lottoList) {
            sb.append(lotto.toString()).append("\n");
        }

        return sb.toString();
    }

    public static void printStatisticsResult(Map<Ranking, Integer> winningResult, double profitRate) {
        String result = makeStatisticsResultOutputStatement(winningResult, profitRate);
        System.out.println("\n" + result);
    }

    private static String makeStatisticsResultOutputStatement(Map<Ranking, Integer> winningResult, double profitRate) {
        StringBuilder sb = new StringBuilder();

        sb.append(WINNING_STATISTICS.getOutputMessage()).append("\n");
        sb.append("---").append("\n");

        sb.append(winningResultToOutputStatement(winningResult));

        sb.append(String.format("총 수익률은 %.1f%%입니다.", profitRate));

        return sb.toString();
    }


    private static String winningResultToOutputStatement(Map<Ranking, Integer> winningResult) {
        StringBuilder sb = new StringBuilder();

        Ranking[] rankingsArr = new Ranking[]{FIFTH, FORTH, THIRD, SECOND, FIRST};

        for (Ranking ranking : rankingsArr) {
            sb.append(ranking.getLotteryResult()).append(" - ");
            sb.append(winningResult.get(ranking)).append("개").append("\n");
        }

        return sb.toString();
    }


}

