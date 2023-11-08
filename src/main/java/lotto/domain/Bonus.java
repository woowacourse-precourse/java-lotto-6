package lotto.domain;

import static lotto.domain.constants.LottoConfig.LOTTO_NUMBER_MAX;
import static lotto.domain.constants.LottoConfig.LOTTO_NUMBER_MIN;
import static lotto.exception.constants.ErrorMessage.BONUS_LOTTO_DUPLICATE;
import static lotto.exception.constants.ErrorMessage.NOT_NUMERIC_BONUS_NUMBER;
import static lotto.exception.constants.ErrorMessage.OUT_OF_RANGE_BONUS_NUMBER;

import lotto.exception.LottoException;

public class Bonus {
    private final Integer bonusNumber;

    private Bonus(final String bonusNumber, final Lotto lotto) {
        validate(bonusNumber, lotto);
        this.bonusNumber = Integer.valueOf(bonusNumber);
    }

    public static Bonus of(final String bonusNumber, final Lotto lotto) {
        return new Bonus(bonusNumber, lotto);
    }

    private void validate(final String bonusNumber, final Lotto lotto) {
        validateNumeric(bonusNumber);
        validateNumberRange(bonusNumber);
        validateDuplication(lotto, bonusNumber);
    }

    private void validateNumeric(final String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw LottoException.of(NOT_NUMERIC_BONUS_NUMBER);
        }
    }

    private void validateNumberRange(final String bonusNumber) {
        if (Integer.parseInt(bonusNumber) < LOTTO_NUMBER_MIN.getValue()
                || Integer.parseInt(bonusNumber) > LOTTO_NUMBER_MAX.getValue()) {
            throw LottoException.of(OUT_OF_RANGE_BONUS_NUMBER);
        }
    }

    private void validateDuplication(final Lotto lotto, final String bonusNumber) {
        if (lotto.getNumbers().contains(Integer.valueOf(bonusNumber))) {
            throw LottoException.of(BONUS_LOTTO_DUPLICATE);
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
