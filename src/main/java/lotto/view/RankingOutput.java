package lotto.view;

import java.text.DecimalFormat;
import lotto.domain.Rank;
import lotto.domain.Ranking;
import lotto.domain.Rate;

public class RankingOutput {

    private static final String STATISTICS_MESSAGE = "당첨 통계" + System.lineSeparator() + "---";
    private static final String RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String RESULT_SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void rankingOutput(Ranking ranking, int tickets) {
        System.out.println(STATISTICS_MESSAGE);
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NOTHING) {
                continue;
            }
            System.out.println(printResult(rank, ranking));
        }
        System.out.println(printRate(ranking, tickets));
    }

    public static String printResult(Rank rank, Ranking ranking) {
        if (rank == Rank.SECOND) {
            return String.format(RESULT_SECOND_MESSAGE
                , rank.getMatchNums()
                , decimalFormat(rank.getReward())
                , ranking.getCount(rank)
            );
        }
        return String.format(RESULT_MESSAGE
            , rank.getMatchNums()
            , decimalFormat(rank.getReward())
            , ranking.getCount(rank)
        );
    }

    public static String printRate(Ranking ranking, int tickets) {
        double rate = Rate.calcRate(ranking, tickets);
        return String.format(RATE_MESSAGE, rate);
    }

    public static String decimalFormat(int reward) {
        DecimalFormat df = new DecimalFormat("###,###");
        String money = df.format(reward);
        return money;
    }

}
