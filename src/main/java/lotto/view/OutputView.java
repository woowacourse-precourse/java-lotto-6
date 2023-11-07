package lotto.view;

import static lotto.constants.Message.CONTOUR;
import static lotto.constants.Message.PROFIT_RATE;
import static lotto.constants.Message.WINNING_HEADER;

import java.util.List;
import lotto.constants.Message;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;

public class OutputView {
    private final OutputDevice outputDevice;

    public OutputView(OutputDevice outputDevice) {
        this.outputDevice = outputDevice;
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        outputDevice.printByFormat(Message.PURCHASE_AMOUNT.getMessage(), lottoTickets.size());
        for (Lotto lottoTicket : lottoTickets) {
            outputDevice.printLine(lottoTicket.toString());
        }
    }

    public void printWinningResult(WinningResult lottoResult) {
        outputDevice.printLine(WINNING_HEADER.getMessage());
        outputDevice.printLine(CONTOUR.getMessage());
        outputDevice.printLine(lottoResult.toString());
    }

    public void printProfitRate(double profit) {
        outputDevice.printByFormat(PROFIT_RATE.getMessage(), profit);
    }

    public void printErrorCode(String message) {
        outputDevice.printLine(message);
    }
}
