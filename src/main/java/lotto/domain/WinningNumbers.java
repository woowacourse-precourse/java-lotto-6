package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int NUM_COUNT = 6;

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void generateWinningNumbers(final String[] winningNumbersInput) {
        validateEachWinningNumberInput(winningNumbersInput);
        validateDividedInput(winningNumbersInput);
        saveWinningNumbers(winningNumbersInput);
    }

    public void validateEachWinningNumberInput(final String[] winningNumbersInput) {
        if (winningNumbersInput.length != NUM_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBER.errorMessage);
        }

        final Set<String> noDuplicatedInput = Arrays.stream(winningNumbersInput)
                .collect(Collectors.toSet());
        if (noDuplicatedInput.size() != NUM_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.errorMessage);
        }
    }

    public void validateDividedInput(final String[] winningNumbersInput) {
        for (String winningNumberInput : winningNumbersInput) {
            int winningNumber = Integer.parseInt(winningNumberInput);

            if (winningNumber > END_NUM || winningNumber < START_NUM) {
                throw new IllegalArgumentException(ErrorMessage.RANGE.errorMessage);
            }
        }
    }


    public void saveWinningNumbers(final String[] winningNumbersInput) {
        this.winningNumbers = Arrays.stream(winningNumbersInput).map(Integer::parseInt).toList();
    }

    public void generateBonusNumber(final int bonusNumberInput) {
        saveBonusNumber(bonusNumberInput);
        validateBonusNumber();
    }


    public void saveBonusNumber(final int bonusNumberInput) {
        this.bonusNumber = bonusNumberInput;
    }

    public void validateBonusNumber() {
        if (this.bonusNumber > END_NUM || this.bonusNumber < START_NUM) {
            throw new IllegalArgumentException(ErrorMessage.RANGE.errorMessage);
        }
        if (this.winningNumbers.contains(this.bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUM_CONTAIN_BONUS_NUM.errorMessage);
        }
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
