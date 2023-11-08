package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final String PURCHASED_TICKETS_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String WINNING_STATISTICS_LINE = "---";
    private static final String RESULT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final DecimalFormat PRIZE_FORMAT = new DecimalFormat("#,##0");

    public static void printPurchasedTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + PURCHASED_TICKETS_MESSAGE);
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getNumbers().toString());
        }
    }

    public static void printWinningStatistics(LottoResult lottoResult) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(WINNING_STATISTICS_LINE);

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) { // 모든 등수를 출력합니다.
                System.out.println(String.format(RESULT_FORMAT,
                        rank.getMatchCount(),
                        PRIZE_FORMAT.format(rank.getPrizeMoney()), // 숫자 형식에 콤마를 포함합니다.
                        lottoResult.getRankCount(rank)));
            }
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.println(String.format(PROFIT_RATE_FORMAT, profitRate));
    }
}
