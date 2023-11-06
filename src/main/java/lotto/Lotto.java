package lotto;

import constants.NumberType;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validateLotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicateMember(numbers);
        validateAllNumberInRange(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (checkLength(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkLength(List<Integer> numbers) {
        return numbers.size() != NumberType.LOTTO_LENGTH.getValue();
    }

    private void validateDuplicateMember(List<Integer> numbers) {
        if (checkHasDuplicateMember(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkHasDuplicateMember(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private void validateAllNumberInRange(List<Integer> numbers) {
        if (!checkAllNumberInRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkAllNumberInRange(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> checkNumberInRange(num))
                .count() == numbers.size();
    }

    private boolean checkNumberInRange(int number) {
        return number >= NumberType.MIN_LOTTO_NUMBER.getValue() && number <= NumberType.MAX_LOTTO_NUMBER.getValue();
    }
}
