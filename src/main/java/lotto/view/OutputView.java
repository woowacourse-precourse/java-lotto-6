package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Statistic;

public class OutputView {
    private static final String PURCHASED_LOTTIES_MENT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MENT = "%d개 일치 (%d원) - %d개";
    public void printPurchasedLotties(List<Lotto> lotties) {
        System.out.printf(PURCHASED_LOTTIES_MENT, lotties.size());
        for (int i = 0; i < lotties.size(); i++) {
            System.out.println(lotties.get(i));
        }
    }

    public void printWinningStatistics(List<Statistic> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        int statisticLength = statistics.size();
        for (int i = 0; i < statisticLength; i++) {
            Statistic statistic = statistics.get(i);
            int correctNumberCount = statistic.getCorrectCount();
            int winning = statistic.getWinning();
            int matchLottoCount = statistic.getMatchLottoCount();
            System.out.printf(WINNING_STATISTICS_MENT, correctNumberCount
            ,winning, matchLottoCount);
        }

    }

    public void printProfitability(double profitabliity) {
        System.out.println(String.format(".1f",profitabliity));
    }
}
