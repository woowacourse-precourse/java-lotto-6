package lotto.model;

import lotto.validation.LottoNumberValidator;

public class WinningLotto {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningLotto(WinningNumber winningNumber, BonusNumber bonusNumber) {
        LottoNumberValidator.validateDuplicateBonusNumber(
                winningNumber.getWinningNumbers(),
                bonusNumber.getBonusNumber());

        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }
}
