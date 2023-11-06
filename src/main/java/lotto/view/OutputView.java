package lotto.view;

import lotto.constant.Message;
import lotto.io.OutputStream;

public class OutputView {

    private final OutputStream outputStream;

    public OutputView(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void printMoneyInputMessage() {
        outputStream.print(Message.INPUT_MONEY.get());
    }

    public void print(String message) {
        outputStream.print(message);
    }
}