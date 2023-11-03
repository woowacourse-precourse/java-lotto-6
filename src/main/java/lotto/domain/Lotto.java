package lotto.domain;

import java.util.List;
import lotto.util.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersInRange(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        if (!isNumbersInRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IN_RANGE.getMessage());
        }
    }

    private boolean isNumbersInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number ->
                        number >= LottoNumberRule.MIN.number() &&
                        number <= LottoNumberRule.MAX.number()
                );
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_UNIQUE.getMessage());
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    // TODO: 추가 기능 구현
}
