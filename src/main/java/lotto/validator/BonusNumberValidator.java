package lotto.validator;

import lotto.model.LottoNumber;

public class BonusNumberValidator {

    public static void validate(Integer number) {
        validateNumberRange(number);
    }

    private static void validateNumberRange(Integer number) {
        if (LottoNumber.isInRange(number)) {
            throw new IllegalArgumentException();
        }
    }
}
