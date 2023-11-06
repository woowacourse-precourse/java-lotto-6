package lotto;

import static lotto.Enum.ErrorMessage.DUPLICATED_ERROR;
import static lotto.Enum.ErrorMessage.LENGHT_ERROR;
import static lotto.Enum.ErrorMessage.NUMBER_RANGE_ERROR;
import static lotto.Enum.Number.SIX;
import static lotto.Enum.Number.MAX_NUMBER;
import static lotto.Enum.Number.MIN_NUMBER;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != SIX.getNumber()) {
            throw new IllegalArgumentException(LENGHT_ERROR.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER.getNumber() || number > MAX_NUMBER.getNumber()) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR.getMessage());
            }
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
