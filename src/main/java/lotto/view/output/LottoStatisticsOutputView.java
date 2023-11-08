package lotto.view.output;

import lotto.domain.prize.ranking.PrizeMatchingNumber;
import lotto.domain.prize.ranking.PrizeRankingCount;
import lotto.domain.prize.statistics.EarningRate;
import lotto.util.format.LottoFormat;
import lotto.view.output.constant.PrizeRankingMessage;
import lotto.view.output.writer.Writer;

public class LottoStatisticsOutputView extends OutputView {
    private static final String STRING_PRIZE_STATISTICS_MESSAGE = "당첨 통계";
    private static final String STRING_PRIZE_STATISTICS_HORIZONTAL_LINE = "---";
    private static final String STRING_EARNING_RATE_FORMAT = "총 수익률은 %s입니다.";

    public LottoStatisticsOutputView(final Writer writer) {
        super(writer);
    }

    public void printPrizeStatistics(
            PrizeRankingCount prizeRankingCount,
            EarningRate earningRate
    ) {
        printPrizeStatisticsMessage();
        writer.println(STRING_PRIZE_STATISTICS_HORIZONTAL_LINE);
        printPrizeRankingCount(prizeRankingCount);
        printPrizeEarningRate(earningRate);
    }

    private void printPrizeStatisticsMessage() {
        writer.println(STRING_PRIZE_STATISTICS_MESSAGE);
    }

    private void printPrizeRankingCount(final PrizeRankingCount prizeRankingCount) {
        prizeRankingCount.getPrizeRankingCount().forEach((prizeRanking, count) -> {
                    final PrizeRankingMessage prizeRankingMessage = PrizeRankingMessage.find(prizeRanking);
                    final PrizeMatchingNumber prizeMatchingNumber = PrizeMatchingNumber.valueOf(prizeRanking.name());
                    final String formattedAmount = LottoFormat.PRICE.getFormat()
                            .format(prizeRanking.getPrizeAmount().getAmount());
                    final String message = prizeRankingMessage.getMessageFormat().formatted(
                            prizeMatchingNumber.getMatchCount(),
                            formattedAmount,
                            count
                    );
                    writer.println(message);
                }
        );
    }

    public void printPrizeEarningRate(final EarningRate earningRate) {
        final String formattedPrizeEarningRate = LottoFormat.EARNING_RATE.getFormat()
                .format(earningRate.getEarningRate());
        writer.println(STRING_EARNING_RATE_FORMAT.formatted(formattedPrizeEarningRate));
    }
}
