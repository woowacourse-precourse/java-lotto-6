package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumber(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> checkSet = new HashSet<>();
        for (Integer number : numbers) {
            if (checkSet.contains(number)) {
                throw new IllegalArgumentException();
            }
            checkSet.add(number);
        }
    }

    public void printNumbers() {
        System.out.println(numbers);
    }

    // TODO: 추가 기능 구현
}
