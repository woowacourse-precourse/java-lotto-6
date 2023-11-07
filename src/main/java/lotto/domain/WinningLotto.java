package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ExceptionConstant.*;
import static lotto.constant.NumberConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.NumberConstant.MIN_LOTTO_NUMBER;

public final class WinningLotto {

    private final List<Integer> winningNumbers;
    private int bonusNumber;

    private WinningLotto(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningLotto of(final List<Integer> winningNumbers) {
        validateWinningNumberRange(winningNumbers);
        validateWinningNumberDuplication(winningNumbers);
        return new WinningLotto(winningNumbers);
    }

    public void createBonusNumber(final int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplication(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    // validation
    private static void validateWinningNumberRange(final List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (winningNumber < MIN_LOTTO_NUMBER || winningNumber > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(WINNING_NUMBER_RANGE_EXCEPTION);
            }
        }
    }

    private static void validateWinningNumberDuplication(final List<Integer> winningNumbers) {
        Set<Integer> distinctNumbers = new HashSet<>(winningNumbers);
        if (distinctNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATION_EXCEPTION);
        }
    }

    private void validateBonusNumberRange(final int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_EXCEPTION);
        }
    }

    private void validateBonusNumberDuplication(final int bonusNumber) {
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
