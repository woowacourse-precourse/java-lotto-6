package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.message.ErrorMessage;
import lotto.util.Validation;

public class WinningNumber {

    private static final String winningNumberDelimiter = ",";
    private static final int winningNumberCount = 6;

    private final List<Integer> numbers;

    private WinningNumber(List<Integer> numbers) {
        if (!Validation.hasCorrectSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage(winningNumberCount));
        }
        if (!Validation.hasCorrectRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
        if (Validation.hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_EXIST.getMessage());
        }
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static WinningNumber fromString(String input) {
        if (!hasCorrectFormat(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_FORMAT.getMessage());
        }
        List<Integer> numbers = parseString(input);
        return new WinningNumber(numbers);
    }

    private static boolean hasCorrectFormat(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) && c != ',') {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> parseString(String input) {
        String[] tokens = input.split(winningNumberDelimiter);
        try {
            return Arrays.stream(tokens).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
