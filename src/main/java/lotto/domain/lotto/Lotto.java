package lotto.domain.lotto;

import java.util.List;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDistinct(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private void validateCount(List<Integer> numbers) {
        int numbersCount = numbers.size();
        int validNumbersCount = LottoConfig.NUMBERS_COUNT.getValue();
        if (numbersCount != validNumbersCount) {
            throw new IllegalArgumentException(LottoExceptionMessages.INVALID_NUMBERS_COUNT.getMessage());
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        int numbersCount = numbers.size();
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();
        if (numbersCount != distinctCount) {
            throw new IllegalArgumentException(LottoExceptionMessages.DUPLICATED_NUMBERS_COUNT.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
