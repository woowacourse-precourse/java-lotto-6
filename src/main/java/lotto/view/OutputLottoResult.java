package lotto.view;

import lotto.domain.Rank;
import lotto.domain.RankResult;
import lotto.domain.Rate;

import java.util.Arrays;

public class OutputLottoResult {
    private static final String OUTPUT_TITLE_MESSAGE = "당첨 통계";
    private static final String OUTPUT_UNDERBAR = "---";
    private static final String OUTPUT_LOTTO_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String OUTPUT_LOTTO_SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String OUTPUT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printResult(RankResult rankResult, Rate rate){
        System.out.println(OUTPUT_TITLE_MESSAGE);
        System.out.println(OUTPUT_UNDERBAR);

        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NONE))
                .forEach(rank -> System.out.println(printLottoResult(rank, rankResult)));

        System.out.printf(OUTPUT_RATE_MESSAGE, rate.getRate());
    }

    private static String printLottoResult(Rank rank, RankResult rankResult){
        if(rank == Rank.SECOND){
            return String.format(OUTPUT_LOTTO_SECOND_RESULT_MESSAGE, rank.getMatchCount(), String.format("%,d", rank.getPrize()), rankResult.getRankCount(rank));
        }

        return String.format(OUTPUT_LOTTO_RESULT_MESSAGE, rank.getMatchCount(), String.format("%,d", rank.getPrize()), rankResult.getRankCount(rank));
    }
}
