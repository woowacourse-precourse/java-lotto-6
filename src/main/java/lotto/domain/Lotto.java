package lotto.domain;

import static lotto.constant.NumberConstant.COUNT;
import static lotto.exception.ExceptionMessage.NOT_SIX_NUMBER;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.LottoValidator;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws LottoException {
        if (numbers.size() != COUNT.getValue()) {
            throw new LottoException(NOT_SIX_NUMBER);
        }
        LottoValidator.validateNotDuplicate(numbers);
        validateInRangeEachNumber(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public boolean hasSameNumber(int number) {
        return numbers.contains(number);
    }

    public int countMatchNumbers(Lotto other) {
        return (int) this.numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    private void validateInRangeEachNumber(List<Integer> numbers) {
        numbers.forEach(LottoValidator::validateInRange);
    }
}
