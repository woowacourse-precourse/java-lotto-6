package lotto;

import static lotto.ErrorMessage.DUPLICATED_BONUS_NUMBER;
import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

import java.util.List;

public record WinningNumbers(Lotto winningLotto, int bonusNumber) {
    public WinningNumbers {
        validate(winningLotto, bonusNumber);
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto);
        validate(bonusNumber);
        validateNotDuplicated(winningLotto, bonusNumber);
    }

    private void validate(Lotto winningLotto) {
        winningLotto.getNumbers().forEach(this::validateNumberInRange);
    }

    private void validate(int bonusNumber) {
        validateNumberInRange(bonusNumber);
    }

    private void validateNumberInRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    private void validateNotDuplicated(Lotto numbers, int bonusNumber) {
        List<Integer> winningNumbers = numbers.getNumbers();
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER);
        }
    }
}
