package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = numbers.stream().sorted().collect(Collectors.toList());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidRange(List<Integer> numbers) {
        for(int number : numbers) {
            if(number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
