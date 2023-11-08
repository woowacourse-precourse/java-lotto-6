package lotto.domain;

import lotto.exception.ErrorCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(String numbers) {
        this.numbers = verification(numbers);
    }

    public List<Integer> createWinningNumbers(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int winningNumberCount(Lotto lotto) {

        return (int) lotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    private List<Integer> verification(String number) {
        isNullWinningNumber(number);
        isValidWinningNumber(number);
        List<Integer> winningNumbers = createWinningNumbers(number);
        isLengthWinningNumber(winningNumbers);
        isDuplicateWinningNumber(winningNumbers);
        isWinningNumberInRange(winningNumbers);

        return winningNumbers;
    }

    private void isNullWinningNumber(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.MISSING_WINNING_NUMBERS.getMessage());
        }
    }

    private void isValidWinningNumber(String number) {
        if (!number.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException(ErrorCode.INVALID_WINNING_NUMBERS_FORMAT.getMessage());
        }
    }

    private void isLengthWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode.INVALID_WINNING_NUMBERS_SIZE.getMessage());
        }
    }

    private void isDuplicateWinningNumber(List<Integer> winningNumbers) {
        boolean hasDuplicates = winningNumbers.size() != new HashSet<>(winningNumbers).size();

        if (hasDuplicates) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }

    private void isWinningNumberInRange(List<Integer> winningNumbers) {
        boolean isInvalid = winningNumbers.stream()
                .anyMatch(number -> number < 1 || number > 45);

        if (isInvalid) {
            throw new IllegalArgumentException(ErrorCode.INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }
}