package lotto.model;

import lotto.exception.InvalidPaymentAmountException;
import lotto.exception.InvalidRangeException;
import lotto.validation.Validator;
import java.util.List;

public class Lotto {
    private static final int WINNING_MAX_NUMBER = 45;
    private static final int WINNING_MIN_NUMBER = 1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validator.validateDuplicateNumber(numbers, "당첨");
        validateNumberInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validateNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < WINNING_MIN_NUMBER || number > WINNING_MAX_NUMBER) {
                throw new InvalidRangeException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
