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
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if(isInvalidSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS_SIZE.getMessage());
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LottoConstraint.LOTTO_NUMBER_COUNT.getValue();
    }

    public int countMatchedNumber(Lotto lotto) {
        return 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
