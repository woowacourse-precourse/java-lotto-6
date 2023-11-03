package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

        if (!(isDuplicate(numbers))) {
            throw new IllegalArgumentException();
        }

        if (!(isBetweenTwoNumbers(numbers, 1, 45))) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private boolean isDuplicate(List<Integer> numbers) {
        List<Integer> distinctNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (!(distinctNumbers.contains(number))) {
                distinctNumbers.add(number);
            }
        }

        return distinctNumbers.size() == numbers.size();
    }

    private boolean isBetweenTwoNumbers(List<Integer> numbers, int start, int end) {
        for (Integer number : numbers) {
            if (!((start <= number) && (start <= end))) {
                return false;
            }
        }

        return true;
    }
}
