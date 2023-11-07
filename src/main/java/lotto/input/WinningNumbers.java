package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

import static lotto.output.Constants.WinningNumbersConstants.SIX_LENGTH_ERROR_MESSAGE;
import static lotto.output.Constants.WinningNumbersConstants.SIX_NUMBERS_INPUT_MESSAGE;

public class WinningNumbers extends NumbersValidator {
    public static Set<Integer> getWinningNumbers() {
        System.out.println(SIX_NUMBERS_INPUT_MESSAGE);
        while (true) {
            try {
                return inputNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Set<Integer> inputNumbers() {
        Set<Integer> winningNumbers = new HashSet<>();
        String input = Console.readLine();
        String[] inputNumbers = input.split(",");
        validateInput(inputNumbers, winningNumbers);
        System.out.println();
        return winningNumbers;
    }

    protected static void validateInput(String[] inputNumbers, Set<Integer> winningNumbers) {
        if (inputNumbers.length != 6) {
            System.out.println();
            throw new IllegalArgumentException(SIX_LENGTH_ERROR_MESSAGE);
        }
        storeNumbers(inputNumbers, winningNumbers);
    }

    private static void storeNumbers(String[] inputNumbers, Set<Integer> winningNumbers) {
        for (String number : inputNumbers) {
            int winningNum = validateNumberFormat(number.trim());
            validateNumberRange(winningNum);
            validateDuplicate(winningNum, winningNumbers);
        }
    }
}