package lotto.model;

import lotto.validation.LottoNumberValidator;

public class WinningLotto {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningLotto(WinningNumber winningNumber, BonusNumber bonusNumber) {
        validate(winningNumber, bonusNumber);

        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validate(WinningNumber winningNumber, BonusNumber bonusNumber) {
        LottoNumberValidator.validateDuplicateBonusNumber(
                winningNumber.getWinningNumbers(),
                bonusNumber.getBonusNumber());
    }
}
