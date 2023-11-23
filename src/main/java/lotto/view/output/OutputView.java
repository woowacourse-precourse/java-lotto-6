package lotto.view.output;

import java.util.List;
import lotto.dto.LottosDto;
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

    public void printLottosStatus(final List<LottosDto> lottosStatus) {
        lottosStatus.stream()
                .map(LottosDto::toString)
                .forEach(this::printMessage);
        printEmptyLine();
    }

    public void printReadWinningLottoMessage() {
        printMessage(OutputMessage.READ_WINNING_NUMBER_MESSAGE);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
