package lotto.validator;

import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.ErrorMessage;

public class LottoValidator {
    public static void validate(List<Integer> numbers) {
        LottoValidator.validateNumberSize(numbers);
        LottoValidator.validateDuplicateNumbers(numbers);
    }

    private static void validateNumberSize(final List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE_MESSAGE.getMessage());
        }
    }

    private static void validateDuplicateNumbers(final List<Integer> numbers) {
        for (Integer number : numbers) {
            long count = numbers.stream().filter(num -> num.equals(number)).count();

            if (count > 1) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS_MESSAGE.getMessage());
            }
        }
    }
}
