package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbersGenerator {
    private final int START_NUM = 1;
    private final int END_NUM = 45;
    private final int NUM_COUNT = 6;

    private List<Integer> winningNumbers;
    private int bonusNumber;
    private String[] winningNumberInput;

    public void generateWinningNumbers(final String[] winningNumbersInput) {
        this.setWinningNumberInput(winningNumbersInput);
        this.validateEachWinningNumberInput();
        this.validateDividedInput();
        this.saveWinningNumbers();
    }

    public void setWinningNumberInput(final String[] winningNumbersInput) {
        this.winningNumberInput = winningNumbersInput;
    }

    public void validateEachWinningNumberInput() {
        if (this.winningNumberInput.length != NUM_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBER.errorMessage);
        }

        final Set<String> noDuplicatedInput = Arrays.stream(this.winningNumberInput)
                .collect(Collectors.toSet());
        if (noDuplicatedInput.size() != NUM_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.errorMessage);
        }
    }

    public void validateDividedInput() {
        for (String winningNumberInput : this.winningNumberInput) {
            int winningNumber = Integer.parseInt(winningNumberInput);

            if (winningNumber > END_NUM || winningNumber < START_NUM) {
                throw new IllegalArgumentException(ErrorMessage.RANGE.errorMessage);
            }
        }
    }


    public void saveWinningNumbers() {
        this.winningNumbers = Arrays.stream(this.winningNumberInput).map(Integer::parseInt).toList();
    }

    public void generateBonusNumber(final int bonusNumberInput) {
        this.saveBonusNumber(bonusNumberInput);
        this.validateBonusNumber();
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
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
