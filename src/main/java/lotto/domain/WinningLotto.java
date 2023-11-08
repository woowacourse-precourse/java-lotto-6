package lotto.domain;

import static lotto.constants.Error.DUPLICATION_BONUS_ERROR;
import static lotto.constants.Error.RANGE_ERROR;
import static lotto.constants.Value.MAX_LOTTO_NUMBER;
import static lotto.constants.Value.MIN_LOTTO_NUMBER;

import java.util.List;

public class WinningLotto {
    private int bounusNumber;
    private List<Integer> winningNumber;

    public WinningLotto(Lotto winningNumber) {
        List<Integer> numbers = winningNumber.getNumbers();
        for (int number : numbers) {
            validateRange(number);
        }
        this.winningNumber = numbers;
    }

    public void setBounusNumber(int bounusNumber) {
        validateRange(bounusNumber);
        validateDuplication(bounusNumber);
        this.bounusNumber = bounusNumber;
    }

    public int getBounusNumber() {
        return bounusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    private void validateRange(int number) {
        if (number < MIN_LOTTO_NUMBER.get() || number > MAX_LOTTO_NUMBER.get()) {
            throw new IllegalArgumentException(RANGE_ERROR.getMessage());
        }
    }

    private void validateDuplication(int bonusNumber) {
        for (int number : winningNumber) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException(DUPLICATION_BONUS_ERROR.getMessage());
            }
        }
    }
}
