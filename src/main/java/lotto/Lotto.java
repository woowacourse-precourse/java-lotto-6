package lotto;

import java.util.List;

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
        validateDuplicateNumbers(numbers);
        validateNumberRange(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateDuplicateNumbers(List<Integer> numbers){
        final int LOTTO_NUMBERS_SIZE = 6;
        long distinctCount = numbers.stream().distinct().count();
        if(distinctCount != LOTTO_NUMBERS_SIZE){
            throw new IllegalArgumentException();
        }
    }
    private void validateNumberRange(List<Integer> numbers){
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 45;

        boolean isOutOfRange = numbers.stream()
            .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER);

        if(isOutOfRange){
            throw new IllegalArgumentException();
        }
    }
}
