package lotto.domain.lotto.validator;

import java.util.Collections;
import java.util.List;
import lotto.constant.Constant;
import lotto.exception.custom.CustomIllegalArgumentException;
import lotto.exception.lotto.LottoExceptionStatus;

public class LottoValidator {

    private static final LottoValidator LOTTO_VALIDATOR = new LottoValidator();

    private LottoValidator(){
    }

    public static void validateLotto(final List<Integer> numbers) {
        LOTTO_VALIDATOR.validateLottoIsOutOfSize(numbers);
        LOTTO_VALIDATOR.validateLottoIsDuplicated(numbers);
    }

    private void validateLottoIsOutOfSize(final List<Integer> numbers) {
        if (isOutOfSize(numbers)) {
            throw new CustomIllegalArgumentException(LottoExceptionStatus.LOTTO_IS_OUT_OF_SIZE);
        }
    }

    private boolean isOutOfSize(final List<Integer> numbers) {
        return numbers.size() != Constant.ALLOWED_SIZE_PER_LOTTO.getConstant();
    }

    private void validateLottoIsDuplicated(final List<Integer> numbers) {
        if (checkLottoIsDuplicated(numbers)) {
            throw new CustomIllegalArgumentException(LottoExceptionStatus.LOTTO_IS_DUPLICATED);
        }
    }

    private boolean checkLottoIsDuplicated(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> isDuplicated(numbers, number));
    }

    private boolean isDuplicated(final List<Integer> numbers, final int number) {
        return Collections.frequency(numbers, number)
                > Constant.ALLOWED_MINIMUM_NUMBER.getConstant();
    }
}
