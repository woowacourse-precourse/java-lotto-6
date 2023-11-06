package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.LottoConstants;
import lotto.model.LottoTicket;
import lotto.model.MoneyValidator;
import lotto.model.ResultDetails;
import lotto.model.WinningNumbers;
import lotto.model.WinningNumbersData;
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
        int purchaseAmount = generateValidMoney();
        int numberOfLottoPurchased = purchaseAmount / LottoConstants.LOTTO_PRICE_UNIT;

        LottoTicket lottoTicket = LottoTicket.create(numberOfLottoPurchased);

        outputView.printNumberOfLotto(numberOfLottoPurchased);
        outputView.printLottoTicket(lottoTicket);

        resultDetails.updateResultDetails(lottoTicket, createValidWinningNumbers());

        outputView.printWinningStatisticsHeader();
        outputView.printWinningStatistics(resultDetails);
        outputView.printProfitRate(resultDetails.calculateProfitRate(purchaseAmount));
    }

    private int generateValidMoney() {
        while (true) {
            try {
                outputView.printPurchaseAmountMessage();
                int purchaseAmount = inputView.inputNumber();
                MoneyValidator.validateMoney(purchaseAmount);
                return purchaseAmount;
            } catch (final IllegalArgumentException illegalArgumentException) {
                outputView.printExceptionMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private WinningNumbers createValidWinningNumbers() {
        WinningNumbersData winningNumbersData = createValidWinningNumbersData();
        while (true) {
            try {
                outputView.printBonusNumberMessage();
                BonusNumber bonusNumber = new BonusNumber(inputView.inputNumber());
                return new WinningNumbers(winningNumbersData, bonusNumber);
            } catch (final IllegalArgumentException illegalArgumentException) {
                outputView.printExceptionMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private WinningNumbersData createValidWinningNumbersData() {
        while (true) {
            try {
                outputView.printWinningNumbersMessage();
                List<Integer> winningNumbers = inputView.inputWinningNumbers();
                return new WinningNumbersData(winningNumbers);
            } catch (final IllegalArgumentException illegalArgumentException) {
                outputView.printExceptionMessage(illegalArgumentException.getMessage());
            }
        }
    }
}
