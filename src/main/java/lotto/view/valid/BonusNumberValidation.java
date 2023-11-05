package lotto.view.valid;

import lotto.domain.WinningLotto;

public class BonusNumberValidation implements InputValidation<Void> {

    private WinningLotto winningLotto;

    @Override
    public Void validateInput(final String bonusNumberText, final ViewValidator viewValidator) {
        int bonusNumber = viewValidator.parseInt(bonusNumberText);
        winningLotto.createBonusNumber(bonusNumber);
        return null;
    }

    public void assignWinningLotto(final WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }
}
