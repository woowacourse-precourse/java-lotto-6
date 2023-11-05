package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberProvider {
    private static final int WINNING_START_NUMBER = 1;
    private static final int WINNING_END_NUMBER = 45;

    public WinningNumber getWinningNumber(String winningNumberInput, String bonusInput) {
        List<Integer> winningNumber = parseWinningNumber(winningNumberInput);
        int bonus = parseValidNumber(bonusInput);
        validateBonus(winningNumber, bonus);

        return new WinningNumber(winningNumber, bonus);
    }

    private List<Integer> parseWinningNumber(String input) {
        String[] splitInputs = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String splitInput : splitInputs) {
            int winningNumber = parseValidNumber(splitInput);
            if (winningNumbers.contains(winningNumber)) {
                throw new IllegalArgumentException("error");
            }

            winningNumbers.add(winningNumber);
        }

        return winningNumbers;
    }

    private int parseValidNumber(String input) {
        validateInteger(input);
        int parseInput = Integer.parseInt(input);
        validateRange(parseInput);

        return parseInput;
    }

    private void validateBonus(List<Integer> winningNumber, int bonus) {
        if (winningNumber.contains(bonus)) {
            throw new IllegalArgumentException("error");
        }
    }

    private void validateInteger(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("error");
        }
    }

    private void validateRange(int input) {
        if (WINNING_START_NUMBER > input || input > WINNING_END_NUMBER) {
            throw new IllegalArgumentException("error");
        }
    }
}
