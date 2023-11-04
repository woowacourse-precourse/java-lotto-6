package lotto.ui;

import lotto.domain.LottoTicket;

public class OutputView {

    public void displayMessage(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    public void displayLottoTicket(OutputMessage message, int ticketCount, LottoTicket lottoTicket) {
        System.out.println(ticketCount + message.getMessage());
        System.out.println(lottoTicket);
    }
}