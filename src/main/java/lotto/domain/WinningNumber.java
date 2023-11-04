package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;

public class WinningNumber {

    private static final String winningNumberDelimiter = ",";
    private static final int winningNumberCount = 6;

    private final List<Integer> numbers;

    private WinningNumber(List<Integer> numbers) {
        if (!hasCorrectSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage(winningNumberCount));
        }
        if (!hasCorrectRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_EXIST.getMessage());
        }
        this.numbers = Collections.unmodifiableList(numbers);
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numbersWithoutDuplicates = new HashSet<Integer>(numbers);

        return numbersWithoutDuplicates.size() != numbers.size();
    }

    private boolean hasCorrectRange(List<Integer> numbers) {
        return numbers.stream().noneMatch(number -> number < 1 || number > 45);
    }

    private boolean hasCorrectSize(List<Integer> numbers) {
        return numbers.size() == winningNumberCount;
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
