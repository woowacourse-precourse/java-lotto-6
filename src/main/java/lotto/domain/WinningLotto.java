package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.ExceptionConstant.BONUS_NUMBER_DUPLICATION_EXCEPTION;
import static lotto.constant.ExceptionConstant.BONUS_NUMBER_RANGE_EXCEPTION;
import static lotto.constant.NumberConstant.MAX_BONUS_NUMBER;
import static lotto.constant.NumberConstant.MIN_BONUS_NUMBER;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private int bonusNumber;

    private WinningLotto(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningLotto of(final List<String> numbersText) {
        List<Integer> numbers = new ArrayList<>();
        for (String text : numbersText) {
            int winningNumber = Integer.parseInt(text);
            numbers.add(winningNumber);
        }
        return new WinningLotto(numbers);
    }

    public void createBonusNumber(final int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplication(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(final int bonusNumber) {
        if (bonusNumber < MIN_BONUS_NUMBER || bonusNumber > MAX_BONUS_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_EXCEPTION);
        }
    }

    private void validateDuplication(final int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_EXCEPTION);
        }
    }

    // getter
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
