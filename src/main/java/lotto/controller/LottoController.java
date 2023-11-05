package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.WinningNumbers;
import lotto.domain.ProfitMeter;
import lotto.domain.PurchaseProcessor;
import lotto.domain.WinnerCalculator;
import lotto.util.NumberConverter;
import lotto.util.ResultFormatter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final NumberConverter numberConverter = new NumberConverter();
    private final WinningNumbers winningNumbers = new WinningNumbers(numberConverter);
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ResultFormatter resultFormatter = new ResultFormatter();
    private LottoFactory lottoFactory;
    private Lotto winnerNumbers;
    private BonusNumber bonusNumber;
    private WinnerCalculator winnerCalculator;
    private PurchaseProcessor purchaseProcessor;

    public void startLotto() {
        purchaseLottos();
        lottoDraw();
        profitCalculation();
    }

    private void purchaseLottos() {
        handlePurchaseAmount();
        generateLottoNumbers();
    }

    private void lottoDraw() {
        handleWinningNumbers();
        handleBonusNumber();
    }

    private void profitCalculation() {
        checkLottoResults();
        computeLottoProfitability();
    }

    private void handlePurchaseAmount() {
        boolean isValidInput = false;
        while (!isValidInput) {
            isValidInput = attemptPurchaseAmount();
        }
    }

    private boolean attemptPurchaseAmount() {
        try {
            this.purchaseProcessor = new PurchaseProcessor(inputView.requestPurchaseAmount());
            outputView.enterLine();
            return true;
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e);
            return false;
        }
    }

    private void generateLottoNumbers() {
        this.lottoFactory = new LottoFactory(purchaseProcessor.getLottoCount());
        outputView.displayLottoCount(purchaseProcessor.getLottoCount());
        outputView.displayLottoReturns(lottoFactory.getTickets());
        outputView.enterLine();
    }

    private void handleWinningNumbers() {
        boolean isValidInput = false;
        while (!isValidInput) {
            isValidInput = attemptWinningNumbers();
        }
    }

    private boolean attemptWinningNumbers() {
        try {
            String lottoNumber = inputView.requestWinningNumbers();
            this.winnerNumbers = new Lotto(winningNumbers.process(lottoNumber));
            outputView.enterLine();
            return true;
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e);
            return false;
        }
    }

    private void handleBonusNumber() {
        boolean isValidInput = false;
        while (!isValidInput) {
            isValidInput = attemptBonusNumber();
        }
    }

    private boolean attemptBonusNumber() {
        try {
            this.bonusNumber = new BonusNumber(winnerNumbers, numberConverter);
            bonusNumber.validateNumber(inputView.requestBonusNumbers());
            outputView.enterLine();
            return true;
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e);
            return false;
        }
    }

    private void checkLottoResults() {
        this.winnerCalculator = new WinnerCalculator(lottoFactory, winnerNumbers, bonusNumber);
        outputView.displayWinningLotto(resultFormatter.createWinningStatistics(winnerCalculator.calculate()));
    }

    private void computeLottoProfitability() {
        ProfitMeter profitMeter = new ProfitMeter(winnerCalculator.getWinnerCount(), purchaseProcessor.getLottoCount());
        outputView.displayRateOfReturn(profitMeter.calculateYield());
    }
}
