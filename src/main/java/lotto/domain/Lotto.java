package lotto.domain;

import static lotto.constants.ErrorMessage.INVALID_DUPLICATE_NUMBERS;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_LENGTH;
import static lotto.constants.ErrorMessage.INVALID_NUMBER_RANGE;

import java.util.List;
public class Lotto {
    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 45;
    public static final int NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumber(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchingNumber(Lotto targetLotto) {
        return (int) numbers.stream()
                .filter(number -> targetLotto.contains(number))
                .count();
    }
    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_LENGTH);
        }
    }

    public static void validateRange(int number) {
        if(number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    private void validateNumber(List<Integer> numbers) {
        for (int number : numbers) {
            validateRange(number);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBERS);
        }
    }
}
