package lotto;

import static lotto.constant.LottoInformation.MAX_NUMBER;
import static lotto.constant.LottoInformation.MIN_NUMBER;
import static lotto.constant.LottoInformation.NUMBER_COUNT;
import static lotto.constant.message.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.constant.message.ErrorMessage.INVALID_NUMBER_RANGE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean result = numbers.stream().allMatch(this::isValidRange);

        if (!result) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }

    private boolean isValidRange(int number) {
        return number >= MIN_NUMBER && number < MAX_NUMBER;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
