package lotto.domain;

import static lotto.config.GameNumberConfig.LOTTO_RANGE_MAX;
import static lotto.config.GameNumberConfig.LOTTO_RANGE_MIN;
import static lotto.exception.ErrorMessage.VALIDATE_DUPLICATE;
import static lotto.exception.ErrorMessage.VALIDATE_RANGE;

import java.util.List;

public class BonusNumber {
    private final int number;

    public BonusNumber(Lotto lotto, int number) {
        validate(lotto, number);
        this.number = number;
    }

    private void validate(Lotto lotto, int number) {
        checkDuplicate(lotto, number);
        checkRange(number);
    }

    private void checkDuplicate(Lotto lotto, int number) {
        if (lotto.doesContain(number)) {
            throw new IllegalArgumentException(VALIDATE_DUPLICATE.getMessage());
        }
    }

    private static void checkRange(int number) {
        if (number > LOTTO_RANGE_MAX.getNumber() || number < LOTTO_RANGE_MIN.getNumber()) {
            throw new IllegalArgumentException(VALIDATE_RANGE.getMessage());
        }
    }

}
