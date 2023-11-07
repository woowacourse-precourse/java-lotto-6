package lotto.view;

import static lotto.constants.Message.CONTOUR;
import static lotto.constants.Message.PROFIT_RATE;
import static lotto.constants.Message.WINNING_HEADER;

import java.util.List;
import lotto.constants.Message;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;

public class OutputView {
    private final Writable consoleOutputDevice;

    public OutputView(Writable consoleOutputDevice) {
        this.consoleOutputDevice = consoleOutputDevice;
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        consoleOutputDevice.printByFormat(Message.PURCHASE_AMOUNT.getMessage(), lottoTickets.size());
        for (Lotto lottoTicket : lottoTickets) {
            consoleOutputDevice.printLine(lottoTicket.toString());
        }
    }

    public void printWinningResult(WinningResult lottoResult) {
        consoleOutputDevice.printLine(WINNING_HEADER.getMessage());
        consoleOutputDevice.printLine(CONTOUR.getMessage());
        consoleOutputDevice.printLine(lottoResult.toString());
    }

    public void printProfitRate(double profit) {
        consoleOutputDevice.printByFormat(PROFIT_RATE.getMessage(), profit);
    }

    public void printErrorCode(String message) {
        consoleOutputDevice.printLine(message);
    }
}
