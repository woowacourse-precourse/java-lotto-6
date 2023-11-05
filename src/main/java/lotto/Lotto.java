package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (set.contains(number))
                throw new IllegalArgumentException(ExceptionMessage.LOTTO_DUPLICATION.getMessage());
            set.add(number);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if((number < Constant.MIN.value) || (number > Constant.MAX.value))
                throw new IllegalArgumentException(ExceptionMessage.LOTTO_RANGE.getMessage());
        }
    }

    enum Constant{
        MIN(1),
        MAX(45),
        ;

        private final int value;

        Constant(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
