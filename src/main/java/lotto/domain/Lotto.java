package lotto.domain;

import java.util.List;
import lotto.constant.ExceptionConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ExceptionConstant.LOTTO_NUMBER_DUPliCATE.getMessage());
        }
    }
}
