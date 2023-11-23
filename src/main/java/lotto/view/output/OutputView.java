package lotto.view.output;

import lotto.view.output.message.OutputMessage;

public class OutputView {

    public void printMessage(final String message) {
        System.out.println(message);
    }

    private void printMessage(final OutputMessage outputMessage) {
        this.printMessage(outputMessage.getMessage());
    }

    public void printReadAmountMessage() {
        printMessage(OutputMessage.READ_AMOUNT_MESSAGE);
    }

    public void printPurchasedLottosMessage(final int count) {
        printEmptyLine();
        final String message = String.format(
                OutputMessage.PRINT_PURCHASED_LOTTOS_MESSAGE.getMessage(), count);
        printMessage(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
