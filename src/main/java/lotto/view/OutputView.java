package lotto.view;

import lotto.model.LottoTickets;

public class OutputView {

    private static final String LOTTO_TICKETS_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public static void printLottoTickets(final LottoTickets tickets) {
        final String ticketCountPrintFormat = String.format(LOTTO_TICKETS_COUNT_MESSAGE,
            tickets.getTicketsCount());
        System.out.println(ticketCountPrintFormat);
        System.out.println(tickets.toOutputString());
    }

}