package lotto.model.lotto;

import static lotto.constants.Error.DUPLICATE_INVALID;
import static lotto.constants.Error.RANGE_INVALID;
import static lotto.constants.Error.SIZE_INVALID;
import static lotto.constants.Rule.LOTTO_SIZE;
import static lotto.constants.Rule.MAX_LOTTO;
import static lotto.constants.Rule.MIN_LOTTO;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateRange(numbers);
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> !isValidNumber(number))) {
            throw new IllegalArgumentException(RANGE_INVALID.getMessage());
        }
    }

    private static boolean isValidNumber(int number) {
        return number >= MIN_LOTTO.getValue() && number <= MAX_LOTTO.getValue();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(SIZE_INVALID.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_INVALID.getMessage());
        }
    }

    public int countMatchNumbers(Winning winning) {
        return (int) numbers.stream().filter(winning.getLotto()::isMatchNumber).count();
    }

    public boolean isMatchNumber(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
