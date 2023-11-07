package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoExceptionValidator {
    protected LottoExceptionValidator() {
    }

    public void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            IllegalArgumentException exception = new LottoException(ExceptionCode.INVALID_LOTTO_SIZE);
            throw exception;
        }
    }

    public void duplicatedValidation(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean hasDuplicates = numbers.stream()
                .anyMatch(n -> !uniqueNumbers.add(n));
        if (hasDuplicates) {
            IllegalArgumentException exception = new LottoException(ExceptionCode.INVALID_LOTTO_DUPLICATED);
            throw exception;
        }
    }

    public void rangeValidation(List<Integer> numbers) {
        boolean isValid = numbers.stream()
                .allMatch(number -> (1 <= number && number <= 45));

        if (!isValid) {
            IllegalArgumentException exception = new LottoException(ExceptionCode.INVALID_LOTTO_RANGE);
            throw exception;
        }
    }
}
