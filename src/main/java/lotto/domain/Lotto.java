package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = sortNumbers(numbers);
        this.numbers = numbers;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
