package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.WinningNumbers;
import lotto.model.dto.AnalyzerWinningStatistics;
import lotto.model.dto.BuyerLottoHistory;
import lotto.model.lottonumbersgenerator.RandomLottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final LottoBuyer lottoBuyer;

    public LottoGameController() {
        lottoBuyer = new LottoBuyer();
    }

    public void play() {
        buyAutoLotto();
        WinningNumbers winningNumbers = determineWinningNumbers();
        calculateWinningStatistics(winningNumbers);
    }

    private void tryCatchTemplate(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            tryCatchTemplate(action);
        }
    }

    private <T> T tryCatchWithReturnTemplate(Supplier<T> action) {
        try {
            return action.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return tryCatchWithReturnTemplate(action);
        }
    }

    private void buyAutoLotto() {
        tryCatchTemplate(this::tryToBuyAutoLotto);
        logBuyHistory(lottoBuyer);
    }

    private void tryToBuyAutoLotto() {
        int purchaseAmount = askPurchaseAmount();
        lottoBuyer.buyLotto(purchaseAmount, new RandomLottoNumbersGenerator());
    }

    private int askPurchaseAmount() {
        OutputView.printPurchaseAmountPrompt();
        return InputView.readPurchaseAmount();
    }

    private void logBuyHistory(LottoBuyer lottoBuyer) {
        BuyerLottoHistory buyerLottoHistory = lottoBuyer.generateBuyerLottoHistory();
        OutputView.printBuyerLottoHistory(buyerLottoHistory);
    }

    private WinningNumbers determineWinningNumbers() {
        Lotto mainNumbers = tryCatchWithReturnTemplate(this::makeMainWinningNumbers);
        return tryCatchWithReturnTemplate(() -> addBonusNumber(mainNumbers));
    }

    private Lotto makeMainWinningNumbers() {
        OutputView.printMainWinningNumbersPrompt();
        List<Integer> mainWinningNumbers = InputView.readMainWinningNumbers();
        return new Lotto(mainWinningNumbers);
    }

    private WinningNumbers addBonusNumber(Lotto mainNumbers) {
        int bonusNumber = askBonusNumber();
        return mainNumbers.addBonusNumber(bonusNumber);
    }

    private int askBonusNumber() {
        OutputView.printBonusNumberPrompt();
        return InputView.readBonusNumber();
    }

    private void calculateWinningStatistics(WinningNumbers winningNumbers) {
        AnalyzerWinningStatistics analyzerWinningStatistics = lottoBuyer.calculateWinningStatistics(winningNumbers);
        OutputView.printAnalyzerWinningStatistics(analyzerWinningStatistics);
    }
}
