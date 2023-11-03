package lotto.view.valid;

import lotto.domain.WinningLotto;

public class BonusNumberValidation implements InputValidation<Void> {

    private final ViewValidator viewValidator;
    private final WinningLotto winningLotto;

    public BonusNumberValidation(final ViewValidator viewValidator, final WinningLotto winningLotto) {
        this.viewValidator = viewValidator;
        this.winningLotto = winningLotto;
    }

    @Override
    public Void validateInput(final String bonusNumberText) {
        int bonusNumber = viewValidator.parseInt(bonusNumberText);
        winningLotto.createBonusNumber(bonusNumber);
        return null;
    }
}
