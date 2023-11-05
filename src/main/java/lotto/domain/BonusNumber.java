package lotto.domain;

import static lotto.domain.DomainError.*;

public class BonusNumber {

    private int number;

    public BonusNumber(int number, Lotto lotto) {
        validateDuplicateNumber(number, lotto);
        this.number = number;
    }

    private void validateDuplicateNumber(int number, Lotto lotto) {
        if (lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR.getMessage());
        }
    }
}
