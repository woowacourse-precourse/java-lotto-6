package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidSize(numbers) || isInvalidRange(numbers) || hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1에서 45사이의 중복되지 않은 6개의 숫자로 이루어져야 합니다.");
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean isInvalidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number <= 0 || 45 < number) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() < numbers.size();
    }

    @Override
    public String toString() {
        List<Integer> clonedNumbers = new ArrayList<>(numbers);
        sortNumbers(clonedNumbers);
        return clonedNumbers.toString();
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public boolean contains(int targetNumber) {
        return numbers.contains(targetNumber);
    }
}
