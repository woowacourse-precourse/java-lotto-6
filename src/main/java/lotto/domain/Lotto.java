package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();

        numbers.forEach(i -> set.add(i));

        if (set.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> sort() {
        List<Integer> sortedLotto =  numbers.stream().sorted((o1, o2) -> {
            return o1 - o2;
        }).toList();

        return sortedLotto;
    }

    public String printString() {
        return "[" + String.join(", ", makeStringNumbers(sort())) + "]";
    }

    private List<String> makeStringNumbers(List<Integer> numbers) {
        return numbers.stream().map(String::valueOf).toList();
    }
}
