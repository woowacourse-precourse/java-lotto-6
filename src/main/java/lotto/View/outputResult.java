package lotto.View;

import lotto.Domain.Rank;
import lotto.Domain.RankResult;
import lotto.Domain.Rate;

import java.util.Arrays;

public class outputResult {
    private static final String NEWLINE = "\n";
    private static final String OUTPUT_TOP_MESSAGE = "당첨 통계" + NEWLINE + "---";
    private static final String OUTPUT_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String OUTPUT_SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    public static void printStatistics(RankResult rankResult, Rate rate) {
        System.out.println(OUTPUT_TOP_MESSAGE);
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.EMPTY))
                .forEach(rank -> System.out.println(getPrintResultPrize(rank,rankResult)));
        System.out.printf((OUTPUT_RATE_OF_RETURN) + NEWLINE, rate.getRate());
    }

    private static String getPrintResultPrize(Rank rank, RankResult rankResult) {
        if (rank == Rank.SECOND) {
            return String.format(OUTPUT_SECOND_RESULT_MESSAGE
                    , rank.getMatchLottoNumber()
                    , String.format("%,d", rank.getMoney())
                    , rankResult.getRankcount(rank));
        }

        return String.format(OUTPUT_RESULT_MESSAGE
                , rank.getMatchLottoNumber()
                , String.format("%,d", rank.getMoney())
                , rankResult.getRankcount(rank));
    }
}
