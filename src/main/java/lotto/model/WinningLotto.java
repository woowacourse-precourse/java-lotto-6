package lotto.model;

import lotto.validation.LottoNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningLotto {

    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    public WinningLotto() {
        settingWinningLotto();
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void settingWinningLotto() {
        this.winningNumber = readWinningNumber();
        this.bonusNumber = readBonusNumber();
    }

    private BonusNumber readBonusNumber() {
        do {
            try {
                int bonusNumber = InputView.readBonusNumber();
                validateBonusNumber(bonusNumber);
                return new BonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }
        } while (true);
    }

    private WinningNumber readWinningNumber() {
        do {
            try {
                return new WinningNumber(InputView.readWinningNumbers());
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }
        } while (true);
    }

    private void validateBonusNumber(int bonusNumber) {
        LottoNumberValidator.validateDuplicateBonusNumber(
                winningNumber.getWinningNumbers(),
                bonusNumber);
    }
}
