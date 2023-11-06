package lotto.model;

import static lotto.Constraints.SIZE;
import static lotto.model.enums.ErrorMessage.DUPLICATED_NUMBER_MESSAGE;
import static lotto.model.enums.ErrorMessage.INVALID_SIZE_MESSAGE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbersDuplicate(numbers);
    }

    // 6자리 검증
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE.getMessage());
        }
    }

    // 중복된 숫자 검증
    private void validateNumbersDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != SIZE.getValue()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_MESSAGE.getMessage());
        }
    }
}