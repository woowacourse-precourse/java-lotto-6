package lotto.domain;

import static lotto.domain.constants.LottoConstants.ERROR_LOTTO_NUMBER_RANGE;
import static lotto.domain.constants.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.domain.constants.LottoConstants.LOTTO_MIN_NUMBER;
import static lotto.domain.constants.LottoConstants.LOTTO_NUMBER_COUNT;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSizeOfSix(numbers);
        validateInRange(numbers);
        validateUniqueness(numbers);
    }

    private void validateSizeOfSix(final List<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
    }

    private void validateInRange(final List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isNumberOutOfRange)) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }

    private boolean isNumberOutOfRange(final Integer number) {
        return number == null || number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER;
    }

    private void validateUniqueness(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    public String formatNumbers() {
        return numbers.toString();
    }
}
