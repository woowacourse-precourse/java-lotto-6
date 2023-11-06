package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isNotDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void isNotDuplicated(List<Integer> numbers) {
        HashMap<Integer, Boolean> duplication = new HashMap<>();

        for (Integer number : numbers) {
            if (duplication.containsKey(number)) {
                throw new IllegalArgumentException();
            }

            duplication.put(number, true);
        }
    }

    public void print() {
        String numbersToString = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
