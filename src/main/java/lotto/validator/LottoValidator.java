package lotto.validator;

import lotto.constant.NumericConstant;

import java.util.Collection;

import static lotto.constant.ErrorMessage.ENTER_PROPER_LOTTO_COUNT;
import static lotto.constant.ErrorMessage.ENTER_PROPER_LOTTO_NUMBER;
import static lotto.constant.ErrorMessage.EXIST_DUPLICATED_NUMBER;
import static lotto.constant.NumericConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.NumericConstant.MIN_LOTTO_NUMBER;

public class LottoValidator {
    public static void validateIsProperSize(Collection<?> lottoNumbers) {
        if (lottoNumbers.size() != NumericConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ENTER_PROPER_LOTTO_COUNT);
        }
    }

    public static void validateDuplicatedNumber(Collection<?> lottoNumbers) {
        long count = lottoNumbers.stream()
                .distinct()
                .count();

        if (count != lottoNumbers.size()) {
            throw new IllegalArgumentException(EXIST_DUPLICATED_NUMBER);
        }
    }

    public static void validateRangeOfNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ENTER_PROPER_LOTTO_NUMBER);
        }
    }
}
