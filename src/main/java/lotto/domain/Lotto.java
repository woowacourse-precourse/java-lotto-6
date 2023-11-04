package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private boolean isLengthSix(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (isLengthSix(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_LENGTH.toValue());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (isHaveDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATE_NUMBER.toValue());
        }
    }

    private boolean isHaveDuplicateNumber(List<Integer> numbers) {
        Set<Integer> values = new HashSet<>(numbers);
        return values.size() < numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
