package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.enums.Bounds;
import lotto.enums.Message;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String numbers) {
        validateNumbersNotContainBlank(numbers);
        validateNumbersNotEndWithComma(numbers);
        validateNumbersCounts(numbers);
        List<Integer> winningNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .toList();
        validateUniqueness(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    private void validateUniqueness(List<Integer> numbers) {
        long distinctNumbers = numbers.stream()
                .distinct()
                .count();
        if (distinctNumbers != Bounds.MAX_LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(Message
                    .EXCEPTION_DUPLICATED_NUMBER
                    .getMessage());
        }
    }

    private void validateNumbersNotContainBlank(String numbers) {
        if (numbers.contains(" ")) {
            throw new IllegalArgumentException(Message
                    .EXCEPTION_WINNING_NUMBERS_CONTAINS_BLANK
                    .getMessage());
        }
    }

    private void validateNumbersNotEndWithComma(String numbers) {
        if (numbers.endsWith(",")) {
            throw new IllegalArgumentException(Message
                    .EXCEPTION_WINNING_NUMBERS_ENDS_WITH_COMMA
                    .getMessage());
        }
    }

    private void validateNumbersCounts(String numbers) {
        if (numbers.split(",").length != Bounds.MAX_LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(Message
                    .EXCEPTION_WINNING_NUMBERS_SIZE
                    .getMessage());
        }
    }
}
