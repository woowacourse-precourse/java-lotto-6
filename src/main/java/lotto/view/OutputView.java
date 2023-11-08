package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.constant.Constant;
import lotto.domain.rank.Rank;
import lotto.dto.LottoDto;
import lotto.dto.WinningStatisticsDto;

public class OutputView {

    private static final String PRINT_PURCHASED_LOTTO_COUNT = "\n%d개를 구매했습니다.\n";
    private static final String PRINT_WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private static final String PRINT_STATISTICS_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private static final String PRINT_STATISTICS_WITH_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String PRINT_PROFIT_MARGIN_FORMAT = "총 수익률은 %.1f%s입니다.";
    private static final String PERCENT_VALUE = "%";

    public void printLottoCount(final List<LottoDto> lottoStatus) {
        System.out.printf(PRINT_PURCHASED_LOTTO_COUNT, lottoStatus.size());
    }

    public void printLottoStatus(final List<LottoDto> lottoStatus) {
        lottoStatus.stream()
                .map(LottoDto::toString)
                .forEach(System.out::println);
    }

    public void printStatistics(final WinningStatisticsDto statisticsDto) {
        printStatisticsRankCount(statisticsDto);
        printStatisticProfitRate(statisticsDto);
    }

    private void printStatisticsRankCount(final WinningStatisticsDto statisticsDto) {
        System.out.println(PRINT_WINNING_STATISTICS_MESSAGE);
        for (Rank rank : Rank.values()) {
            final long rankCount = checkRankCountIfContains(statisticsDto.getRankCounts(), rank);
            printRankCount(rank, rankCount);
        }
    }

    private long checkRankCountIfContains(final Map<Rank, Long> rankCounts, final Rank rank) {
        if (rankCounts.containsKey(rank)) {
            return rankCounts.get(rank);
        }
        return Constant.ZERO_VALUE;
    }

    private void printRankCount(final Rank rank, final long rankCount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###,###");
        final int matchedCount = rank.getMatchedCount();
        final long profit = rank.getProfit();

        final String messageFormat = checkForWhetherBonusNumberIncluded(rank);
        System.out.printf(messageFormat, matchedCount, formatter.format(profit), rankCount);
    }

    private String checkForWhetherBonusNumberIncluded(final Rank rank) {
        if (rank.getBonusMatched()) {
            return PRINT_STATISTICS_WITH_BONUS_FORMAT;
        }
        return PRINT_STATISTICS_FORMAT;
    }

    private void printStatisticProfitRate(final WinningStatisticsDto statisticDto) {
        final double profitRate = statisticDto.getProfitRate();
        System.out.printf(PRINT_PROFIT_MARGIN_FORMAT, profitRate * 100, PERCENT_VALUE);
    }

}
