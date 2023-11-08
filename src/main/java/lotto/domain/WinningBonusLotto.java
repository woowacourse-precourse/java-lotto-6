package lotto.domain;

import lotto.view.ErrorMessage;

public class WinningBonusLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningBonusLotto(Lotto winning, int bonus) {
        try {
            validateBoundaryNumber(bonus);
            validateOverlapBonusNumber(winning, bonus);
            winningLotto = winning;
            bonusNumber = bonus;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBoundaryNumber(int input) {
        if (input < Lotto.LOTTO_START || input > Lotto.LOTTO_END)
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_1_TO_45_MESSAGE.getValue());
    }

    private void validateOverlapBonusNumber(Lotto winningNumbers, int bonus) {
        if (winningNumbers.getNumbers().contains(bonus))
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_OVERLAP_MESSAGE.getValue());
    }
}
