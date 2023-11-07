package lotto.view;

import static lotto.constants.Message.NEW_LINE;
import static lotto.constants.Message.PROFIT_RATE;
import static lotto.constants.Message.TICKET_PREFIX;
import static lotto.constants.Message.TICKET_SEPARATOR;
import static lotto.constants.Message.TICKET_SUFFIX;
import static lotto.constants.Message.WINNING_HEADER;

import java.util.List;
import java.util.Map;
import lotto.constants.Message;
import lotto.constants.WinningType;
import lotto.domain.Lotto;
import lotto.dto.WinningResult;

public class OutputView {
    private final OutputDevice consoleOutputDevice;

    public OutputView(OutputDevice consoleOutputDevice) {
        this.consoleOutputDevice = consoleOutputDevice;
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        consoleOutputDevice.printByFormat(Message.PURCHASE_AMOUNT.getMessage(), lottoTickets.size());
        consoleOutputDevice.printLine(getPublishedLotto(lottoTickets));
    }

    private String getPublishedLotto(List<Lotto> lottoTickets) {
        StringBuilder builder = new StringBuilder();
        lottoTickets.forEach(
                lotto -> {
                    builder.append(TICKET_PREFIX.getMessage());
                    builder.append(String.join(TICKET_SEPARATOR.getMessage(), lotto.getNumbersAsString()));
                    builder.append(TICKET_SUFFIX.getMessage() + NEW_LINE.getMessage());
                }
        );
        return builder.toString();
    }

    public void printWinningResult(WinningResult lottoResult) {
        consoleOutputDevice.printLine(WINNING_HEADER.getMessage());
        consoleOutputDevice.printByFormat(getResult(lottoResult.getWinningMap()));
    }

    private String getResult(Map<WinningType, Integer> winningMap) {
        StringBuilder builder = new StringBuilder();
        winningMap.keySet()
                .forEach((winningType) -> {
                    String message = winningType.getMessage();
                    int quantity = winningMap.get(winningType);
                    builder.append(String.format(message, quantity));
                });
        return builder.toString();
    }

    public void printProfitRate(double profit) {
        consoleOutputDevice.printByFormat(PROFIT_RATE.getMessage(), profit);
    }

    public void printErrorCode(String message) {
        consoleOutputDevice.printLine(message);
    }
}
