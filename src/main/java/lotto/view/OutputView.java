package lotto.view;

import lotto.constant.OutputMessage;
import lotto.domain.LottoCounter;

public class OutputView {

    public void printPurchaseMessage() {
        System.out.println(OutputMessage.PURCHASE_AMOUNT.getMessage());
    }

    public void printTicketCount(LottoCounter lottoCounter) {
        String message = OutputMessage.LOTTO_TICKET_COUNT.getMessage();
        System.out.printf(message, lottoCounter.getTicketCount());
        System.out.println();
    }

    public void printNewLine() {
        System.out.println();
    }
}