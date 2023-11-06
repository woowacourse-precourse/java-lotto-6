package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.util.ErrorMessage;

public class WinningNumber {

    private static final Pattern winningNumberInputPattern = Pattern.compile(
            "\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}");
    private List<Integer> winningNumbers;

    public void inputWinningNumber(String input) {
        validateWinningNumber(input);
        List<Integer> inputNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt).toList();
        validateNumberRange(inputNumbers);
        validateDuplication(inputNumbers);
        this.winningNumbers = inputNumbers;
    }

    private static void validateDuplication(List<Integer> inputNumbers) {
        Set<Integer> validateNumbers = new HashSet<>(inputNumbers);
        if (validateNumbers.size() < 6) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateNumberRange(List<Integer> inputNumbers) {
        for (Integer inputNumber : inputNumbers) {
            if (inputNumber < 1 || inputNumber > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private static void validateWinningNumber(String input) {
        if (!winningNumberInputPattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC.getMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
