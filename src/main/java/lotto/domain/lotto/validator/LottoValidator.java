package lotto.domain.lotto.validator;

import java.util.Collections;
import java.util.List;
import lotto.constant.Constant;
import lotto.constant.errorMessage.exception.CustomIllegalArgumentException;
import lotto.constant.errorMessage.lotto.LottoExceptionStatus;

public class LottoValidator {

    private static final LottoValidator LOTTO_VALIDATOR = new LottoValidator();
    private static final int ALLOWED_MAXIMUM_NUMBER_COUNT = 1;

    private LottoValidator() {
    }

    public static void validateNumbers(final List<Integer> numbers) {
        LOTTO_VALIDATOR.validateNumbersOutOfRange(numbers);
        LOTTO_VALIDATOR.validateNumbersDuplicated(numbers);
    }

    private void validateNumbersOutOfRange(final List<Integer> numbers) {
        if (checkNumbersOutOfRange(numbers)) {
            throw new CustomIllegalArgumentException(LottoExceptionStatus.LOTTO_NUMBER_IS_OUT_OF_RANGE);
        }
    }

    private boolean checkNumbersOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(final int number) {
        return number < Constant.ALLOWED_MINIMUM_LOTTO_NUMBER
                || Constant.ALLOWED_MAXIMUM_LOTTO_NUMBER < number;
    }

    private void validateNumbersDuplicated(final List<Integer> numbers) {
        if (checkNumbersDuplicated(numbers)) {
            throw new CustomIllegalArgumentException(LottoExceptionStatus.LOTTO_NUMBER_IS_DUPLICATED);
        }
    }

    private boolean checkNumbersDuplicated(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> isDuplicated(numbers, number));
    }

    private boolean isDuplicated(final List<Integer> numbers, final int number) {
        return Collections.frequency(numbers, number) > ALLOWED_MAXIMUM_NUMBER_COUNT;
    }
}
