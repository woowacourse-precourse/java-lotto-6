package lotto.controller;

import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.model.LottoGameManager;
import lotto.model.LottoMatch;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        OutputView.displayPurchaseGuide();
        final Amount amount = inputLottoAmount();
        final int lottoCount = LottoGameManager.calculateLottoCount(amount);
        OutputView.displayLottoCount(lottoCount);

        final List<Lotto> lottoList = LottoGameManager.buyLotto(lottoCount);
        OutputView.displayLottoNumbers(lottoList);

        OutputView.displayWinningNumberGuide();
        decideWinningNumbers();

        final List<LottoMatch> winningResults = LottoGameManager.getWinningResults(lottoList);

        OutputView.displayWinningStatisticsGuide();
        OutputView.displayWinningStatistics(winningResults);

        OutputView.displayYield(LottoGameManager.calculateYield(winningResults, amount));
    }

    private Amount inputLottoAmount() {
        while (true) {
            try {
                return Amount.create(InputView.inputPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void decideWinningNumbers() {
        List<String> numbersStr = inputWinningNumbers();
        OutputView.displayBonusNumberGuide();
        while (true) {
            try {
                String bonusNumberStr = InputView.inputBonusNumber();
                LottoGameManager.generateWinningNumbers(numbersStr, bonusNumberStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> inputWinningNumbers() {
        while (true) {
            try {
                return InputView.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
