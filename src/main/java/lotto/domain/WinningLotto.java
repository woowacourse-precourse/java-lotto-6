package lotto.domain;

import lotto.utils.LottoValidator;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonus;

    public WinningLotto(Lotto winningLotto, int bonus) {
        this.winningLotto = winningLotto;
        validate(winningLotto, bonus);
        this.bonus = bonus;
    }

    private void validate(Lotto winningLotto, int bonus) {
        LottoValidator.validateOutOfRange(bonus);
        validateDuplication();
    }

    private void validateDuplication() {
        boolean hasDuplication = winningLotto.hasBonusNumber(bonus);
        if (hasDuplication) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonus() {
        return bonus;
    }
}
