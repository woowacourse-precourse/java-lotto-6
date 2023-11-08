package lotto.view.statistics;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.ranking.Ranking;
import lotto.statistics.Statistics;

public class LottoStaticsOutputView {
    private static final String RANK_RESULT_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private static final String SECOND_RANK_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String STATISTICS_TITLE = "당첨 통계";
    private static final String STATISTICS_DIVIDER = "---";
    private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#,###");

    public static void showStatists(Statistics statistics) {
        System.out.println(STATISTICS_TITLE);
        System.out.println(STATISTICS_DIVIDER);
        Map<Ranking, Integer> result = statistics.getStatistics();
        for (Ranking ranking : Ranking.values()) {
            showRankingResult(ranking, result);
        }
    }

    private static void showRankingResult(Ranking ranking, Map<Ranking, Integer> result) {
        String price = NUMBER_FORMAT.format(ranking.getPrice());
        if (ranking.equals(Ranking.NOTHING)) {
            return;
        } else if (ranking.equals(Ranking.SECOND)) {
            System.out.printf(SECOND_RANK_RESULT_FORMAT, ranking.getMatchCount(), price, result.get(ranking));
            return;
        }
        System.out.printf(RANK_RESULT_FORMAT, ranking.getMatchCount(), price, result.get(ranking));
    }
}
