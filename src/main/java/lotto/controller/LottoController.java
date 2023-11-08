package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.ProfitMeter;
import lotto.domain.PurchaseProcessor;
import lotto.domain.WinnerCalculator;
import lotto.domain.WinningNumbers;
import lotto.util.NumberConverter;
import lotto.util.ResultFormatter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final NumberConverter numberConverter = new NumberConverter();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ResultFormatter resultFormatter = new ResultFormatter();
    private LottoFactory lottoFactory;
    private WinnerCalculator winnerCalculator;
    private PurchaseProcessor purchaseProcessor;

    public void startLotto() {
        purchaseLottos();
        Lotto winnerNumbers = draw();
        BonusNumber bonusNumber = handleBonusNumber(winnerNumbers);
        profitCalculation(winnerNumbers, bonusNumber);
    }

    private void purchaseLottos() {
        handlePurchaseAmount();
        generateLottoNumbers();
    }

    private Lotto draw() {
        return handleWinningNumbers();
    }

    private void profitCalculation(Lotto winnerNumbers, BonusNumber bonusNumber) {
        checkLottoResults(winnerNumbers, bonusNumber);
        computeLottoProfitability();
    }

    private void handlePurchaseAmount() {
        while (!tryPurchaseAmount()) {
        }
    }

    private boolean tryPurchaseAmount() {
        try {
            this.purchaseProcessor = new PurchaseProcessor(inputView.requestPurchaseAmount());
            outputView.printEmptyLine();
            return true;
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e);
            return false;
        }
    }

    private void generateLottoNumbers() {
        this.lottoFactory = new LottoFactory(purchaseProcessor.getLottoCount());
        outputView.displayLottoCount(purchaseProcessor.getLottoCount());
        outputView.displayLottoTickets(lottoFactory.getTickets());
        outputView.printEmptyLine();
    }

    private Lotto handleWinningNumbers() {
        while (true) {
            Lotto winnerNumbers = tryHandleWinningNumbers();
            outputView.printEmptyLine();
            if (winnerNumbers != null) {
                return winnerNumbers;
            }
        }
    }

    private Lotto tryHandleWinningNumbers() {
        try {
            String lottoNumber = inputView.requestWinningNumbers();
            return new Lotto(new WinningNumbers(numberConverter).process(lottoNumber));
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e);
            return null;
        }
    }

    private BonusNumber handleBonusNumber(Lotto winnerNumbers) {
        while (true) {
            BonusNumber bonusNumber = tryHandleBonusNumber(winnerNumbers);
            outputView.printEmptyLine();
            if (bonusNumber != null) {
                return bonusNumber;
            }
        }
    }

    private BonusNumber tryHandleBonusNumber(Lotto winnerNumbers) {
        try {
            BonusNumber bonusNumber = new BonusNumber(winnerNumbers, numberConverter);
            bonusNumber.validateNumber(inputView.requestBonusNumbers());
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e);
            return null;
        }
    }

    private void checkLottoResults(Lotto winnerNumbers, BonusNumber bonusNumber) {
        this.winnerCalculator = new WinnerCalculator(lottoFactory, winnerNumbers, bonusNumber);
        outputView.displayWinningLotto(resultFormatter.createWinningStatistics(winnerCalculator.calculate()));
    }

    private void computeLottoProfitability() {
        ProfitMeter profitMeter = new ProfitMeter(winnerCalculator.getWinnerCount(), purchaseProcessor.getLottoCount());
        outputView.displayRateOfReturn(profitMeter.calculateYield());
    }
}





