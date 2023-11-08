package lotto.domain;

import java.util.List;
import java.util.Set;
import lotto.constant.Constant;
import lotto.message.ExceptionMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validate(List<Integer> numbers) {
        if (isOutSize(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_SIZE.getMessage());
        }
        if (isNotUnique(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_UNIQUE.getMessage());
        }
        if (isOutRange(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RANGE.getMessage());
        }
    }

    private boolean isOutSize(List<Integer> numbers) {
        return numbers.size() != Constant.SIZE;
    }

    private boolean isOutRange(List<Integer> numbers) {
        return numbers.stream().anyMatch((number) -> (number < Constant.MIN || number > Constant.MAX));
    }

    private boolean isNotUnique(List<Integer> numbers) {
        return Set.copyOf(numbers).size() != Constant.SIZE;
    }
}
