package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
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
            throw new IllegalArgumentException();
        }
    }

    private void validateIntegerRange(List<Integer> numbers){
        boolean isInvalidRange = numbers.stream()
                .anyMatch(number -> number > 45 || number <= 0);
        if (isInvalidRange){
            throw new IllegalArgumentException();
        }
    }

    public boolean containsBonusNumber(int bonusNumber){
        return this.numbers.contains(bonusNumber);
    }

    public void validateNotDuplicated(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (numbers.size() != distinctCount){
            throw new IllegalArgumentException();
        }
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
