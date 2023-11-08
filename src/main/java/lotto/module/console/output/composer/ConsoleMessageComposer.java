package lotto.module.console.output.composer;

import lotto.module.domain.LottoProfit;
import lotto.module.lotto.Lotto;
import lotto.module.rank.LottoPrizeTable;
import lotto.module.result.LottoResult;

import java.util.List;

public class ConsoleMessageComposer {
    private final static String PURCHASED_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private final static String WINNING_STATISTICS_HEADER = "\n당첨 통계\n";
    private final static String DIVIDER_LINE = "---\n";
    private final static String COUNT_SUFFIX = "개";
    private final static String RATE_PREFIX = "총 수익률은 ";
    private final static String RATE_SUFFIX = "%입니다.";
    private final static String RATE_FORMATTER = "%.1f";

    private ConsoleMessageComposer() {
    }

    public static ConsoleMessageComposer newInstance() {
        return new ConsoleMessageComposer();
    }

    public String makePurchasedLottoTicketMessage(List<Lotto> list) {
        StringBuilder message = new StringBuilder(System.lineSeparator())
                .append(list.size())
                .append(PURCHASED_LOTTO_COUNT_MESSAGE)
                .append(System.lineSeparator());

        for (Lotto lotto : list) {
            message.append(lotto.getNumbers())
                    .append(System.lineSeparator());
        }

        return message.toString();
    }

    public String generateLottoResultMessage(LottoResult lottoResult, LottoProfit lottoProfit) {
        StringBuilder sb = new StringBuilder();
        makeHeadMessage(sb);
        makeWinningStatsMessage(lottoResult, sb);
        makeRateMessage(lottoProfit, sb);
        return sb.toString();
    }

    private void makeHeadMessage(StringBuilder sb) {
        sb.append(WINNING_STATISTICS_HEADER)
                .append(DIVIDER_LINE);
    }

    private void makeWinningStatsMessage(LottoResult lottoResult, StringBuilder sb) {
        for (LottoPrizeTable rank : LottoPrizeTable.values()) {
            sb.append(rank.getWinningRecordMessage())
                    .append(lottoResult.getRankCount(rank.getRank()))
                    .append(COUNT_SUFFIX)
                    .append(System.lineSeparator());
        }
    }

    private void makeRateMessage(LottoProfit lottoProfit, StringBuilder sb) {
        double rate = lottoProfit.rate();
        String formatRate = String.format(RATE_FORMATTER, rate);

        sb.append(RATE_PREFIX)
                .append(formatRate)
                .append(RATE_SUFFIX);
    }

}
