package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public Lotto(List<Integer> numbers, Integer bonusNumber) {
        validate(numbers);
        validateUnique(numbers);
        this.bonusNumber = bonusNumber;
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (checkUnique(numbers)) {
            throw new IllegalArgumentException("Numbers must be unique");
        }
    }

    private static boolean checkUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        return numbers.stream()
                .anyMatch(number -> !uniqueNumbers.add(number));
    }

}
