package lotto.io;

import lotto.constant.ProcessMessage;
import lotto.domain.Lottos;
import lotto.domain.Ticket;

public class OutputView {

    private final OutputFommatter outputFommatter;

    public OutputView(OutputFommatter outputFommatter) {
        this.outputFommatter = outputFommatter;
    }

    public void printPurchaseAmountRequset() {
        System.out.println(ProcessMessage.PURCHASE_AMOUNT_REQUSET.toValue());
    }

    public void printNumberOfTicket(final Ticket ticket) {
        System.out.println(ProcessMessage.NEW_LINE.toValue() + outputFommatter.toNumberOfTicket(ticket));
    }

    public void printNumberOfLottos(final Lottos lottos) {
        System.out.println(outputFommatter.toLottos(lottos));
    }
}
