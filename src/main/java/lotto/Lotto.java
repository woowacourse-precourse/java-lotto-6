package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final String INVALID_LENGTH = "[ERROR] 6개의 숫자여야 합니다.";
    private static final String INVALID_BOUND = "[ERROR] 1~45 사이의 숫자여야 합니다.";
    private static final String NOT_DUPLICATE = "[ERROR] 중복된 숫자는 입력 불가합니다";
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        this.validateLength(numbers);
        this.validateIntegerRange(numbers);
        this.validateNotDuplicated(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
    }

    private void validateIntegerRange(List<Integer> numbers){
        boolean isInvalidRange = numbers.stream()
                .anyMatch(number -> number > MAX_NUMBER || number < MIN_NUMBER);
        if (isInvalidRange){
            throw new IllegalArgumentException(INVALID_BOUND);
        }
    }

    public void validateNotDuplicated(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (numbers.size() != distinctCount){
            throw new IllegalArgumentException(NOT_DUPLICATE);
        }
    }

    public boolean containsBonusNumber(int bonusNumber){
        return this.numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public long compare(Lotto lotto) {
        List<Integer> compareNumbers = lotto.getNumbers();
        return this.numbers.stream()
                .filter(compareNumbers::contains)
                .count();
    }
}
