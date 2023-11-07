package lotto.view;

import lotto.model.LottoResult;
import lotto.model.LottoTickets;

public class OutputView {

    private static final String LOTTO_TICKETS_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_TICKETS_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String LOTTO_TICKETS_EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoTickets(final LottoTickets tickets) {
        final String ticketCountPrintFormat = String.format(LOTTO_TICKETS_COUNT_MESSAGE,
            tickets.getTicketsCount());
        System.out.println(ticketCountPrintFormat);
        System.out.println(tickets.toOutputString());
    }

    public static void printLottoResult(final LottoResult result) {
        System.out.println(LOTTO_TICKETS_RESULT_MESSAGE);
        System.out.println(result.toOutputString());
    }

    public static void printEarningRate(final double earningRate) {
        final String earningRateMessage = String.format(LOTTO_TICKETS_EARNING_RATE_MESSAGE,
            earningRate);
        System.out.println(earningRateMessage);
    }

}