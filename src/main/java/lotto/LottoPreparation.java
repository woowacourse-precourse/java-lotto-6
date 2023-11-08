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

    /*private PurchaseMoney setUpPurchaseMoney(String purchaseMoney) {
        //String purchaseMoney = InputView.inputPurchaseMoney();
        return new PurchaseMoney(Converter.convertToNumeric(purchaseMoney));
    }*/

    public Lotto runWinningNumbersStep() {
        try {
            return setUpWinningNumbers();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return runWinningNumbersStep();
    }

    private Lotto setUpWinningNumbers() {
        String winningNumbers = InputView.inputWinningNumbers();
        return new Lotto(Converter.convertWinningNumber(winningNumbers));
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
