package lotto.view;

import lotto.domain.Rank;
import lotto.domain.RankResult;
import lotto.domain.Rate;

import java.util.Arrays;

public class OutputResultState {
    private static final String RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String LINE = "\n";
    private static final String TOP_MESSAGE = "당첨 통계" + LINE + "---";
    private static final String SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    public static void printResultState(RankResult rankresult, Rate rate) {
        System.out.println(TOP_MESSAGE);
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.EMPTY))
                .forEach(rank -> System.out.println(getPrintResultRank(rank, rankresult)));
        System.out.printf((RATE_OF_RETURN) + LINE, rate.getRate());
    }

    private static String getPrintResultRank(Rank rank, RankResult rankresult) {
        if (rank == Rank.SECOND) {
            return String.format(SECOND_RESULT_MESSAGE
                    , rank.getMatchLottoNumber()
                    , String.format("%,d", rank.getMoney())
                    , rankresult.getRankCount(rank));
        }

        return String.format(RESULT_MESSAGE
                , rank.getMatchLottoNumber()
                , String.format("%,d", rank.getMoney())
                , rankresult.getRankCount(rank));
    }
}
