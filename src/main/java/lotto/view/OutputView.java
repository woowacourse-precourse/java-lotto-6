package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class OutputView {
    private enum ConsoleMessage {
        TICKET_NUMBER("\n%d개를 구매했습니다.\n");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public void printTicket(LottoTicket lottoTicket) {
        printTicketMain(lottoTicket.getTicketCount());
        printTicketList(lottoTicket);
    }

    private static void printTicketMain(int ticketNumber) {
        System.out.printf(ConsoleMessage.TICKET_NUMBER.message, ticketNumber);
    }

    private void printTicketList(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottos()) {
            System.out.println(lotto.toString());
        }
    }
}
