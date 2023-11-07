package lotto.domain;

import lotto.view.ErrorMessage;

public class WinningLotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int WINNING_LOTTO_SIZE = 6;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateNumberRange(bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_RANGE || bonusNumber > MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_NUMBER);
        }
    }
}
