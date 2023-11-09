package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoConstant;
import lotto.constant.RegexPattern;
import lotto.constant.message.ExceptionMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateLottoLength(numbers);
        validateDuplicateNumbers(numbers);
        validateLottoRegex(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validateLottoLength(final List<Integer> numbers) {
        if (isLengthSix(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_LENGTH.toMessage());
        }
    }

    private boolean isLengthSix(final List<Integer> numbers) {
        return numbers.size() != LottoConstant.LOTTO_LENGTH;
    }

    private void validateDuplicateNumbers(final List<Integer> numbers) {
        if (isHaveDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATE_NUMBER.toMessage());
        }
    }

    private boolean isHaveDuplicateNumber(final List<Integer> numbers) {
        final Set<Integer> values = new HashSet<>(numbers);
        return values.size() < numbers.size();
    }

    private void validateLottoRegex(final List<Integer> numbers) {
        for (Integer number : numbers) {
            if (RegexPattern.isLottoNumberUnavailable(number)) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.toMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        validateNullLotto(numbers);
        return numbers;
    }

    private void validateNullLotto(final List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalStateException(ExceptionMessage.INVALID_NULL.toMessage());
        }
    }
}
