package lotto.domain;

import static lotto.global.enums.Constants.LOTTO_NUM_CNT;
import static lotto.global.enums.ErrorType.DUPLICATE_NUMBER_IN_LOTTO;
import static lotto.global.enums.ErrorType.INVALID_COUNT_OF_LOTTO_NUMBER;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUM_CNT) {
            throw new IllegalArgumentException(INVALID_COUNT_OF_LOTTO_NUMBER.getMessage());
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_IN_LOTTO.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
