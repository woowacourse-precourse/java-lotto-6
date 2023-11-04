package lotto.io;

import lotto.constant.ProcessMessage;
import lotto.domain.Amount;

public class OutputView {

    private final OutputFommatter outputFommatter;

    public OutputView(OutputFommatter outputFommatter) {
        this.outputFommatter = outputFommatter;
    }

    public void printPurchaseAmountRequset() {
        System.out.println(ProcessMessage.PURCHASE_AMOUNT_REQUSET.toValue());
    }

    public void printNumberOfTicket(final Amount amount) {
        System.out.println(ProcessMessage.NEW_LINE.toValue() + outputFommatter.toNumberOfTicket(amount));
    }
}
