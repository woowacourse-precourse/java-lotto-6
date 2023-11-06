package view;

import domain.Rank;
import domain.Result;
import java.text.DecimalFormat;


public class ResultView {
    private static final String START_RESULT_VIEW = "당첨 통계";
    private static final String DELIMITER = "---";
    private static final String RESULT_RANK_MESSAGE = "%d개 일치%s(%s원) - %d개\n";
    private static final String BONUS_NUMBER = ", 보너스 볼 일치 ";

    public static void printResult(Result result) {
        DecimalFormat decFormat = new DecimalFormat("###,###");

        System.out.println(START_RESULT_VIEW);
        System.out.println(DELIMITER);

        for (Rank rank : Rank.getRanks()) {
            String reward = decFormat.format(rank.getReward());
            System.out.printf(RESULT_RANK_MESSAGE,
                    rank.getMatchCount(), printIsSecond(rank),
                    reward, result.getRankCount(rank));
        }
    }

    private static String printIsSecond(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return BONUS_NUMBER;
        }
        return " ";
    }
}
