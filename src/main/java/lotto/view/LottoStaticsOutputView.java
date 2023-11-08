package lotto.view;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Rank;
import lotto.dto.WinningStatistics;

public class LottoStaticsOutputView {

    private static final String MATCHED_LOTTO_NUMBER_COUNT = "%d개 일치";
    private static final String PRIZE_UNIT = " (%,d원)";
    private static final String BONUS_BALL_MATCH = ", 보너스 볼 일치";
    private static final String RANK_LOTTO_COUNT = " - %d개\n";

    private static final String LOTTO_STATICS_MESSAGE = "당첨통계\n---";


    public static void outputFrom(WinningStatistics statistics) {

        System.out.println(LOTTO_STATICS_MESSAGE);

        List<Entry<Rank, Integer>> rankCountsPair = statistics.showRankCountsPair();
        Collections.reverse(rankCountsPair);

        for (Map.Entry<Rank, Integer> rankCount : rankCountsPair) {

            Rank rank = rankCount.getKey();
            int count = rankCount.getValue();

            if (rank.equals(Rank.NONE)) {
                continue;
            }

            String message = createStatisticsMessageFrom(rank, count);
            System.out.printf(message);
        }
    }

    private static String createStatisticsMessageFrom(Rank rank, int count) {
        StringBuilder statisticsMessage = new StringBuilder();

        statisticsMessage.append(String.format(MATCHED_LOTTO_NUMBER_COUNT, rank.showMatchCount()));

        if (rank.equals(Rank.SECOND)) {

            statisticsMessage.append(BONUS_BALL_MATCH);

        }

        statisticsMessage.append(String.format(PRIZE_UNIT, rank.showPrize()));

        statisticsMessage.append(String.format(RANK_LOTTO_COUNT, count));

        return statisticsMessage.toString();

    }


}
