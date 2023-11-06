package lotto.utility.validation;

import static lotto.constants.Condition.MAXIMUM_VALUE;
import static lotto.constants.Condition.MINIMUM_VALUE;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

public class LottoNumberChecker {
    public static void validate(Integer number) {
        if(number.compareTo(MINIMUM_VALUE) < 0 || number.compareTo(MAXIMUM_VALUE) > 0) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }
    }
}
