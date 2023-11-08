package lotto.view;

import static lotto.constants.ExceptionMessage.ERROR_PREFIX;
import static lotto.constants.ExceptionMessage.EXCEPTION_DUPLICATED;
import static lotto.constants.ExceptionMessage.EXCEPTION_NEED_BIGGER_NUM;
import static lotto.constants.ExceptionMessage.EXCEPTION_NEED_DIVISIBLE_NUM;
import static lotto.constants.ExceptionMessage.EXCEPTION_NOT_INTEGER;
import static lotto.constants.ExceptionMessage.EXCEPTION_OUT_OF_RANGE;
import static lotto.constants.ExceptionMessage.EXCEPTION_WRONG_LENGTH;
import static lotto.constants.LottoConstants.LOTTO_LENGTH;
import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoConstants.MAXIMUM_NUM;
import static lotto.constants.LottoConstants.MINIMUM_NUM;

import java.util.List;

public class Exceptions {
    public static void validateDuplicateNum(int number, List<Integer> nums) {
        if (nums.contains(number)) {
            throw new IllegalArgumentException(ERROR_PREFIX + EXCEPTION_DUPLICATED);
        }
    }

    public static void validateLottoNum(int number) {
        if (number < MINIMUM_NUM || number > MAXIMUM_NUM) {
            throw new IllegalArgumentException(ERROR_PREFIX + EXCEPTION_OUT_OF_RANGE);
        }
    }

    public static void validateLottoLength(int length) {
        if (length != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + EXCEPTION_WRONG_LENGTH);
        }
    }

    public static void validateNumber() {
        throw new IllegalArgumentException(ERROR_PREFIX + EXCEPTION_NOT_INTEGER);
    }

    public static void validateExceedMinimum(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_PREFIX + EXCEPTION_NEED_BIGGER_NUM);
        }
    }

    public static void validateDivisibleAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + EXCEPTION_NEED_DIVISIBLE_NUM);
        }
    }
}
