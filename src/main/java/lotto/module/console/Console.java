package lotto.module.console;

import lotto.module.console.input.ConsoleReader;
import lotto.module.console.output.ConsoleWriter;

import java.util.List;

public class Console {
    private final ConsoleReader consoleReader;
    private final ConsoleWriter consoleWriter;

    private Console(ConsoleReader consoleReader, ConsoleWriter consoleWriter) {
        this.consoleReader = consoleReader;
        this.consoleWriter = consoleWriter;
    }

    public static Console of(ConsoleReader consoleReader, ConsoleWriter consoleWriter) {
        return new Console(consoleReader, consoleWriter);
    }

    public int getPurchaseAmount() {
        consoleWriter.printInputPaymentMessage();

        return consoleReader.readPurchaseAmount();
    }

    public void printPurchasedLottoTickets(String message) {
        consoleWriter.printPurchasedLottoTickets(message);
    }

    public List<Integer> getWinningLottoNumbers() {
        consoleWriter.printInputWinningLottoNumbersMessage();

        return consoleReader.readWinningLottoNumbers();
    }

    public int getLottoBonusNumber() {
        consoleWriter.printInputLottoBonusNumbersMessage();

        return consoleReader.readLottoBonusNumber();
    }

    public void printLottoWinningResult(final String lottoResultMessage) {
        consoleWriter.printLottoWinningResult(lottoResultMessage);
    }

    public void printErrorMessage(final String errorMessage) {
        consoleWriter.printErrorMessage(errorMessage);
    }

}
