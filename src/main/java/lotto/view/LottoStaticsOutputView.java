package lotto.view;


import java.util.Map;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

public class LottoStaticsOutputView {

    private static final String MATCHED_LOTTO_NUMBER_COUNT = "%d개 일치";
    private static final String PRIZE_UNIT = " (%,d원)";
    private static final String BONUS_BALL_MATCH = ", 보너스 볼 일치";
    private static final String RANK_LOTTO_COUNT = " - %d개\n";

    private static final String LOTTO_STATICS_MESSAGE = "당첨통계\n---";


    public static void outputFrom(WinningStatistics statistics) {

        System.out.println(LOTTO_STATICS_MESSAGE);

        for (Map.Entry<Rank, Integer> rankCount : statistics.showRankCount()) {

            Rank rank = rankCount.getKey();
            int count = rankCount.getValue();

            String message = createStatisticsMessageFrom(rank, count);
            System.out.printf(message);
        }
    }

    private static String createStatisticsMessageFrom(Rank rank, int count) {
        StringBuilder statisticsMessage = new StringBuilder();

        statisticsMessage.append(String.format(MATCHED_LOTTO_NUMBER_COUNT, rank.showMatchCount()));

        statisticsMessage.append(String.format(PRIZE_UNIT, rank.showMatchCount()));

        if (rank.equals(Rank.SECOND)) {

            statisticsMessage.append(BONUS_BALL_MATCH);

        }

        statisticsMessage.append(RANK_LOTTO_COUNT);

        statisticsMessage.append(String.format(MATCHED_LOTTO_NUMBER_COUNT, rank.showPrize()));
        return statisticsMessage.toString();

    }


}
