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
        int lottoCount = calculateLottoCount(amount);
        final List<Lotto> lottoList = purchaseLottoByAmount(lottoCount);
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
                OutputView.displayExceptionMessage(e.getMessage());
            }
        }
    }

    private Amount getValidatedAmount() {
        return Amount.create(InputView.inputPurchaseAmount());
    }

    private List<Lotto> purchaseLottoByAmount(int lottoCount) {
        List<Lotto> purchasedLottoList = LottoGameManager.buyLotto(lottoCount);
        OutputView.displayLottoNumbers(purchasedLottoList);
        return purchasedLottoList;
    }

    private int calculateLottoCount(Amount amount) {
        int lottoCount = LottoGameManager.calculateLottoCount(amount);
        OutputView.displayLottoCount(lottoCount);
        return lottoCount;
    }

    private void decideWinningNumbers() {
        OutputView.displayWinningNumberGuide();
        Lotto winningLotto = getValidWinningNumbers();
        OutputView.displayBonusNumberGuide();
        while (true) {
            try {
                LottoGameManager.generateWinningNumbers(winningLotto, InputView.inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.displayExceptionMessage(e.getMessage());
            }
        }
    }

    private Lotto getValidWinningNumbers() {
        while (true) {
            try {
                return new Lotto(InputView.inputWinningNumbers());
            } catch (IllegalArgumentException e) {
                OutputView.displayExceptionMessage(e.getMessage());
            }
        }
    }

    private void displayWinningStatisticsAndYield(List<LottoMatch> winningResults, Amount amount) {
        OutputView.displayWinningStatisticsGuide();
        OutputView.displayWinningStatistics(winningResults);
        OutputView.displayYield(LottoGameManager.calculateYield(winningResults, amount));
    }
}
