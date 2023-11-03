package lotto;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (hasDuplicates(numbers)){
            throw new IllegalArgumentException();
        }

        if (isNumbersOutOfRange(numbers)){
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicates(List<Integer> numbers){
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbersSet.size() != numbers.size();
    }

    private boolean isNumbersOutOfRange(List<Integer> numbers){
        return numbers.stream().anyMatch(number -> number < 1 || number > 45);
    }
}
