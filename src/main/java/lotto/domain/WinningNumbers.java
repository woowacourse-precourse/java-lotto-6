package lotto.domain;

import lotto.Rank;
import lotto.exception.ExceptionMessage;

public record WinningNumbers(Lotto winningLotto, int bonus) {
    public WinningNumbers {
        validate(winningLotto, bonus);
    }

    private void validate(Lotto winningLotto, int bonus) {
        validateRange(bonus);
        validateDuplicated(winningLotto, bonus);
    }

    private void validateRange(int bonus) {
        if (LottoRule.outOfRange(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateDuplicated(Lotto winningLotto, int bonus) {
        if (winningLotto.contains(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    public Rank rank(Lotto lotto) {
        return lotto.rank(winningLotto, bonus);
    }
}
