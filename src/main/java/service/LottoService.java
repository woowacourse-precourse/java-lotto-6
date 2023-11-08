package service;

import exception.Exception;
import model.Lotto;
import model.WinningLotto;
import view.InputView;
import view.OutputView;

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
                String winningNumber = InputView.getWinningNumber();
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
                String bonusNumber = InputView.getBonusNumber();
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
