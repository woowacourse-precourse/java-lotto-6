package lotto.view.outputView;


import lotto.model.lottoResultChecker.LottoRank;
import java.util.Map;

public class LottoWinningStatisticsOutput {

    public void printStatistics(Map<LottoRank, Integer> rankResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printRankResult(LottoRank.FIFTH, rankResult);
        printRankResult(LottoRank.FOURTH, rankResult);
        printRankResult(LottoRank.THIRD, rankResult);
        printRankResult(LottoRank.SECOND, rankResult);
        printRankResult(LottoRank.FIRST, rankResult);
    }

    private void printRankResult(LottoRank rank, Map<LottoRank, Integer> rankResult) {
        String bonusMatchString = (rank == LottoRank.SECOND) ? ", 보너스 볼 일치" : "";
        System.out.printf("%d개 일치%s (%s원) - %d개%n",
                rank.getMatchCount(),
                bonusMatchString,
                String.format("%,d", rank.getWinningMoney()),
                rankResult.getOrDefault(rank, 0)
        );
    }
}