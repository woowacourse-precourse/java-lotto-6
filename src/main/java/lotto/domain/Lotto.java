package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String NOT_SIX_DIGIT_EXCEPTION_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "로또 번호에 중복된 숫자가 있습니다.";
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "로또 번호는 1~45 사이의 숫자여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumberOfNumbers(numbers);
        checkDuplication(numbers);
        checkNumberRange(numbers);
    }

    private void checkNumberOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_SIX_DIGIT_EXCEPTION_MESSAGE);
        }
    }

    private void checkDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
            }
        }
        //boolean numbers.stream().allMatch(number -> number >=1 && number <= 45);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
