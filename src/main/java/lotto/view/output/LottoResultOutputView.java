package lotto.view.output;

import lotto.domain.lotto.LottoRank;
import lotto.view.output.message.LottoOutputMessage;

import java.io.PrintStream;
import java.util.Map;
import java.util.Set;

public class LottoResultOutputView {
    private static final double PERCENTAGE = 100.0;

    public void printWinningStatisticsStartMessage() {
        System.out.println(LottoOutputMessage.WINNING_STATISTICS.getMessage());
    }

    public void printDashLine() {
        System.out.println(LottoOutputMessage.DASH_LINE.getMessage());
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

        System.out.printf(LottoOutputMessage.TOTAL_PROFIT_FORMAT.getMessage(),
                calculatePercentage(amount, totalAmount));
    }

    private double calculatePercentage(long amount, long totalAmount) {
        return ((double) totalAmount / amount) * PERCENTAGE;
    }

}
