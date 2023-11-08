package lotto.domain;

import lotto.utils.ErrorMessage;

import java.util.HashSet;
import java.util.Set;


public class WinningNumbers {

    private static final int SIZE = 6;

    private final Set<WinningNumber> winningNumbers;

    public WinningNumbers(final Set<WinningNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers createWinningNumbers(final String[] inputWinningNumbers) {
        validateSize(inputWinningNumbers);

        Set<WinningNumber> initialWinningNumbers = new HashSet<>();
        for (int i = 0; i < SIZE; i++) {
            initialWinningNumbers.add(WinningNumber.createWinningNumber(inputWinningNumbers[i]));
        }
        validateDuplication(initialWinningNumbers);

        return new WinningNumbers(initialWinningNumbers);
    }

    public boolean isNumberExist(final WinningNumber number) {
        return winningNumbers.contains(number);
    }

    private static void validateSize(final String[] inputWinningNumbers) {
        if (inputWinningNumbers.length != SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_SIZE.getErrorMessage());
        }
    }

    private static void validateDuplication(final Set<WinningNumber> inputWinningNumbers) {
        if (inputWinningNumbers.size() != SIZE) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_VALUES.getErrorMessage());
        }
    }
}
