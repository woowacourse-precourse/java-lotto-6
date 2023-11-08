package lotto;

import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoPreparation {
    public PurchaseMoney setUpPurchaseMoney(String purchaseMoney) {
        try {
            return new PurchaseMoney(Converter.convertToNumeric(purchaseMoney));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return setUpPurchaseMoney(purchaseMoney);
    }

    public Lotto setUpWinningNumbers(String winningNumbers) {
        try {
            return new Lotto(Converter.convertWinningNumber(winningNumbers));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return setUpWinningNumbers(winningNumbers);
    }

    public WinningLotto runWinningLottoStep(Lotto winningNumber) {
        try {
            return setUpWinningLotto(winningNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return runWinningLottoStep(winningNumber);
    }

    private WinningLotto setUpWinningLotto(Lotto winningNumbers) {
        return new WinningLotto(winningNumbers, setUpBonusNumber());
    }

    private int setUpBonusNumber() {
        String bonusNumber = InputView.inputBonusNumber();
        return Converter.convertToNumeric(bonusNumber);
    }
}
