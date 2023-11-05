package lotto.domain;

import static lotto.settings.ErrorMessage.INVALID_COUNT;
import static lotto.settings.ErrorMessage.INVALID_RANGE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number<1 || number>45){
                throw new IllegalArgumentException(INVALID_RANGE.getMessage());
            }
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
