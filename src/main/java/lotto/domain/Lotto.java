package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

//    public Lotto(List<Integer> numbers) {
//        validate(numbers);
//        this.numbers = numbers;
//    }
//
//    private void validate(List<Integer> numbers) {
//        if (numbers.size() != 6) {
//            throw new IllegalArgumentException();
//        }
//    }

    public Lotto(List<Integer> numbers) {
        validateAll(numbers);
        this.numbers = numbers;
    }

    private void validateAll(List<Integer> numbers) {
        validateCount(numbers);
        validateLengthAndType(numbers);
        validateDuplicate(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLengthAndType(List<Integer> numbers) {
        if(!numbers.stream().allMatch(n -> n >=1 && n <= 45)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if(!(numbers.size() == numbers.stream().distinct().count())) {
            throw new IllegalArgumentException();
        }
    }
}