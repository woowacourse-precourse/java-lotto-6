package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.Money;
import lotto.model.ResultDetails;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ResultDetails resultDetails;

    public LottoController(final InputView inputView, final OutputView outputView, final ResultDetails resultDetails) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.resultDetails = resultDetails;
    }

    public void play() {
        final Money purchaseAmount = generateValidMoney();

        final LottoTicket lottoTicket = LottoTicket.create(purchaseAmount);

        outputView.printNumberOfLotto(purchaseAmount.getNumberOfLotto());
        outputView.printLottoTicket(lottoTicket);

        resultDetails.updateResultDetails(lottoTicket, createValidWinningNumbers());

        outputView.printWinningStatisticsHeader();
        outputView.printWinningStatistics(resultDetails);
        outputView.printProfitRate(resultDetails.calculateProfitRate(purchaseAmount));
    }

    private Money generateValidMoney() {
        while (true) {
            try {
                outputView.printPurchaseAmountMessage();
                return new Money(inputView.inputNumber());
            } catch (final IllegalArgumentException illegalArgumentException) {
                outputView.printExceptionMessage(illegalArgumentException);
            }
        }
    }

    private WinningNumbers createValidWinningNumbers() {
        final Lotto winningNumbers = createValidWinningLotto();
        while (true) {
            try {
                outputView.printBonusNumberMessage();
                BonusNumber bonusNumber = new BonusNumber(inputView.inputNumber());
                return new WinningNumbers(winningNumbers, bonusNumber);
            } catch (final IllegalArgumentException illegalArgumentException) {
                outputView.printExceptionMessage(illegalArgumentException);
            }
        }
    }

    private Lotto createValidWinningLotto() {
        while (true) {
            try {
                outputView.printWinningNumbersMessage();
                final List<Integer> winningNumbers = inputView.inputWinningNumbers();
                return new Lotto(winningNumbers);
            } catch (final IllegalArgumentException illegalArgumentException) {
                outputView.printExceptionMessage(illegalArgumentException);
            }
        }
    }
}
