package lotto.domain.lotto.validator;

import java.util.Collections;
import java.util.List;
import lotto.constant.errorMessage.amount.IllegalStateAmountException;
import lotto.constant.errorMessage.lotto.LottoExceptionStatus;

public class LottoValidator {

    private static final LottoValidator LOTTO_VALIDATOR = new LottoValidator();
    private static final int ALLOWED_MAXIMUM_NUMBER_COUNT = 1;

    private LottoValidator() {
    }

    public static void validateNumbers(final List<Integer> numbers) {
        LOTTO_VALIDATOR.validateNumberIsDuplicated(numbers);
    }

    private void validateNumberIsDuplicated(final List<Integer> numbers) {
        if (checkNumberIsDuplicated(numbers)) {
            throw new IllegalStateAmountException(LottoExceptionStatus.LOTTO_NUMBER_IS_DUPLICATED);
        }
    }

    private boolean checkNumberIsDuplicated(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> isDuplicated(numbers, number));
    }

    private boolean isDuplicated(final List<Integer> numbers, final int number) {
        return Collections.frequency(numbers, number) > ALLOWED_MAXIMUM_NUMBER_COUNT;
    }
}
