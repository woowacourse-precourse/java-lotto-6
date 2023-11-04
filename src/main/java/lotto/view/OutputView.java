package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;
import lotto.model.Lotto;
import lotto.model.WinningStatistics;

public class OutputView {
    public static final String LOTTO_TICKETS_COUNT_FORMAT = "%d개를 구매했습니다.";
    public static final String WINNING_STATISTICS_TEMPLATE_HEADER = "당첨 통계\n---";
    public static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printLottoTicketsCount(int count) {
        System.out.printf((LOTTO_TICKETS_COUNT_FORMAT) + "%n", count);
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        lottoTickets.forEach(lotto -> {
            System.out.println(lotto.toString());
        });
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        Map<LottoPrize, Integer> prizeCount = winningStatistics.getPrizeCounter();

        System.out.println(WINNING_STATISTICS_TEMPLATE_HEADER);
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (lottoPrize == LottoPrize.NOTHING) {
                continue;
            }
            int count = 0;
            if (prizeCount.get(lottoPrize) != null) {
                count = prizeCount.get(lottoPrize);
            }
            System.out.printf((lottoPrize.getStatisticsFormat()) + "%n", count);
        }
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf((RATE_OF_RETURN_FORMAT) + "%n", rateOfReturn);
    }
}
