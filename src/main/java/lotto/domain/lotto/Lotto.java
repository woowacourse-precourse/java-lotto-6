package lotto.domain.lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        int numbersCount = numbers.size();
        int validNumbersCount = LottoConfig.NUMBERS_COUNT.getValue();
        if (numbersCount != validNumbersCount) {
            throw new IllegalArgumentException(LottoExceptionMessages.INVALID_NUMBERS_COUNT.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
