package lotto.domain;

import lotto.utils.LottoValidator;
import lotto.utils.MessageConstant;

public record WinningLotto(Lotto winningLotto, int bonus) {

    public WinningLotto(Lotto winningLotto, int bonus) {
        this.winningLotto = winningLotto;
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(int bonus) {
        LottoValidator.validateOutOfRange(bonus);
        validateDuplication(bonus);
    }

    private void validateDuplication(int bonus) {
        boolean hasDuplication = winningLotto.hasBonusNumber(bonus);
        if (hasDuplication) {
            throw new IllegalArgumentException(MessageConstant.DUPLICATION);
        }
    }
}
