package lotto.domain;

import lotto.view.message.ErrorMessage;

import java.util.*;

public class WinningNumbers {
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int NUM_COUNT = 6;

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void generateWinningNumbers(final List<Integer> winningNumbersInput) {
        validateWinningNumberInputSize(winningNumbersInput);
        validateDuplicateWinningNumber(winningNumbersInput);
        validateWinningNumberRange(winningNumbersInput);
        saveWinningNumbers(winningNumbersInput);
    }

    public void validateWinningNumberInputSize(final List<Integer> winningNumbersInput) {
        if (winningNumbersInput.size() != NUM_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBER.errorMessage);
        }
    }

    public void validateDuplicateWinningNumber(final List<Integer> winningNumbersInput) {
        final Set<Integer> noDuplicatedInput = new HashSet<>(winningNumbersInput);

        if (noDuplicatedInput.size() != NUM_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.errorMessage);
        }
    }

    public void validateWinningNumberRange(final List<Integer> winningNumbersInput) {
        winningNumbersInput.forEach(number -> {
            if (number > END_NUM || number < START_NUM) {
                throw new IllegalArgumentException(ErrorMessage.RANGE.errorMessage);
            }
        });
    }

    public void saveWinningNumbers(final List<Integer> winningNumbersInput) {
        this.winningNumbers = winningNumbersInput;
    }

    public void generateBonusNumber(final int bonusNumberInput) {
        validateBonusNumber(bonusNumberInput);
        saveBonusNumber(bonusNumberInput);
    }

    public void validateBonusNumber(final int bonusNumberInput) {
        if (bonusNumberInput > END_NUM || bonusNumberInput < START_NUM) {
            throw new IllegalArgumentException(ErrorMessage.RANGE.errorMessage);
        }
        if (winningNumbers.contains(bonusNumberInput)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUM_CONTAIN_BONUS_NUM.errorMessage);
        }
    }

    public void saveBonusNumber(final int bonusNumberInput) {
        this.bonusNumber = bonusNumberInput;
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
