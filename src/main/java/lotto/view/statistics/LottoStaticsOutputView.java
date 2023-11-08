package lotto.view.statistics;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.ranking.Ranking;
import lotto.statistics.Statistics;

public class LottoStaticsOutputView {
    private static final String RANK_RESULT_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private static final String SECOND_RANK_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String STATISTICS_TITLE_MESSAGE = "당첨 통계";
    private static final String STATISTICS_DIVIDER_MESSAGE = "---";
    private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#,###");

    public static void showStatists(Statistics statistics) {
        System.out.println(STATISTICS_TITLE_MESSAGE);
        System.out.println(STATISTICS_DIVIDER_MESSAGE);
        Map<Ranking, Integer> result = statistics.getStatistics();
        for (Ranking ranking : Ranking.values()) {
            showRankingResult(ranking, result);
        }
    }

    private static void showRankingResult(Ranking ranking, Map<Ranking, Integer> result) {
        String price = NUMBER_FORMAT.format(ranking.getPrice());
        if (isNothing(ranking)) {
            return;
        }
        showSecondRankingCount(ranking, result, price);
        showRankingCount(ranking, result, price);
    }

    private static boolean isNothing(Ranking ranking) {
        return ranking.equals(Ranking.NOTHING);
    }

    private static void showSecondRankingCount(Ranking ranking, Map<Ranking, Integer> result, String price) {
        if (ranking.equals(Ranking.SECOND)) {
            System.out.printf(SECOND_RANK_RESULT_FORMAT, ranking.getMatchCount(), price, result.get(ranking));
        }
    }

    private static void showRankingCount(Ranking ranking, Map<Ranking, Integer> result, String price) {
        System.out.printf(RANK_RESULT_FORMAT, ranking.getMatchCount(), price, result.get(ranking));
    }


}
