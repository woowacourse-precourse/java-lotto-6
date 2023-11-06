package lotto.domain;

import java.util.List;
import java.util.Set;

public class LottoWinningNumber {

    private static final int ALLOWED_NUMBER_SIZE = 6;
    private static final int START_NUMBER_IN_RANGE = 1;
    private static final int END_NUMBER_IN_RANGE = 45;

    private final List<Integer> numbers;

    public LottoWinningNumber(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (!isAllowedNumberSize(numbers) || !isUniqueNumbers(numbers) || !isNumbersInRange(numbers)) {
            throw new IllegalArgumentException("유효하지 않은 당첨 번호입니다.");
        }
    }

    private boolean isAllowedNumberSize(List<Integer> numbers) {
        return numbers.size() == ALLOWED_NUMBER_SIZE;
    }

    private boolean isUniqueNumbers(List<Integer> numbers) {
        return Set.copyOf(numbers)
                .size() == ALLOWED_NUMBER_SIZE;
    }

    private boolean isNumbersInRange(List<Integer> numbers) {
        return numbers.stream()
                .noneMatch(number -> number < START_NUMBER_IN_RANGE || number > END_NUMBER_IN_RANGE);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
