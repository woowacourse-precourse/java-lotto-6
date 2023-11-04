package lotto.view.valid;

import lotto.domain.WinningLotto;

public class BonusNumberValidation implements InputValidation<Void> {

    private final WinningLotto winningLotto;

    public BonusNumberValidation(final WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    @Override
    public Void validateInput(final String bonusNumberText, final ViewValidator viewValidator) {
        int bonusNumber = viewValidator.parseInt(bonusNumberText);
        winningLotto.createBonusNumber(bonusNumber);
        return null;
    }
}
