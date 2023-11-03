package lotto.view;

import lotto.util.ConsoleMessage;

public class OutputView {
    public static void printLottoTicketNumber(int lottoTicketNumber) {
        System.out.printf(ConsoleMessage.LOTTO_TICKET_NUMBER, lottoTicketNumber);
    }
}
