package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.List;

public class OutputView {
    private static final String PURCHASED_TICKETS_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String WINNING_STATISTICS_LINE = "---";
    private static final String RESULT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.2f%%입니다.";

    public static void printPurchasedTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + PURCHASED_TICKETS_MESSAGE);
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getNumbers().toString());
        }
    }

    public static void printWinningStatistics(LottoResult lottoResult) {
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(WINNING_STATISTICS_LINE);

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE && lottoResult.getRankCount(rank) > 0) {
                System.out.println(String.format(RESULT_FORMAT,
                        rank.getMatchCount(),
                        rank.getPrizeMoney(),
                        lottoResult.getRankCount(rank)));
            }
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.println(String.format(PROFIT_RATE_FORMAT, profitRate));
    }
}
