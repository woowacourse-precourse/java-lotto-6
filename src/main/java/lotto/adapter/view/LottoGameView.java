package lotto.adapter.view;

import lotto.StringConstants;
import lotto.adapter.printer.LottoPrinter;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.port.InputPort;
import lotto.port.OutputPort;
import lotto.controller.LottoGameController;

import java.util.List;
import java.util.Map;

public class LottoGameView {

    private final InputPort inputPort;
    private final OutputPort outputPort;
    private final LottoGameController lottoGameController;
    private final LottoPrinter lottoPrinter;

    public LottoGameView(InputPort inputPort, OutputPort outputPort, LottoGameController lottoGameController, LottoPrinter lottoPrinter) {
        this.inputPort = inputPort;
        this.outputPort = outputPort;
        this.lottoGameController = lottoGameController;
        this.lottoPrinter = lottoPrinter;
    }

    public void playGame() {
        String purchaseAmount = getPurchaseAmount();
        List<Lotto> userLottoNumbers = lottoGameController.buyLottoTickets(purchaseAmount);
        lottoPrinter.printLottoTickets(userLottoNumbers);

        String winningNumbers = getWinningNumbers();
        String bonusNumber = getBonusNumber();
        WinningLotto winningLotto = lottoGameController.createWinningLotto(winningNumbers, bonusNumber);

        Map<Integer, Integer> matchingCounts = lottoGameController.calculateMatchingCounts(userLottoNumbers, winningLotto);
        lottoGameController.printStatisticsAndReturnRate(matchingCounts, userLottoNumbers.size());
    }

    private String getPurchaseAmount() {
        outputPort.printLine(StringConstants.INPUT_PURCHASEAMOUNT_MESSAGE);
        return inputPort.readLine();
    }

    private String getWinningNumbers() {
        outputPort.printLine(StringConstants.INPUT_WINNING_NUMBER_MESSAGE);
        return inputPort.readLine();
    }

    private String getBonusNumber() {
        outputPort.printLine(StringConstants.INPUT_BONUS_NUMBER_MESSAGE);
        return inputPort.readLine();
    }

    private void printLottoNumbers(List<Lotto> userLottoNumbers) {
        outputPort.printLine(userLottoNumbers.size() + StringConstants.PURCHASED_COUNT_MESSAGE);
        userLottoNumbers.forEach(lotto -> outputPort.printLine(lotto.getNumbers().toString()));
        outputPort.printEmptyLine();
    }
}
