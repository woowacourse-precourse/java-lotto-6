package lotto.view;

import java.util.Arrays;
import lotto.model.LottoResult;
import lotto.model.Rank;
import lotto.model.Statistics;

public class PrintStatistics {
    private static final String MESSAGE = "당첨 통계";
    private static final String PREFIX = "---";
    private static final String RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    public static void printStatistics(LottoResult result, Statistics statistics) {
        System.out.println(MESSAGE);
        System.out.println(PREFIX);
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.LOSE))
                .forEach(rank -> System.out.println(getPrintResult(rank, result)));
        System.out.printf(RATE_OF_RETURN, statistics.getRate());
    }

    private static String getPrintResult(Rank rank, LottoResult result) {
        if (rank == Rank.SECOND_PLACE) {
            return String.format(SECOND_RESULT_MESSAGE,
                    rank.getMatchLottoNumberCount(),
                    String.format("%,d", rank.getReward()),
                    result.getRankCount(rank));
        }
        return String.format(RESULT_MESSAGE,
                rank.getMatchLottoNumberCount(),
                String.format("%,d", rank.getReward()),
                result.getRankCount(rank));
    }
}
