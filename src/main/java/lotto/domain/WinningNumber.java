package lotto.domain;

import lotto.exception.*;

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
        isSizeWinningNumber(winningNumbers);
        isDuplicateWinningNumber(winningNumbers);
        isWinningNumberInRange(winningNumbers);

        return winningNumbers;
    }

    private void isNullWinningNumber(String number) {
        if (number.isEmpty()) {
            throw new MissingNumberException();
        }
    }

    private void isValidWinningNumber(String number) {
        if (!number.matches("^[0-9,]+$")) {
            throw new InvalidNumbersFormatException();
        }
    }

    private void isSizeWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != Constant.LOTTO_MAX_LENGTH) {
            throw new InvalidNumbersSizeException();
        }
    }

    private void isDuplicateWinningNumber(List<Integer> winningNumbers) {
        boolean hasDuplicates = winningNumbers.size() != new HashSet<>(winningNumbers).size();

        if (hasDuplicates) {
            throw new DuplicateNumberException();
        }
    }

    private void isWinningNumberInRange(List<Integer> winningNumbers) {
        boolean isInvalid = winningNumbers.stream()
                .anyMatch(number -> number < Constant.LOTTO_MIN_NUMBER || number > Constant.LOTTO_MAX_NUMBER);

        if (isInvalid) {
            throw new InvalidNumberRangeException();
        }
    }
}