package lotto.view.output;

import lotto.domain.lotto.LottoRank;

import java.io.PrintStream;
import java.util.Map;
import java.util.Set;

public class LottoResultOutputView {

    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DASH_LINE = "---";
    private static final String TOTAL_PROFIT_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final double PERCENTAGE = 100.0;

    public void printWinningStatisticsStartMessage() {
        System.out.println(WINNING_STATISTICS);
    }

    public void printDashLine() {
        System.out.println(DASH_LINE);
    }

    public void printLottoAllMatch(Map<LottoRank, Long> lottoRankCountMap) {
        Set<LottoRank> lottoRanks = lottoRankCountMap.keySet();
        lottoRanks.stream()
                .forEach(lottoRank -> printLottoMatchCount(lottoRankCountMap, lottoRank));
    }

    private PrintStream printLottoMatchCount(Map<LottoRank, Long> lottoRankCountMap, LottoRank lottoRank) {
        return System.out.printf(lottoRank.printRankMessage(), getRankCount(lottoRankCountMap, lottoRank));
    }

    private Long getRankCount(Map<LottoRank, Long> lottoRankCountMap, LottoRank lottoRank) {
        return lottoRankCountMap.get(lottoRank);
    }

    public void printTotalProfitRate(long amount, Map<LottoRank, Long> lottoRankCountMap) {
        Set<LottoRank> lottoRanks = lottoRankCountMap.keySet();
        long totalAmount = lottoRanks.stream()
                .mapToLong(lottoRank -> lottoRank.calculatePrize(getRankCount(lottoRankCountMap, lottoRank)))
                .sum();

        System.out.printf(TOTAL_PROFIT_FORMAT, calculatePercentage(amount, totalAmount));
    }

    private double calculatePercentage(long amount, long totalAmount) {
        return ((double) totalAmount / amount) * PERCENTAGE;
    }

}
