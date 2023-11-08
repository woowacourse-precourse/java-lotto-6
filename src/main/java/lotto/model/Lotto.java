package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> distinctNumbers = distinctNumbers(numbers);
        validate(distinctNumbers);
        sortNumbersAscending(distinctNumbers);
        this.numbers = distinctNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private List<Integer> distinctNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().collect(Collectors.toList());
    }

    private void sortNumbersAscending(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}