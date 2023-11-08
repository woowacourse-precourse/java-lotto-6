package lotto.view;

import java.util.Arrays;
import lotto.Calculate;
import lotto.Ranking;
import lotto.ShowRanking;

public class OutputStatistics {
    public static void printStatistics(ShowRanking showRanking, Calculate calculate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(Ranking.values())
                .filter(ranking -> !ranking.equals(Ranking.SIXTH))
                .forEach(ranking -> System.out.println(printResult(ranking, showRanking)));
        System.out.printf("총 수익률은 %.1f%%입니다.");
        System.out.println();
        System.out.println(calculate.getRate());
    }

    private static String printResult(Ranking ranking, ShowRanking showRanking) {
        if (ranking == Ranking.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개"
                                    , ranking.getCheckLottoNumber()
                                    , String.format("%,d", ranking.getMoney())
                                    , showRanking.getRankCount(ranking));
        }

        return String.format("%d개 일치 (%s원) - %d개"
                                , ranking.getCheckLottoNumber()
                                , String.format("%,d", ranking.getMoney())
                                , showRanking.getRankCount(ranking));
    }
}
