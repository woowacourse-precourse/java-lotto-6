package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto extends InputNumbers {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        numbers.forEach(this::checkBoundary);
        checkDuplication(numbers);
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int countEqual(List<Integer> numbers) {
        List<Integer> originalNumbers = new ArrayList<>(this.numbers);
        originalNumbers.retainAll(numbers);
        return originalNumbers.size();
    }

    public Boolean contain(Integer number) {
        return this.numbers.contains(number);
    }
}
