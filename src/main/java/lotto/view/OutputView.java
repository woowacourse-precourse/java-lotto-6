package lotto.view;

import lotto.domain.LottoTicket;

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
    
}
