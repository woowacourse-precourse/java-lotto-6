package lotto.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSixDigits(numbers);
        validateDuplicate(numbers);
        validateAscendingOrder(numbers);
    }

    private void validateSixDigits(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = numbers.stream()
                .collect(Collectors.toSet());
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateAscendingOrder(List<Integer> numbers) {
        for (int i = 0; i < numbers.size()-1; i++) {
            if (numbers.get(i) >= numbers.get(i+1)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int countMatchingNumber(Lotto targetLotto) {
        int count = 0;
        for (int number : numbers) {
            if (targetLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }



}

