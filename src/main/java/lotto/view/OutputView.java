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

    public void printBuyMessage(int buyCount) {
        outputStream.print(buyCount + Message.BUY_MESSAGE_WITH_COUNT.get());
    }

    public void printEmptyLine() {
        outputStream.print();
    }

    public void print(String message) {
        outputStream.print(message);
    }

    public void printWinNumbersInputMessage() {
        outputStream.print(Message.INPUT_WINNING_NUMBERS.get());
    }

    public void printBonusNumberInputMessage() {
        outputStream.print(Message.INPUT_BONUS_NUMBER.get());
    }

    public void printStatisticsMessage() {
        outputStream.print(Message.START_STATISTICS.get());
    }
}