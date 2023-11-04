package lotto.domain;

import java.util.List;
import lotto.exception.ExceptionType;
import lotto.exception.InputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isSixLength(numbers)) {
            throw new InputException(ExceptionType.ERROR_LOTTO_INPUT_SIX);
        }

        if (isDuplicates(numbers)) {
            throw new InputException(ExceptionType.ERROR_LOTTO_DUPLICATE);
        }
    }

    private static boolean isSixLength(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    public boolean isDuplicates(List<Integer> numbers) {
        return numbers.size() > numbers.stream().distinct().count();
    }

}
