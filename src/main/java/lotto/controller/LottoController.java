package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.ProfitCalculator;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;
import lotto.domain.WinningStatisticsCalculator;
import lotto.utils.InputProcessor;
import lotto.utils.generator.RandomLottosGenerator;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        PurchasedLottos purchasedLottos = createPurchasedLottos();
        OutputView.printPurchaseLottoResult(purchasedLottos.toString());

        WinningNumbers winningNumbers = createWinningNumbers();
        BonusNumber bonusNumber = createBonusNumber(winningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        WinningStatistics winningStatistics = getWinningStatistics(purchasedLottos, winningLotto);

        String winningResult = winningStatistics.toString();
        String profitPercentage = getProfit(winningStatistics, purchasedLottos);
        OutputView.printResult(winningResult, profitPercentage);
    }

    private PurchasedLottos createPurchasedLottos() {
        while (true) {
            try {
                int purchaseAmount = InputProcessor.processPurchaseAmount();
                return new PurchasedLottos(purchaseAmount, new RandomLottosGenerator());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumbers createWinningNumbers() {
        List<Integer> winnerNumbers;
        while (true) {
            try {
                winnerNumbers = InputProcessor.processWinningNumbers();
                return new WinningNumbers(winnerNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber createBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                int bonusNumber = InputProcessor.processBonusNumber();
                return new BonusNumber(bonusNumber, winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

    }

    private WinningStatistics getWinningStatistics(PurchasedLottos purchasedLottos, WinningLotto winningLotto) {
        WinningStatisticsCalculator winningStatisticsCalculator = new WinningStatisticsCalculator(purchasedLottos,
                winningLotto);
        return winningStatisticsCalculator.calculateWinningStatistics();
    }

    private String getProfit(WinningStatistics winningStatistics, PurchasedLottos purchasedLottos) {
        ProfitCalculator profitCalculator = new ProfitCalculator(winningStatistics, purchasedLottos);
        return profitCalculator.getProfitPercentage();
    }
}
