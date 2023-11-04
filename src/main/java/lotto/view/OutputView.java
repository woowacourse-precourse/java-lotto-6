package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;
import lotto.model.Lotto;
import lotto.model.WinningStatistics;

public class OutputView {
    public static final String LOTTO_TICKETS_COUNT_FORMAT = "%d개를 구매했습니다.";
    public static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.";
    public static final String WINNING_STATISTICS_TEMPLATE_HEADER = "당첨 통계\n---\n";

    public void printLottoTicketsCount(int count) {
        System.out.println(String.format(LOTTO_TICKETS_COUNT_FORMAT, count));
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        StringBuilder sb = new StringBuilder();
        lottoTickets.forEach(lotto -> {
            sb.append(lotto.toString());
            sb.append("\n");
        });
        System.out.println(sb);
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        StringBuilder sb = new StringBuilder();
        Map<LottoPrize, Integer> prizeCount = winningStatistics.getPrizeCounter();

        sb.append(WINNING_STATISTICS_TEMPLATE_HEADER);
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (lottoPrize == LottoPrize.NOTHING) {
                continue;
            }

            int count = 0;
            if (prizeCount.get(lottoPrize) != null) {
                count = prizeCount.get(lottoPrize);
            }
            sb.append(String.format(lottoPrize.getStatisticsFormat(), count))
                    .append("\n");
        }
        System.out.println(sb);
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format(RATE_OF_RETURN_FORMAT, rateOfReturn));
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
