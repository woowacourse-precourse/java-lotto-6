package lotto.service;

import lotto.exception.Exception;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    void check_null(Lotto lotto) {
        if (lotto == null) {
            Exception.raiseInvalidInputException();
        }
    }

    public Lotto getValidateWinningNumber() {
        boolean isSuccess = false;
        Lotto lotto = null;
        while (!isSuccess) {
            try {
                OutputView.printWinningNumberInputRequestMessage();
                String winningNumber = InputView.getUserInput();
                lotto = new Lotto(winningNumber);
                check_null(lotto);
                isSuccess = true;
            } catch (IllegalArgumentException winningNumberInputError) {
                OutputView.printErrorMessage(winningNumberInputError);
            }
        }
        return lotto;
    }

    public WinningLotto getValidateBonusNumber(Lotto lotto) {
        boolean isSuccess = false;
        WinningLotto winningLotto = null;
        while (!isSuccess) {
            try {
                OutputView.printBonusNumberInputRequestMessage();
                String bonusNumber = InputView.getUserInput();
                winningLotto = new WinningLotto(lotto.getNumbers(), bonusNumber);
                check_null(winningLotto);
                isSuccess = true;
            } catch (IllegalArgumentException bonusNumberInputError) {
                OutputView.printErrorMessage(bonusNumberInputError);
            }
        }
        return winningLotto;
    }
}
