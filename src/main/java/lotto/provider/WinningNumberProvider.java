package lotto.provider;

import lotto.error.Error;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberProvider {
    private static final int WINNING_START_NUMBER = 1;
    private static final int WINNING_END_NUMBER = 45;

    public List<Integer> getWinningNumber(String winningNumberInput) {
        String[] splitInputs = winningNumberInput.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String splitInput : splitInputs) {
            int winningNumber = parseValidNumber(splitInput);
            validateDuplication(winningNumbers, winningNumber);
            winningNumbers.add(winningNumber);
        }
        validateSize(winningNumbers);

        return winningNumbers;
    }

    private int parseValidNumber(String input) {
        validateInteger(input);
        int parseInput = Integer.parseInt(input);
        validateRange(parseInput);

        return parseInput;
    }

    private void validateDuplication(List<Integer> winningNumbers, int winningNumber) {
        if (winningNumbers.contains(winningNumber)) {
            throw new IllegalArgumentException(Error.WINNING_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    private void validateInteger(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(Error.WINNING_NUMBER_INPUT_INTEGER_ERROR.getMessage());
        }
    }

    private void validateRange(int input) {
        if (WINNING_START_NUMBER > input || input > WINNING_END_NUMBER) {
            throw new IllegalArgumentException(Error.WINNING_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private void validateSize(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException(Error.WINNING_NUMBER_SIZE_ERROR.getMessage());
        }
    }
}
