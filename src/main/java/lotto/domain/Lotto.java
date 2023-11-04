package lotto.domain;

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
        validateNumberSize(numbers);
        validateNumberDuplicate(numbers);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers){
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if(distinctNumbers.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }
}
