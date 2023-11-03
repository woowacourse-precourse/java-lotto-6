package lotto.validation;

import java.util.List;
import lotto.utils.constant.LottoConstant;
import lotto.utils.message.ErrorMessage;

public class LottoNumberValidation {
    public void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_SIZE);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
    }

    private void validateRange(int n) {
        if (n < LottoConstant.LOTTO_NUMBER_MIN || n > LottoConstant.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE);
        }
    }
}
