package view;

import domain.Rank;
import domain.Result;
import java.text.DecimalFormat;


public class ResultView {
    private static final String START_RESULT_VIEW = "당첨 통계";
    private static final String DELIMITER = "---";
    private static final String RESULT_RANK_MESSAGE = "%d개 일치%s(%s원) - %d개\n";
    private static final String BONUS_NUMBER = ", 보너스 볼 일치 ";
    private static final String PROFIT_RATE = "총 수익률은 %.1f%%입니다.";

    private ResultView() {
    }

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

    public static void printReward(double profitRate) {
        System.out.printf(PROFIT_RATE, profitRate);
    }
}
