package lotto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int checkWinningNum(List<Integer> winnigNumbers) {
        return numbers.stream()
                .filter(old -> winnigNumbers.stream()
                        .noneMatch(Predicate.isEqual(old)))
                .toList()
                .size();
    }

    public boolean checkBonnusNum(int bonnusNum) {
        return numbers.contains(bonnusNum);
    }

}
