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
        final Amount amount = getAmountFromUser();
        final List<Lotto> lottoList = purchaseLottoByAmount(amount);
        decideWinningNumbers();
        final List<LottoMatch> winningResults = LottoGameManager.getWinningResults(lottoList);
        displayWinningStatisticsAndYield(winningResults, amount);
    }

    private Amount getAmountFromUser() {
        OutputView.displayPurchaseGuide();
        while (true) {
            try {
                return getValidatedAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Amount getValidatedAmount() {
        return Amount.create(InputView.inputPurchaseAmount());
    }

    private List<Lotto> purchaseLottoByAmount(Amount amount) {
        int lottoCount = LottoGameManager.calculateLottoCount(amount);
        OutputView.displayLottoCount(lottoCount);
        List<Lotto> purchasedLottoList = LottoGameManager.buyLotto(lottoCount);
        OutputView.displayLottoNumbers(purchasedLottoList);
        return purchasedLottoList;
    }

    private void decideWinningNumbers() {
        OutputView.displayWinningNumberGuide();
        List<String> winningNumbers = getValidWinningNumbers();
        OutputView.displayBonusNumberGuide();
        while (true) {
            try {
                String bonusNumber = InputView.inputBonusNumber();
                LottoGameManager.generateWinningNumbers(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> getValidWinningNumbers() {
        while (true) {
            try {
                return InputView.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void displayWinningStatisticsAndYield(List<LottoMatch> winningResults, Amount amount) {
        OutputView.displayWinningStatisticsGuide();
        OutputView.displayWinningStatistics(winningResults);
        OutputView.displayYield(LottoGameManager.calculateYield(winningResults, amount));
    }
}
