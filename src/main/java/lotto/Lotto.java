package lotto;

import java.util.ArrayList;
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
        if (numbers.size() != 6 || duplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
    private boolean duplicated(List<Integer> numbers) {
        Set<Integer> sortedNumbers = new HashSet<>(numbers);
        List<Integer> newNumbers = new ArrayList<>(sortedNumbers);
        return newNumbers.size() != 6;
    }

}
