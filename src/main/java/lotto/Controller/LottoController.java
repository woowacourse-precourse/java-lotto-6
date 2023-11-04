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
        final List<Lotto> lottoList = LottoGameManager.buyLotto(LottoGameManager.calculateLottoCount(amount));
        OutputView.displayLottoNumbers(lottoList);

        OutputView.displayWinningNumberGuide();
        inputWinningNumbers();

        OutputView.displayBonusNumberGuide();
        inputBonusNumber();

        final List<LottoMatch> winningResults = LottoGameManager.getWinningResults(lottoList);

        OutputView.displayWinningStatisticsGuide();
        OutputView.displayWinningStatistics(winningResults);

        OutputView.displayYield(LottoGameManager.calculateYield(winningResults, amount));
    }

    private Amount inputLottoAmount() {
        Amount amount;

        while (true) {
            try {
                amount = Amount.create(InputView.inputPurchaseAmount());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amount;
    }

    private void inputWinningNumbers() {
        while (true) {
            try {
                LottoGameManager.generateWinningLotto(InputView.inputWinningNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputBonusNumber() {
        while (true) {
            try {
                LottoGameManager.generateBonusNumber(InputView.inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
