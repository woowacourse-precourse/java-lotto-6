package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstraint;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS_SIZE.getMessage());
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LottoConstraint.LOTTO_NUMBER_COUNT.getValue();
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if (containOutRangeNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean containOutRangeNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(this::isOutRangeNumber);
    }

    private boolean isOutRangeNumber(int number) {
        return number < LottoConstraint.MIN_LOTTO_NUMBER.getValue()
                || number > LottoConstraint.MAX_LOTTO_NUMBER.getValue();
    }

    public int countMatchedNumber(Lotto lotto) {
        return 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
