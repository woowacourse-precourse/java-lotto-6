package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        lengthValidate(numbers);
        duplicationValidate(numbers);
        rangeValidate(numbers);
        this.numbers = numbers;
    }

    public int get(int index) {
        return numbers.get(index);
    }

    private void lengthValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicationValidate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                throw new IllegalArgumentException();
            }
            set.add(number);
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
}
