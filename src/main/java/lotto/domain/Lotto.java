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
        validateUniqueness(numbers);
        validateInRange(numbers);
    }

    private void validateSizeOfSix(final List<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
    }

    private void validateUniqueness(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
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

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    public String formatNumbers() {
        return numbers.toString();
    }

    public void validateBonusBall(final int bonusBall) {
        validateBonusBallNotInLotto(bonusBall);
        validateBonusBallInRange(bonusBall);
    }

    private void validateBonusBallNotInLotto(final int bonusBall) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateBonusBallInRange(final int bonusBall) {
        if (isNumberOutOfRange(bonusBall)) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }

    private boolean isNumberOutOfRange(final int number) {
        return number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER;
    }
}
