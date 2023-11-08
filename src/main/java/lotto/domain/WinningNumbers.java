package lotto.domain;

import static lotto.domain.Lotto.MAX_NUMBER;
import static lotto.domain.Lotto.MIN_NUMBER;
import static lotto.domain.Lotto.NUMBER_LENGTH;
import static lotto.error.ErrorMessage.DUPLICATE_WINNING_NUMBER;
import static lotto.error.ErrorMessage.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.error.ErrorMessage.INVALID_WINNING_NUMBER_LENGTH;
import static lotto.error.ErrorMessage.WINNING_NUMBER_OUT_OF_RANGE;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private static final String COMMA = ",";

    private List<Integer> winningNumbers;

    private WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers of(String input) {
        return new WinningNumbers(validateWinningNumbers(input));
    }

    private static List<Integer> validateWinningNumbers(String input) {
        List<Integer> winningNumbers = validateFormatAndConvert(input.split(COMMA), INVALID_WINNING_NUMBER_FORMAT);
        validateLength(winningNumbers, INVALID_WINNING_NUMBER_LENGTH);
        for (Integer number : winningNumbers) {
            validateRange(number, WINNING_NUMBER_OUT_OF_RANGE);
        }
        validateDuplicate(winningNumbers, DUPLICATE_WINNING_NUMBER);
        return winningNumbers;
    }

    private static List<Integer> validateFormatAndConvert(String[] input, String error) {
        List<Integer> result = new ArrayList<>();
        try {
            for (int index = 0; index < input.length; index++) {
                int converted = Integer.parseInt(input[index]);
                result.add(converted);
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(error);
        }
        return result;
    }

    private static void validateLength(List<Integer> winningNumbers, String error) {
        if (winningNumbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(error);
        }
    }

    private static void validateRange(Integer number, String error) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(error);
        }
    }

    private static void validateDuplicate(List<Integer> numbers, String error) {
        List<Integer> checkDuplicate = new ArrayList<>();
        for (Integer number : numbers) {
            if (checkDuplicate.contains(number)) {
                throw new IllegalArgumentException(error);
            }
            checkDuplicate.add(number);
        }
    }

    public boolean contains(Integer number) {
        return winningNumbers.contains(number);
    }
}
